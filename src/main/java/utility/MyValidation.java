package utility;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyValidation {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Pattern PEOPLE_NAME;
    private static final Pattern DATE;

    static {
        PEOPLE_NAME = Pattern.compile("[a-zA-Z]+");
        DATE = Pattern.compile("^\\d{4}[\\/\\-](0?[1-9]|1[012])[\\/\\-](0?[1-9]|[12][0-9]|3[01])$");
    }

    public static boolean isNameValid(String name) {
        Matcher matcher = PEOPLE_NAME.matcher(name);
        return matcher.matches();
    }


    private static boolean isDateValid(String date) {
        Matcher matcher = DATE.matcher(date);
        return matcher.matches();
    }

    public static LocalDate getDate(String announce, boolean updateFlag) {
        String input = "";
        while (true) {
            do {
                System.out.println(announce);
                input = scanner.nextLine();
                if (updateFlag && input.isEmpty()) return null;
            } while (input.isEmpty());
            if (MyValidation.isDateValid(input)) {
                break;
            }
        }
        LocalDate myDate = LocalDate.parse(input);
        return myDate;
    }



    public static boolean validationNationalCode(String nationalCode){
        Pattern pattern=Pattern.compile("^[0-9]{10}$");
        return nationalCode.matches(pattern.pattern());
    }

    public static String validationNationalNum(){
        String nationalCode = null;
        boolean isTrue =true;
        while (isTrue){

            nationalCode =scanner.next();
            if (validationNationalCode(nationalCode)){
                isTrue =false;
            }
            else {
                System.out.println("again Enter your nationalCode");
            }
        }
        return nationalCode;
    }

    public static boolean validationStudentNumber(String studentNumber){
        Pattern pattern=Pattern.compile("^[0-9]{8}$");
        return studentNumber.matches(pattern.pattern());
    }

    public static String validationStudentNum(){
        String studentNum = null;
        boolean isTrue =true;
        while (isTrue){

            studentNum =scanner.next();
            if (validationStudentNumber(studentNum)){
                isTrue =false;
            }
            else {
                System.out.println("again Enter your studentNumber");
            }
        }
        return studentNum;
    }

    public static boolean validationBankCardNumber(String bankCardNumber){
        Pattern pattern=Pattern.compile("^[0-9]{16}$");
        return bankCardNumber.matches(pattern.pattern());
    }

    public static String validationBankCardNum(){
        String bankCardNum = null;
        boolean isTrue =true;
        while (isTrue){

            bankCardNum =scanner.next();
            if (validationBankCardNumber(bankCardNum)){
                isTrue =false;
            }
            else {
                System.out.println("again Enter your bankCardNumber");
            }
        }
        return bankCardNum;
    }
}
