package by.issoft.serviceApi;

import by.issoft.exception.NoEntityException;

import java.util.List;

public interface Service<T> {
    T save(T entity);

    T findById(Integer id) throws NoEntityException;

    List<T> findAll();

    void deleteById(Integer id);
}
