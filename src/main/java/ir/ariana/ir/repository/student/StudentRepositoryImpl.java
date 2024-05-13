package ir.ariana.ir.repository.student;


import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.connection.SessionFactorySingleton;
import ir.ariana.ir.model.Student;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student,Long> implements StudentRepository {
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public String getEntity() {
        return null;
    }

    @Override
    public Optional<Student> login(String username, String password) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        try {
            session.createQuery("SELECT COUNT (s) FROM Student s WHERE  s.username =: username " +
                            "AND s.password =:password ", Student.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return Optional.empty();
        }
        return null;
    }

    @Override
    public boolean existByUsername(String username) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        TypedQuery<Long> typedQuery = session.createQuery("SELECT COUNT (s) FROM Student s WHERE s.username =:username"
                , Long.class);
        typedQuery.setParameter("username",username);

        return typedQuery.getSingleResult() !=null;
    }



    @Override
    public Optional<Student> showUsernameAndPasswordForNextSignUp(String username) {
        CriteriaBuilder criteriaBuilder= SessionFactorySingleton.getInstance().getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery =criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot=criteriaQuery.from(Student.class);
         criteriaQuery.multiselect(studentRoot.get("username"),studentRoot.get("password"));
        CriteriaQuery<Student> select = criteriaQuery.select(studentRoot)
                .where(criteriaBuilder.equal(studentRoot.get("username"),username));

        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        Student result =session.createQuery(select).getSingleResult();

        return Optional.ofNullable(result);
    }

    @Override
    public boolean existByNationalCode(String nationalCode) {
        Session session = SessionFactorySingleton.getInstance().getCurrentSession();
        TypedQuery<Long> typedQuery = session.createQuery("SELECT COUNT (s) FROM Student s " +
                "WHERE s.nationalCode =: nationalCode" , Long.class);
        typedQuery.setParameter("nationalCode",nationalCode);

        return typedQuery.getSingleResult() >0;
    }
}
