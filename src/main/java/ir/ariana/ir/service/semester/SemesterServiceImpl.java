package ir.ariana.ir.service.semester;

import ir.ariana.ir.model.Semester;
import ir.ariana.ir.model.Student;
import ir.ariana.ir.repository.semester.SemesterRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class SemesterServiceImpl extends BaseServiceImpl<Semester,Long, SemesterRepository>
        implements SemesterService {

    public SemesterServiceImpl(SemesterRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Optional<Semester> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Semester> findAll() {
        return null;
    }

    @Override
    public Optional<Semester> findSemesterByStudentId(Student student) {
        return repository.findSemesterByStudentId(student);
    }

    @Override
    public Integer maxRecordSemesterNumber(Student student) {
        return repository.maxRecordSemesterNumber(student);
    }
}
