package ir.ariana.ir.service.semester;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.model.Semester;
import ir.ariana.ir.model.Student;

import java.util.Optional;

public interface SemesterService extends BaseRepository<Semester,Long> {
    Optional<Semester> findSemesterByStudentId(Student student);
    Integer maxRecordSemesterNumber(Student student);
}
