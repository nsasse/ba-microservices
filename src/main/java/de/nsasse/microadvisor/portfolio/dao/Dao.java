package de.nsasse.microadvisor.dao;

import java.util.List;

public interface Dao<T> {
    void create(T t);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    T findById(long id);
}
