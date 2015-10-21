package com.dawidrichert.database.models;

public class DbAddress implements Indexable {

    private long id;
    private long userId;
    private String street;
    private String city;
    private String postalCode;
    private String province;
    private String country;

    public DbAddress(long id, long userId, String street, String city, String postalCode, String province, String country) {
        this(userId, street, city, postalCode, province, country);
        this.id = id;
    }
    public DbAddress(long userId, String street, String city, String postalCode, String province, String country) {
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
