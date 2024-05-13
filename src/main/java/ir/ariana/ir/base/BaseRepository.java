package ir.ariana.ir.base;

import ir.ariana.ir.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<ID>,ID extends Serializable>{

    T saveOrUpdate(T entity);
    Optional<T> findById(ID id);
    List<T> findAll();
}
