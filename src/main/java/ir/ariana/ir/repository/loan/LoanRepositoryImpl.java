package ir.ariana.ir.repository.loan;

import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.connection.SessionFactorySingleton;
import ir.ariana.ir.enums.Grade;
import ir.ariana.ir.enums.LoanType;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDate;

public class LoanRepositoryImpl extends BaseRepositoryImpl<Loan,Long> implements LoanRepository{
    public LoanRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }

    @Override
    public String getEntity() {
        return null;
    }

    @Override
    public boolean exist(Student student, Grade grade) {
        Query<Long> query = SessionFactorySingleton.getInstance().getCurrentSession()
                .createQuery("SELECT COUNT (i) FROM Loan i INNER JOIN Semester s ON i.semester.id=s.id" +
                        " WHERE s.student=:student AND s.grade=:grade AND i.loanType=:loanType", Long.class)
                .setParameter("student",student)
                .setParameter("grade",grade)
                .setParameter("loanType",LoanType.HOUSING_DEPOSIT);
        return query.getSingleResult()>=1;
    }

    @Override
    public boolean existWifeTakeHousingLoan(Student student, Grade grade) {
        Query<Long> query = SessionFactorySingleton.getInstance().getCurrentSession()
                .createQuery("SELECT COUNT (i) FROM Loan i INNER JOIN Semester s ON i.semester.id=s.id" +
                        " WHERE s.student=:student AND s.grade=:grade AND i.loanType=:loanType", Long.class)
                .setParameter("student",student)
                .setParameter("grade",grade)
                .setParameter("loanType",LoanType.HOUSING_DEPOSIT);
        return query.getSingleResult()>=1;
    }

    @Override
    public boolean existOneLoanPaymentPerSemester(Student student,Integer SemesterNumber, Grade grade, LoanType loanType) {
        Query<Long> query = SessionFactorySingleton.getInstance().getCurrentSession()
                .createQuery("SELECT COUNT (i) FROM Loan i INNER JOIN Semester s ON s.id=i.semester.id" +
                        " WHERE i.student=:student AND s.semesterNumber=:semesterNumber AND s.grade=:grade" +
                        " AND i.loanType=:loanType", Long.class)
                .setParameter("student",student)
                .setParameter("semesterNumber",SemesterNumber)
                .setParameter("grade",grade)
                .setParameter("loanType",loanType);

        return query.getSingleResult()>=1;
    }

    @Override
    public LocalDate maxRecordDate(Student student) {
        Query query = SessionFactorySingleton.getInstance().getCurrentSession()
                .createQuery("SELECT MAX (s.entriesYear) FROM Semester s WHERE s.student=:student")
                .setParameter("student", student);
        return (LocalDate) query.getSingleResult();
    }
}
