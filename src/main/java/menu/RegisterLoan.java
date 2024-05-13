package menu;

import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.enums.InstallmentStatus;
import ir.ariana.ir.enums.LoanType;
import ir.ariana.ir.enums.UniversityType;
import ir.ariana.ir.model.Installment;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Semester;
import utility.ApplicationContext;

import java.time.LocalDate;
import java.util.Optional;

import static menu.LoanMenu.studentEntity;
import static utility.DataApplication.DATENOWAPLICATION;

public class RegisterLoan {
    static Optional<Semester> semester = ApplicationContext.getSemesterService().
            findSemesterByStudentId(studentEntity);

    static Semester semesterStudent = semester.get();

    static void saveTuitionLoan() {
        if (studentEntity.getUniversity().getUniversityType().equals(UniversityType.DOLATYROZANEH)) {
            System.out.println(" SORRY You will not receive a loan " +
                    "because your University is Daily :) ");
        } else {
            boolean existOneLoanPaymentPerSemester = ApplicationContext.getLoansService()
                    .existOneLoanPaymentPerSemester(studentEntity, semesterStudent.getSemesterNumber(),
                            semesterStudent.getGrade(), LoanType.TUITION);
            if (existOneLoanPaymentPerSemester) {
                System.out.println("<<<  You will not be granted a eduction loan " +
                        "because you have already received a education loan in the current semester :)  >>>\n");
            } else {
                Loan loan = null;
                Grade grade = semesterStudent.getGrade();
                if (grade.equals(Grade.ASSOCIATE) || grade.equals(Grade.BACHELORS) || grade.equals(Grade.DISCONTINUOUS_BACHELORS)) {

                    loan = new Loan(LoanType.TUITION, DATENOWAPLICATION, 1_300_000.00, studentEntity, semesterStudent);
                } else if (grade.equals(Grade.MASTERS) || grade.equals(Grade.MASTERS) ||
                        grade.equals(Grade.A_PROFESSIONAL_DOCTOR) || grade.equals(Grade.CONTINUOUS_PHD)) {
                    loan = new Loan(LoanType.TUITION, DATENOWAPLICATION, 2_600_000.00, studentEntity, semesterStudent);
                } else if (grade.equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE)) {
                    loan = new Loan(LoanType.TUITION, DATENOWAPLICATION, 6_500_000.00, studentEntity, semesterStudent);
                }
                Loan saveLoan = ApplicationContext.getLoansService().saveOrUpdate(loan);
                calculateInstallmentsStaggeredMannerBasedOnYear(saveLoan.getAmount(), saveLoan);
                System.out.println(" The loan was deposited into your account ");

            }
        }
    }
    static void saveEducationLoan() {
        boolean existOneLoanPaymentPerSemester = ApplicationContext.getLoansService()
                .existOneLoanPaymentPerSemester(studentEntity, semesterStudent.getSemesterNumber(),
                        semesterStudent.getGrade(),LoanType.EDUCATIONAL);
        if (existOneLoanPaymentPerSemester) {
            System.out.println(" You will not be granted a eduction loan " +
                    "because you have already received a education loan in the current semester ");
        } else {
            Loan loan = null;
            Grade grade = semesterStudent.getGrade();
            if (grade.equals(Grade.ASSOCIATE) || grade.equals(Grade.BACHELORS) || grade.equals(Grade.DISCONTINUOUS_BACHELORS)) {
                loan = new Loan(LoanType.EDUCATIONAL, DATENOWAPLICATION, 1_900_000.00, studentEntity,semesterStudent);
            } else if (grade.equals(Grade.MASTERS) || grade.equals(Grade.DISCONTINUOUS_MASTERS) ||
                    grade.equals(Grade.A_PROFESSIONAL_DOCTOR) || grade.equals(Grade.CONTINUOUS_PHD)) {
                loan = new Loan(LoanType.EDUCATIONAL, DATENOWAPLICATION, 2_250_000.00, studentEntity,semesterStudent);
            } else if (grade.equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE)) {
                loan = new Loan(LoanType.EDUCATIONAL, DATENOWAPLICATION, 2_600_000.00, studentEntity,semesterStudent);
            }
            Loan saveLoan = ApplicationContext.getLoansService().saveOrUpdate(loan);
            calculateInstallmentsStaggeredMannerBasedOnYear(saveLoan.getAmount(),saveLoan);
            System.out.println("The loan was deposited into your account ");
        }
    }



    private static void calculateInstallmentsStaggeredMannerBasedOnYear(Double loanAmount,Loan loan) {
        double interestRate = 0.04;
        int numberOfYears = 5;
        int numberOfMonths = numberOfYears * 12;
        double loanAmountByRate = loanAmount + loanAmount * interestRate;
        double installmentAmount = (loanAmountByRate / numberOfMonths);
        int installmentNumber = 1;


        LocalDate dueDate = null;
        Grade grade = semesterStudent.getGrade();
        if (grade.equals(Grade.BACHELORS) || grade.equals(Grade.DISCONTINUOUS_BACHELORS)) {
            dueDate = DATENOWAPLICATION.plusYears(4);

        } else if (grade.equals(Grade.ASSOCIATE) || grade.equals(Grade.DISCONTINUOUS_MASTERS)) {
            dueDate = DATENOWAPLICATION.plusYears(2);

        } else if (grade.equals(Grade.MASTERS)) {
            dueDate = DATENOWAPLICATION.plusYears(6);

        } else if (grade.equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE) ||
                grade.equals(Grade.A_PROFESSIONAL_DOCTOR) || grade.equals(Grade.CONTINUOUS_PHD)) {
            dueDate = DATENOWAPLICATION.plusYears(5);
        }
        for (int i = 1; i <= numberOfMonths; i++) {
            Installment installment = new Installment(installmentNumber, installmentAmount, dueDate,
                    null, InstallmentStatus.UNPAID, studentEntity,loan);
            ApplicationContext.getInstallmentService().saveOrUpdate(installment);
            if (i % 12 == 0) {
                installmentAmount *= 2;
            }
            dueDate = dueDate.plusMonths(1);
            installmentNumber++;
        }
    }

}
