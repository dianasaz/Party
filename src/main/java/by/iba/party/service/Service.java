package by.iba.party.service;

import by.iba.party.exception.NoEntityException;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    T save(T entity);

    T findById(Integer id) throws NoEntityException;

    List<T> findAll();

    void deleteById(Integer id);
}
