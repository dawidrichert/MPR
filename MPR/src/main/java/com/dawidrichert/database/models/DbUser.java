package com.dawidrichert.database.models;

public class DbUser implements Indexable {

    private long id;
    private long personId;
    private String login;
    private String password;

    public DbUser(long id, long personId, String login, String password) {
        this(personId, login, password);
        this.id = id;
    }

    public DbUser(long personId, String login, String password) {
        this.personId = personId;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
