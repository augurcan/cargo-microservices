package com.cargo.locationservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Location {
    private Long id;
    private Long packageId;
    private ArrayList<Address> address;
    private boolean deliveryStatus;

    public Location() {
    }

    public Location(Long packageId, ArrayList<Address> address, boolean deliveryStatus) {
        this.packageId = packageId;
        this.address = address;
        this.deliveryStatus = deliveryStatus;
    }

    public Location(Long id, Long packageId, ArrayList<Address> address, boolean deliveryStatus) {
        this.id = id;
        this.packageId = packageId;
        this.address = address;
        this.deliveryStatus = deliveryStatus;
    }

    public Long getId() {
        return id;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public ArrayList<Address> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<Address> address) {
        this.address = address;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
