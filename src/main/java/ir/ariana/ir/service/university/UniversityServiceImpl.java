package ir.ariana.ir.service.university;

import ir.ariana.ir.model.University;
import ir.ariana.ir.repository.university.UniversityRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

public class UniversityServiceImpl extends BaseServiceImpl<University,Long, UniversityRepository>
        implements UniversityService{
    public UniversityServiceImpl(UniversityRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
