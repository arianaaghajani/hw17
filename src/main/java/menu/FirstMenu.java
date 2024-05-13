package menu;

import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.model.Semester;
import ir.ariana.ir.model.Student;
import ir.ariana.ir.model.University;
import utility.ApplicationContext;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import static menu.LoanMenu.studentEntity;
import static utility.DataApplication.addDate;
import static utility.MyValidation.validationNationalNum;
import static utility.MyValidation.validationStudentNum;

public class FirstMenu {
    public static final Scanner scanner = new Scanner(System.in);
    public static Optional<Student> optionalStudent;

    public static void firstMenu() {
            System.out.println("***** MENU *****");
            System.out.println("1. SIGN IN");
            System.out.println("2. SIGN UP");
            System.out.println("3. EXIT");
            System.out.println("ENTER YOUR SELECT");
            try {
                int select =scanner.nextInt();
                scanner.nextLine();
                switch (select){
                    case 1 -> loginStudent();
                    case 2 -> signUp();
                    case 3 -> System.out.println("exit");
                    default -> System.out.println("unValid select");
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("wrong !!");
            }

    }

    private static void signUp() {
        System.out.println("-------please fill form -------");

        System.out.println("First name: ");
        String firstName = scanner.nextLine();

        System.out.println("Last name: ");
        String lastName = scanner.nextLine();

        System.out.println("father name");
        String fatherName = scanner.nextLine();

        System.out.println("mother name");
        String motherName = scanner.nextLine();

        System.out.println("national id number");
        Integer nationalIdNumber = scanner.nextInt();

        System.out.println("national Code");
        String nationalCode = validationNationalNum();

        System.out.println("birthDate");
        String date=scanner.next();
        LocalDate birthDate = addDate(date);

        System.out.println("student Number");
        String studentNumber = validationStudentNum();

        System.out.println("is married ?");
        String select =scanner.next();
        boolean married =select.equals("yes");

        System.out.println("is dormitory ?");
        String selectDormitory=scanner.next();
        boolean dormitory=selectDormitory.equals("yes");

        System.out.println("universityId");
        Long id=scanner.nextLong();

        University university=new University(id);
        Student student=new Student(firstName,lastName,fatherName,motherName,nationalIdNumber,nationalCode,
                birthDate,studentNumber,married,dormitory,university);

        Student newStudent =ApplicationContext.getStudentService().saveOrUpdate(student);
        boolean existsByNationalCode = ApplicationContext.getStudentService().existByNationalCode(nationalCode);

        if (existsByNationalCode){
            System.out.println("New student saved ");

            final Optional<Student> nexSignUp =ApplicationContext.getStudentService().
                    showUsernameAndPasswordForNextSignUp(newStudent.getUsername());

            System.out.println("username :" + nexSignUp.get().getUsername() + "password :" +
                    nexSignUp.get().getPassword());

            saveEducationStudent(newStudent);
        }else {
            System.out.println("NEW STUDENT DON'T SAVE");
        }
    }

    public static void loginStudent(){
        boolean isTrue=true;
        while (isTrue){
            System.out.println("Enter username: ");
            String username=scanner.next();
            boolean existsByUsername=ApplicationContext.getStudentService().existByUsername(username);
            if (!existsByUsername){
                System.out.println("don't find username ;)");
            }
            System.out.println("Enter password : ");
            String password =scanner.next();
            optionalStudent =ApplicationContext.getStudentService().login(username,password);
            if (optionalStudent.isEmpty()){
                System.out.println("username and password unCorrect!!");
                System.out.println("please try again");
            }else {
                System.out.println("do you save new education information? (y=yes ,n=NO");
                String select =scanner.next();
                if (select.equals("y")){
                    saveEducationStudent(studentEntity);
                }
                if (optionalStudent.isPresent()){
                    LoanMenu.openMenuStudent();
                    studentEntity=optionalStudent.get();
                    isTrue =false;

                }
            }
        }
    }
    public static void saveEducationStudent(Student student){
        System.out.println("--------");
        System.out.println("enteringYear");
        String enteringYear =scanner.next();
        LocalDate date = addDate(enteringYear);
        System.out.println("semester number");
        int semesterNumber=scanner.nextInt();
        System.out.println("grade");
        Grade grade=Grade.valueOf(scanner.next());
        University university=new University(student.getUniversity().getId());
        Semester semester=new Semester(semesterNumber,date,student,university,grade);
        ApplicationContext.getSemesterService().saveOrUpdate(semester);
        System.out.println("Education information saved ;)");
    }

}