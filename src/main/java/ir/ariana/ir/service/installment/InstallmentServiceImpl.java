package ir.ariana.ir.service.installment;

import ir.ariana.ir.model.Installment;
import ir.ariana.ir.repository.installment.InstallmentRepository;
import ir.ariana.ir.service.base.BaseServiceImpl;
import org.hibernate.SessionFactory;

public class InstallmentServiceImpl extends BaseServiceImpl<Installment,Long, InstallmentRepository>
        implements InstallmentService{
    public InstallmentServiceImpl(InstallmentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
