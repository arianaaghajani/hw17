package ir.ariana.ir.service.student;

import ir.ariana.ir.model.Student;
import ir.ariana.ir.service.base.BaseService;

import java.util.Optional;

public interface StudentService extends BaseService<Student,Long> {
    Optional<Student> login(String username , String password);
    boolean existByUsername(String username);
    Optional<Student> showUsernameAndPasswordForNextSignUp(String username);
    boolean existByNationalCode(String nationalCode);
}
