package menu;

import ir.ariana.ir.enums.Grade;
import utility.ApplicationContext;

import java.time.LocalDate;

import static menu.FirstMenu.scanner;
import static menu.LoanMenu.openMenuStudent;
import static menu.LoanMenu.studentEntity;
import static menu.RegisterLoan.semesterStudent;
import static utility.DataApplication.DATENOWAPLICATION;
import static utility.MyValidation.validationBankCardNum;

public class PaymentMenu {
    static void checkStudentGraduatedForRepaymentInstallment() {
        LocalDate entriesYear = semesterStudent.getEntriesYear();
        Grade grade = semesterStudent.getGrade();

        if (grade.equals(Grade.BACHELORS) || grade.equals(Grade.DISCONTINUOUS_BACHELORS)) {
            LocalDate plusYears = entriesYear.plusYears(4);
            if (DATENOWAPLICATION.isAfter(plusYears)) {
                payInstallmentByStudent();

            } else {
                System.out.println("Repayment have NOT been activated  Because You have Not graduated :) >>\n");
            }
        } else if (grade.equals(Grade.ASSOCIATE) || grade.equals(Grade.DISCONTINUOUS_MASTERS)) {
            LocalDate plusYears = entriesYear.plusYears(2);
            if (DATENOWAPLICATION.isAfter(plusYears)) {
                payInstallmentByStudent();
            } else {
                System.out.println(" << Repayment have NOT been activated Because You have Not graduated :) >>\n");
            }
        } else if (grade.equals(Grade.MASTERS)) {
            LocalDate plusYears = entriesYear.plusYears(6);
            if (DATENOWAPLICATION.isAfter(plusYears)) {
                payInstallmentByStudent();
            } else {
                System.out.println(" << Repayment have NOT been activated  Because You have Not graduated :) >> \n");
            }
        } else if (grade.equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE) || grade.equals(Grade.A_PROFESSIONAL_DOCTOR)
                || grade.equals(Grade.CONTINUOUS_PHD)) {
            LocalDate plusYears = entriesYear.plusYears(5);
            if (DATENOWAPLICATION.isAfter(plusYears)) {
                payInstallmentByStudent();
            } else {
                System.out.println("<< Repayment have NOT been activated  Because You have graduated :) >>\n");
            }
        }
    }

    static void payInstallmentByStudent() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("------------------------------------------");
            System.out.println("|       Installment Repayment Menu       |");
            System.out.println("----------------------------------------\n");
            System.out.println("1. Paid Installments ");
            System.out.println("2. UnPaid Installments");
            System.out.println("3. Payment Installment");
            System.out.println("4. return pervious menu");
            System.out.println("5. Exit");
            System.out.println("Enter your Select:");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> findPaidInstallment();
                case 2 -> findUnPaidInstallment();
                case 3 -> paymentInstallment();
                case 4 -> openMenuStudent();
                case 5 -> {
                    System.out.println("Good Bye :)");
                    isTrue = false;
                }
                default -> System.out.println("select Unvalid!!!");
            }
        }
    }

    private static void findUnPaidInstallment() {
    }

    private static void findPaidInstallment() {
    }

    private static void paymentInstallment() {
        while (true) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|     Enter your bank card information for Payment Installment  |");
            System.out.println("---------------------------------------------------------------\n");
            System.out.println("NumberCard:");
            String numberCard = validationBankCardNum();
            System.out.println("CVV2 :");
            String cvv2 = scanner.next();
            System.out.println("ExpirationDate");
            String expirationData = scanner.next();
            boolean card = ApplicationContext.getBankCardService()
                    .existBankCardByNumberCardAndCvvAndExpirationDate(studentEntity, numberCard, cvv2, expirationData);

        }
    }
}
