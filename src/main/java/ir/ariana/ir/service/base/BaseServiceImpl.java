package ir.ariana.ir.service.base;

import ir.ariana.ir.base.BaseRepository;
import ir.ariana.ir.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

@RequiredArgsConstructor
public class BaseServiceImpl <T extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseRepository<T,ID>>
        implements BaseService<T,ID> {

    protected final R repository;
    protected  final SessionFactory sessionFactory;

    @Override
    public T saveOrUpdate(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            T t = repository.saveOrUpdate(entity);
            transaction.commit();
            return t;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            return null;
        }
    }
}
