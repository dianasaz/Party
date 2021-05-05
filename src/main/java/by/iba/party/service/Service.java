package by.iba.party.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    T save(T entity);

    Optional<T> findById(Integer id);

    List<T> findAll();

    void deleteById(Integer id);
}
