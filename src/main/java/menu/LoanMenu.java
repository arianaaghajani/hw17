package menu;


import ir.ariana.ir.enums.BankType;
import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.model.BankCard;
import ir.ariana.ir.model.Student;
import utility.ApplicationContext;

import java.time.LocalDate;

import static menu.FirstMenu.*;
import static menu.PaymentMenu.checkStudentGraduatedForRepaymentInstallment;
import static menu.RegisterLoan.*;
import static utility.DataApplication.DATENOWAPLICATION;
import static utility.MyValidation.validationBankCardNum;

public class LoanMenu {
    public static Student studentEntity = optionalStudent.get();

    private static void checkStudentGraduatedForRegisterLoan() {
        LocalDate entriesYear = semesterStudent.getEntriesYear();
        Grade grade = semesterStudent.getGrade();


        if (grade.equals(Grade.BACHELORS) || grade.equals(Grade.DISCONTINUOUS_BACHELORS)) {
            entriesYear = semesterStudent.getEntriesYear();
            LocalDate plusYears = entriesYear.plusYears(4);
            if (DATENOWAPLICATION.isBefore(plusYears)) {
                registeringStudentLoan();
            } else {
                System.out.println("<<< Student loan application is INACTIVE. You have graduated :)) >>>\n");
            }
        } else if (grade.equals(Grade.ASSOCIATE) || grade.equals(Grade.DISCONTINUOUS_MASTERS)) {
            LocalDate plusYears = entriesYear.plusYears(2);
            if (DATENOWAPLICATION.isBefore(plusYears)) {
                registeringStudentLoan();
            } else {
                System.out.println("<<< Student loan application is INACTIVE. You have graduated :)) >>>\n");
            }
        } else if (grade.equals(Grade.MASTERS)) {
            LocalDate plusYears = entriesYear.plusYears(6);
            if (DATENOWAPLICATION.isBefore(plusYears)) {
                registeringStudentLoan();
            } else {
                System.out.println(" <<< Student loan application is INACTIVE. You have graduated :)) >>>\n");
            }
        } else if (grade.equals(Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE) || grade.equals(Grade.A_PROFESSIONAL_DOCTOR) ||
                grade.equals(Grade.CONTINUOUS_PHD)) {
            LocalDate plusYears = entriesYear.plusYears(5);
            if (DATENOWAPLICATION.isBefore(plusYears)) {
                registeringStudentLoan();
            } else {
                System.out.println("<<< Student loan application is INACTIVE. You have graduated :)) >>>\n");
            }
        }
    }

    private static void registeringStudentLoan() {

        LocalDate startDateAban = LocalDate.of(DATENOWAPLICATION.getYear(), 8, 1);
        LocalDate endDateAban = startDateAban.plusWeeks(1);
        LocalDate startDateBahman = LocalDate.of(DATENOWAPLICATION.getYear(), 11, 25);
        LocalDate endDateBahman = startDateBahman.plusWeeks(1);

        if (!(((DATENOWAPLICATION.isAfter(startDateAban) || DATENOWAPLICATION.equals(startDateAban)) &&
                DATENOWAPLICATION.isBefore(endDateAban)) || ((DATENOWAPLICATION.isAfter(startDateBahman) ||
                DATENOWAPLICATION.equals(startDateBahman)) && DATENOWAPLICATION.isBefore(endDateBahman)))) {
            System.out.println("You are not allowed to register a loan on these dates :|");
            System.out.println("because The registration Date has passed :)\n");
        } else {
            if (ApplicationContext.getBankCardService().hasBankCardForStudent(studentEntity)) {
                openMenuLoan();
            } else {
                saveBankCardInformation();
                openMenuLoan();
            }
        }
    }

    protected static void openMenuStudent() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("------------------------------------------");
            System.out.println("|            Student Loan Menu           |");
            System.out.println("-----------------------------------------\n");
            System.out.println("1. Register Loan");
            System.out.println("2. installment Payment");
            System.out.println("3. return previous menu");
            System.out.println("4. Exit");
            System.out.println("Enter Your Select:");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> checkStudentGraduatedForRegisterLoan();
                case 2 -> checkStudentGraduatedForRepaymentInstallment();
                case 3 -> firstMenu();
                case 4 -> {
                    System.out.println("Good Bye :)))");
                    isTrue = false;
                }
                default -> System.out.println("Select UnValid!!!");
            }
        }
    }

    private static void saveBankCardInformation() {
        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("|     Enter your bank card information for save   |");

            System.out.println("The cards you register must be in one of the Meli ,Refah ,Tejarat or Maskan banks\n");
            System.out.println("BankName:");
            String bankName = scanner.next();
            BankType bankType = BankType.valueOf(bankName);
            System.out.println("NumberCard:");
            String numberCard = validationBankCardNum();
            System.out.println("ExpirationDate:");
            String expirationDate = scanner.next();
            System.out.println("ccv2 :");
            String ccv = scanner.next();
            Student student = new Student(studentEntity.getId());
            BankCard bankCard = new BankCard(numberCard,ccv,expirationDate,bankType,student);
            ApplicationContext.getBankCardService().saveOrUpdate(bankCard);
            boolean existsByNumberCard = ApplicationContext.getBankCardService().existByNumberCard(numberCard);
            if (existsByNumberCard) {
                System.out.println("BANKCARD SAVED :)\n");
                break;
            } else {
                System.out.println("BANKCARD UNSAVED :(");
                System.out.println("Please try again - - -");
            }
        }
    }
    private static void openMenuLoan() {
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("------------------------------------------");
            System.out.println("|             Loan Type Menu             |");
            System.out.println("----------------------------------------\n");
            System.out.println("1. Tuition Loan ");
            System.out.println("2. Education Loan");
            System.out.println("3. Housing Loan");
            System.out.println("4. return pervious menu");
            System.out.println("5. Exit");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> saveTuitionLoan();
                case 2 -> saveEducationLoan();
                case 3 -> saveHousingLoan();
                case 4 -> openMenuStudent();
                case 5 -> {
                    System.out.println("Good Bye :))");
                    isTrue=false;
                }
                default -> System.out.println("UnValid Select :|");
            }
        }
    }

    private static void saveHousingLoan() {
    }
}
