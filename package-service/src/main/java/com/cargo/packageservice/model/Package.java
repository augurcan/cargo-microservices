package com.cargo.packageservice.model;

import com.cargo.packageservice.dto.UserDto;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Package {
    private Long id;
    private UserDto sender;
    private UserDto recipient;
    private String content;
    private double weight;
    private String dimension;
    private String deliveryService;
    private boolean deliveryStatus;
    private double shippingFees;
    private String deliveryAddress;
    private LocalDate pickupDate;
    private LocalDate deliveryDate;

    public Package() {
    }

    public Package(UserDto sender, UserDto recipient,
                   String content, double weight,
                   String dimension, String deliveryService,
                   boolean deliveryStatus, double shippingFees,
                   String deliveryAddress) {
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

    public Package(Long id, UserDto sender,
                   UserDto recipient, String content,
                   double weight, String dimension,
                   String deliveryService, boolean deliveryStatus,
                   double shippingFees, String deliveryAddress,
                   LocalDate pickupDate, LocalDate deliveryDate) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.weight = weight;
        this.dimension = dimension;
        this.deliveryService = deliveryService;
        this.deliveryStatus = deliveryStatus;
        this.shippingFees = shippingFees;
        this.deliveryAddress = deliveryAddress;
        this.pickupDate = pickupDate;
        this.deliveryDate = deliveryDate;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public double getShippingFees() {
        return shippingFees;
    }

    public void setShippingFees(double shippingFees) {
        this.shippingFees = shippingFees;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryService() {
        return deliveryService;
    }

    public void setDeliveryService(String deliveryService) {
        this.deliveryService = deliveryService;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDto getRecipient() {
        return recipient;
    }

    public void setRecipient(UserDto recipient) {
        this.recipient = recipient;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }
}
