package com.dawidrichert.service.models;

import java.util.Collection;

public class User {

    private long id;
    private String login;
    private String password;
    private Person person;
    private Collection<Address> addresses;
    private Collection<Role> roles;

    public User(long id, String login, String password, Person person, Collection<Address> addresses, Collection<Role> roles) {
        this(login, password, person, addresses, roles);
        this.id = id;
    }

    public User(String login, String password, Person person, Collection<Address> addresses, Collection<Role> roles) {
        this.login = login;
        this.password = password;
        this.person = person;
        this.addresses = addresses;
        this.roles = roles;
    }

    public long getId() {
        return id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
