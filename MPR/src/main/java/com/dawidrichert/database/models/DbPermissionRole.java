package com.dawidrichert.database.models;

public class DbPermissionRole implements Indexable {

    private long roleId;
    private long permissionId;

    public DbPermissionRole(long roleId, long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public long getId() {
        return roleId;
    }
}
