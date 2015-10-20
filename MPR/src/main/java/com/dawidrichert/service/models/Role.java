package com.dawidrichert.service.models;

import java.util.Collection;

public class Role {

    private long id;
    private String name;
    private Collection<Permission> permissions;

    public Role(long id, String name, Collection<Permission> permissions) {
        this(name, permissions);
        this.id = id;
    }

    public Role(String name, Collection<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
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

    public Collection<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }
}
