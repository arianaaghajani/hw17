package ir.ariana.ir.service.loan;

import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.enums.LoanType;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Student;
import ir.ariana.ir.repository.loan.LoanRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

public class LoanServiceImpl extends BaseServiceImpl<Loan,Long, LoanRepository> implements LoanService{

    public LoanServiceImpl(LoanRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public boolean existOneLoanPaymentPerSemester(Student studentEntity, Integer semesterNumber, Grade grade, LoanType loanType) {
        return false;
    }

    @Override
    public boolean exist(Student student, Grade grade) {
        return repository.exist(student,grade);
    }

    @Override
    public LocalDate maxRecordDate(Student student) {
        return repository.maxRecordDate(student);
    }

    @Override
    public boolean existWifeHousingLoan(Student student, Grade grade) {
        return repository.existWifeTakeHousingLoan(student,grade);
    }
}
