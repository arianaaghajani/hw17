package ir.ariana.ir.repository.semester;

import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.connection.SessionFactorySingleton;
import ir.ariana.ir.model.Semester;
import ir.ariana.ir.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Optional;

public class SemesterRepositoryImpl extends BaseRepositoryImpl<Semester,Long> implements SemesterRepository{
    public SemesterRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Semester> getEntityClass() {
        return Semester.class;
    }

    @Override
    public String getEntity() {
        return null;
    }

    @Override
    public Optional<Semester> findSemesterByStudentId(Student student) {
        Query<Semester> query = SessionFactorySingleton.getInstance().getCurrentSession()
                .createQuery("SELECT s FROM Semester s WHERE s.student =: student AND s.id =:id",
                        Semester.class)
                .setParameter("student",student)
                .setParameter("id",maxRecordSemesterNumber(student));

        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Integer maxRecordSemesterNumber(Student student) {
        Query<Integer> max = SessionFactorySingleton.getInstance().getCurrentSession()
                .createQuery("SELECT MAX (s.id) FROM Semester s WHERE s.student=:student", Integer.class)
                .setParameter("student",student);
        return max.getSingleResult();
    }

}
