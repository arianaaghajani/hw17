package ir.ariana.ir.repository.installment;

import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.connection.SessionFactorySingleton;
import ir.ariana.ir.enums.InstallmentStatus;
import ir.ariana.ir.model.Installment;
import ir.ariana.ir.model.Loan;
import ir.ariana.ir.model.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class InstallmentRepositoryImpl extends BaseRepositoryImpl<Installment,Long>
        implements InstallmentRepository{
    public InstallmentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Installment> getEntityClass() {
        return null;
    }

    @Override
    public String getEntity() {
        return null;
    }


    @Override
    public List<Installment> findPaidInstallment(Student student, Loan loan, InstallmentStatus installmentStatus) {
        CriteriaBuilder criteriaBuilder = SessionFactorySingleton.getInstance().getCriteriaBuilder();
        CriteriaQuery<Installment> criteriaQuery = criteriaBuilder.createQuery(Installment.class);
        Root<Installment> installmentRoot = criteriaQuery.from(Installment.class);
        criteriaQuery.multiselect(installmentRoot.get("paymentDate"), installmentRoot.get("installmentNumber"));
        CriteriaQuery<Installment> select = criteriaQuery.select(installmentRoot)
                .where(criteriaBuilder.equal(installmentRoot.get("student"), student),
                        criteriaBuilder.equal(installmentRoot.get("loan"), loan),
                        criteriaBuilder.equal(installmentRoot.get("status"), installmentStatus));


        return null;
    }

    @Override
    public List<Installment> findUnPaidInstallment(Student student, Loan loan, InstallmentStatus installmentStatus) {
        return null;
    }

    @Override
    public Optional<Installment> findByStudentId(Long id, Student student) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        return Optional
                .ofNullable(session.createQuery("SELECT i FROM Installment i WHERE i.student =:student" +
                        "AND i.id=:id" ,Installment.class)
                        .setParameter("student",student)
                        .setParameter("id",id)
                        .getSingleResult());
    }

    @Override
    public Double sumAllLoanAmountPerStudent(Student student) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Query<Double> query = session.createQuery("SELECT SUM (i.amount) FROM Loan i WHERE i.student =: student",
                Double.class)
                        .setParameter("student",student);
                return query.getSingleResult();
    }
}
