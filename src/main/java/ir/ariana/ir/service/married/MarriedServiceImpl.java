package ir.ariana.ir.service.married;

import ir.ariana.ir.model.Married;
import ir.ariana.ir.repository.married.MarriedRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

public class MarriedServiceImpl extends BaseServiceImpl<Married,Long, MarriedRepository>
        implements MarriedService{
    public MarriedServiceImpl(MarriedRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
