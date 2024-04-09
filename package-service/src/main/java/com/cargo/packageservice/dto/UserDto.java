package com.cargo.packageservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String email;
    @NotNull
    private Long identificationNumber;

    public UserDto() {
    }

    public UserDto(String name, String surname,
                   String phoneNumber, String email,
                   Long identificationNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
