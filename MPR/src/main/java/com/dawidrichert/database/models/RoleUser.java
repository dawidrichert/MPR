package com.dawidrichert.database.models;

public class RoleUser extends Entity {

    private long userId;
    private long roleId;

    public RoleUser(long id, long userId, long roleId) {
        this(userId, roleId);
        setId(id);
        setState(EntityState.Unchanged);
    }

    public RoleUser(long userId, long roleId) {
        super(EntityState.New);
        this.userId = userId;
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
