package ir.ariana.ir.repository.semester;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.model.Semester;
import ir.ariana.ir.model.Student;

import java.util.Optional;


public interface SemesterRepository extends BaseRepository<Semester,Long> {
    Optional<Semester> findSemesterByStudentId(Student student);
    Integer maxRecordSemesterNumber(Student student);

}
