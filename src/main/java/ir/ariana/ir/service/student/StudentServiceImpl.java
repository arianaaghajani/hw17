package ir.ariana.ir.service.student;


import ir.ariana.ir.model.Student;
import ir.ariana.ir.repository.student.StudentRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

import java.util.Optional;

public class StudentServiceImpl extends BaseServiceImpl<Student,Long, StudentRepository> implements StudentService {
    public StudentServiceImpl(StudentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public Optional<Student> login(String username, String password) {
        return repository.login(username,password);
    }

    @Override
    public boolean existByUsername(String username) {
        return repository.existByUsername(username);
    }

    @Override
    public Optional<Student> showUsernameAndPasswordForNextSignUp(String username) {
        return repository.showUsernameAndPasswordForNextSignUp(username);
    }

    @Override
    public boolean existByNationalCode(String nationalCode) {
        return repository.existByNationalCode(nationalCode);
    }
}
