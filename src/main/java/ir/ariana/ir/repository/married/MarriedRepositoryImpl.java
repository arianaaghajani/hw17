package ir.ariana.ir.repository.married;

import ir.ariana.ir.base.BaseRepositoryImpl;
import ir.ariana.ir.model.Married;
import org.hibernate.SessionFactory;

public class MarriedRepositoryImpl extends BaseRepositoryImpl<Married,Long> implements MarriedRepository{
    public MarriedRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Married> getEntityClass() {
        return Married.class;
    }

    @Override
    public String getEntity() {
        return null;
    }
}
