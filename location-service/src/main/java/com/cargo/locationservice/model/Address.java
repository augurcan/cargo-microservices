package com.cargo.locationservice.model;

public class Address {
    private String city;
    private String district;
    private String postalCode;
    private String street;
    private String detail;

    public Address() {
    }

    public Address(String city, String district,
                   String postalCode, String street,
                   String detail) {
        this.city = city;
        this.district = district;
        this.postalCode = postalCode;
        this.street = street;
        this.detail = detail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
