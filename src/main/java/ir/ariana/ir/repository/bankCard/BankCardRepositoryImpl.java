package ir.ariana.ir.repository.bankCard;

import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.connection.SessionFactorySingleton;
import ir.ariana.ir.model.BankCard;
import ir.ariana.ir.model.Student;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BankCardRepositoryImpl extends BaseRepositoryImpl<BankCard, Long> implements BankCardRepository {
    public BankCardRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<BankCard> getEntityClass() {
        return null;
    }

    @Override
    public String getEntity() {
        return null;
    }

    @Override
    public boolean existByNumberCard(String numberCard) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        TypedQuery<Long> typedQuery = session.createQuery("SELECT COUNT (b) FROM BankCard b WHERE b.numberCard =: numberCard", Long.class)
                .setParameter("numberCard", numberCard);

        return typedQuery.getSingleResult() > 0;
    }

    @Override
    public boolean existBankCardByNumberCardAndCvvAndExpirationDate(Student student, String numberCard, String cvv2,
                                                                    String expirationDate) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        TypedQuery<Long> typedQuery = session.createQuery("SELECT COUNT (b) FROM BankCard b WHERE b.numberCard =: numberCard AND b.cvv2=: cvv2 AND " +
                        "b.expirationDate =: expirationDate AND b.student =: student", Long.class)
                .setParameter("numberCard", numberCard)
                .setParameter("cvv2", cvv2)
                .setParameter("expirationDate", expirationDate)
                .setParameter("student", student);
        return typedQuery.getSingleResult() > 0;
    }

    @Override
    public boolean hasBankCardForStudent(Student student) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        TypedQuery<Long> typedQuery = session.createQuery("SELECT COUNT (b) FROM BankCard b WHERE b.student=: student",
                        Long.class)
                .setParameter("student", student);
        return typedQuery.getSingleResult() >= 1;
    }
}
