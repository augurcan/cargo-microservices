package com.cargo.packageservice.dto;

import javax.validation.constraints.NotBlank;

public class AddressDto {
    @NotBlank
    private String city;
    @NotBlank
    private String district;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String street;
    @NotBlank
    private String detail;

    public AddressDto() {
    }

    public AddressDto(String city, String district,
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
