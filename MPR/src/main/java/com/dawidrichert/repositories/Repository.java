package com.dawidrichert.repositories;

import java.util.Collection;

public interface Repository<T> {

    T getById(long id);
    Collection<T> getAll();
    void add(T item);
    void remove(T item);
    void removeAll();
    void update(T item);
}
