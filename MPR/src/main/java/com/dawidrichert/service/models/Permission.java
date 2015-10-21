package com.dawidrichert.service.models;

public class Permission {

    private long id;
    private String name;

    public Permission(long id, String name) {
        this(name);
        this.id = id;
    }

    public Permission(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
