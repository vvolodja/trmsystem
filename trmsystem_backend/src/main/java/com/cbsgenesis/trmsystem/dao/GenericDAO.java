package com.cbsgenesis.trmsystem.dao;

import java.util.Collection;

/**
 * Generic DAO interface that contains basic functionality (Create, Read, etc.).
 *
 * @author Eugene Suleimanov
 */
public interface GenericDAO<T, ID> {

    void save(T entity);

    T getById(ID id);

    Collection<T> getAll();

    void delete(T entity);
}
