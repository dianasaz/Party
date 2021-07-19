package by.issoft.serviceModule.service;

import by.issoft.exception.NoEntityException;

import java.util.List;

public interface Service<T> {
    T save(T entity);

    T findById(Integer id) throws NoEntityException;

    List<T> findAll();

    void deleteById(Integer id);
}
