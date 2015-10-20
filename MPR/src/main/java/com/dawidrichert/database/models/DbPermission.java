package com.dawidrichert.database.models;

public class DbPermission implements Indexable {

    private long id;
    private long roleId;
    private String name;

    public DbPermission(long id, long roleId, String name) {
        this.id = id;
        this.roleId = roleId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
