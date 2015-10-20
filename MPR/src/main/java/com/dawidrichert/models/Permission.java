package com.dawidrichert.models;

public class Permission {

    private long id;
    private String name;

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
