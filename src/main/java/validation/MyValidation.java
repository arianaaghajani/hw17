package validation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MyValidation {
    public static Scanner scanner=new Scanner(System.in);
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
                System.out.println("Enter validation nationalCode");
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
                System.out.println("Enter validation studentNumber");
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
            if (validationStudentNumber(bankCardNum)){
                isTrue =false;
            }
            else {
                System.out.println("Enter validation bankCardNumber");
            }
        }
        return bankCardNum;
    }
}
