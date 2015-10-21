package com.dawidrichert.database.models;

public class DbPermission implements Indexable {

    private long id;
    private String name;

    public DbPermission(long id, String name) {
        this(name);
        this.id = id;
    }

    public DbPermission(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
