package com.dawidrichert.database.models;

public abstract class Entity {

    private long id;
    private EntityState state;

    public Entity(EntityState entityState) {
        this.state = entityState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EntityState getState() {
        return state;
    }

    public void setState(EntityState state) {
        this.state = state;
    }
}
