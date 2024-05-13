package ir.ariana.ir.repository.student;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.model.Student;

import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student,Long> {

    Optional<Student> login(String username , String password);
    boolean existByUsername(String username);
    Optional<Student> showUsernameAndPasswordForNextSignUp(String username);
    boolean existByNationalCode(String nationalCode);
}
