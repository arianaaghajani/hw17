package ir.ariana.ir.repository.university;

import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.model.University;
import org.hibernate.SessionFactory;

public class UniversityRepositoryImpl extends BaseRepositoryImpl<University,Long> implements UniversityRepository{
    public UniversityRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<University> getEntityClass() {
        return University.class;
    }

    @Override
    public String getEntity() {
        return null;
    }
}
