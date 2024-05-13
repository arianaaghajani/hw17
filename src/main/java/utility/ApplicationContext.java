package utility;

import ir.ariana.ir.connection.SessionFactorySingleton;
import ir.ariana.ir.repository.bankCard.BankCardRepository;
import ir.ariana.ir.repository.bankCard.BankCardRepositoryImpl;
import ir.ariana.ir.repository.installment.InstallmentRepository;
import ir.ariana.ir.repository.installment.InstallmentRepositoryImpl;
import ir.ariana.ir.repository.loan.LoanRepository;
import ir.ariana.ir.repository.loan.LoanRepositoryImpl;
import ir.ariana.ir.repository.married.MarriedRepository;
import ir.ariana.ir.repository.married.MarriedRepositoryImpl;
import ir.ariana.ir.repository.semester.SemesterRepository;
import ir.ariana.ir.repository.semester.SemesterRepositoryImpl;
import ir.ariana.ir.repository.student.StudentRepository;
import ir.ariana.ir.repository.student.StudentRepositoryImpl;
import ir.ariana.ir.repository.university.UniversityRepository;
import ir.ariana.ir.repository.university.UniversityRepositoryImpl;
import ir.ariana.ir.service.bankCard.BankCardService;
import ir.ariana.ir.service.bankCard.BankCardServiceImpl;
import ir.ariana.ir.service.installment.InstallmentService;
import ir.ariana.ir.service.installment.InstallmentServiceImpl;
import ir.ariana.ir.service.loan.LoanService;
import ir.ariana.ir.service.loan.LoanServiceImpl;
import ir.ariana.ir.service.married.MarriedService;
import ir.ariana.ir.service.married.MarriedServiceImpl;
import ir.ariana.ir.service.semester.SemesterService;
import ir.ariana.ir.service.semester.SemesterServiceImpl;
import ir.ariana.ir.service.student.StudentService;
import ir.ariana.ir.service.student.StudentServiceImpl;
import ir.ariana.ir.service.university.UniversityService;
import ir.ariana.ir.service.university.UniversityServiceImpl;
import org.hibernate.SessionFactory;

public class ApplicationContext {
    private static final SessionFactory SESSION_FACTORY;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final LoanRepository LOAN_REPOSITORY;
    private static final MarriedRepository MARRIED_REPOSITORY;
    private static final SemesterRepository SEMESTER_REPOSITORY;
    private static final UniversityRepository UNIVERSITY_REPOSITORY;
    private static final InstallmentRepository INSTALLMENT_REPOSITORY;
    private static final BankCardRepository BANK_CARD_REPOSITORY;


    private static final StudentService STUDENT_SERVICE;
    private static final LoanService LOAN_SERVICE;
    private static final InstallmentService INSTALLMENT_SERVICE;
    private static final UniversityService UNIVERSITY_SERVICE;
    private static final SemesterService SEMESTER_SERVICE;
    private static final MarriedService MARRIED_SERVICE;
    private static final BankCardService BANK_CARD_SERVICE;


    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();

        STUDENT_REPOSITORY = new StudentRepositoryImpl(SESSION_FACTORY);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY, SESSION_FACTORY);

        LOAN_REPOSITORY = new LoanRepositoryImpl(SESSION_FACTORY);
        LOAN_SERVICE = new LoanServiceImpl(LOAN_REPOSITORY, SESSION_FACTORY);

        SEMESTER_REPOSITORY = new SemesterRepositoryImpl(SESSION_FACTORY);
        SEMESTER_SERVICE = new SemesterServiceImpl(SEMESTER_REPOSITORY, SESSION_FACTORY);

        UNIVERSITY_REPOSITORY = new UniversityRepositoryImpl(SESSION_FACTORY);
        UNIVERSITY_SERVICE = new UniversityServiceImpl(UNIVERSITY_REPOSITORY, SESSION_FACTORY);

        BANK_CARD_REPOSITORY = new BankCardRepositoryImpl(SESSION_FACTORY);
        BANK_CARD_SERVICE = new BankCardServiceImpl(BANK_CARD_REPOSITORY, SESSION_FACTORY);

        MARRIED_REPOSITORY = new MarriedRepositoryImpl(SESSION_FACTORY);
        MARRIED_SERVICE = new MarriedServiceImpl(MARRIED_REPOSITORY, SESSION_FACTORY);

        INSTALLMENT_REPOSITORY = new InstallmentRepositoryImpl(SESSION_FACTORY);
        INSTALLMENT_SERVICE = new InstallmentServiceImpl(INSTALLMENT_REPOSITORY, SESSION_FACTORY);

    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }

    public static LoanService getLoansService() {
        return LOAN_SERVICE;
    }

    public static UniversityService getUniversityService() {
        return UNIVERSITY_SERVICE;
    }

    public static InstallmentService getInstallmentService() {
        return INSTALLMENT_SERVICE;
    }

    public static BankCardService getBankCardService() {
        return BANK_CARD_SERVICE;
    }

    public static MarriedService getMarriedService() {
        return MARRIED_SERVICE;
    }
    public static SemesterService getSemesterService(){
        return SEMESTER_SERVICE;
    }
}