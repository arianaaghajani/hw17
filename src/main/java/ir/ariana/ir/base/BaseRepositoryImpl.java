package ir.ariana.ir.base;

import ir.ariana.ir.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseRepositoryImpl<T extends BaseEntity<ID>,ID extends Serializable>
        implements BaseRepository<T,ID> {
    private final SessionFactory sessionFactory;

    public BaseRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

   @Override
    public T saveOrUpdate(T entity){
       Session session=sessionFactory.getCurrentSession();
       if (entity.getId() == null)
           session.persist(entity);
       else
           entity=session.merge(entity);
       return entity;
   }
    @Override
    public Optional<T> findById(ID id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(getEntityClass(), id));
    }
    public abstract Class<T> getEntityClass();

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<T> query = session.createQuery(String.format("from %s", getEntity()), getEntityClass());
        return query.getResultList();
    }

    public abstract String getEntity();
}
