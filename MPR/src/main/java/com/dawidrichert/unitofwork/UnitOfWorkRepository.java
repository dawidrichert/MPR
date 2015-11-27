package com.dawidrichert.unitofwork;

import com.dawidrichert.database.models.Entity;

public interface UnitOfWorkRepository<T extends Entity> {

    long persistAdd(T entity);
    void persistUpdate(T entity);
    void persistRemove(T entity);
}
