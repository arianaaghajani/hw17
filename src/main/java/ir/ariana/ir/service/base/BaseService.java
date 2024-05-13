package ir.ariana.ir.service.base;


import ir.ariana.ir.entity.BaseEntity;

import java.io.Serializable;

public interface BaseService<T extends BaseEntity<ID>,ID extends Serializable> {

    T saveOrUpdate(T entity);
}
