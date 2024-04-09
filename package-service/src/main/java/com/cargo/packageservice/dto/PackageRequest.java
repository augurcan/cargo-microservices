package com.cargo.packageservice.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PackageRequest {
    @NotNull
    @Valid
    private UserDto sender;
    @NotNull
    @Valid
    private UserDto recipient;
    @NotBlank
    private String content;
    @Positive
    private double weight;
    @NotBlank
    private String dimension;
    @NotBlank
    private String deliveryService;
    private boolean deliveryStatus;
    @Positive
    private double shippingFees;
    @NotNull
    @Valid
    private AddressDto deliveryAddress;

    public PackageRequest() {
    }

    public PackageRequest(UserDto sender,
                          UserDto recipient,
                          String content,
                          double weight,
                          String dimension,
                          String deliveryService,
                          boolean deliveryStatus,
                          double shippingFees,
                          AddressDto deliveryAddress) {
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.weight = weight;
        this.dimension = dimension;
        this.deliveryService = deliveryService;
        this.deliveryStatus = deliveryStatus;
        this.shippingFees = shippingFees;
        this.deliveryAddress = deliveryAddress;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public UserDto getRecipient() {
        return recipient;
    }

    public void setRecipient(UserDto recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public double getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public AddressDto getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressDto deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
