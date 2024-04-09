package com.cargo.locationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Document
public class Location {
    @Id
    private String id;
    @NotBlank
    private String packageId;
    @NotNull
    private ArrayList<Address> address;
    private boolean deliveryStatus;

    public Location() {
    }


    public Location(String packageId, ArrayList<Address> address, boolean deliveryStatus) {
        this.packageId = packageId;
        this.address = address;
        this.deliveryStatus = deliveryStatus;
    }

    public Location(String id, String packageId, ArrayList<Address> address, boolean deliveryStatus) {
        this.id = id;
        this.packageId = packageId;
        this.address = address;
        this.deliveryStatus = deliveryStatus;
    }

    public String getId() {
        return id;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
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
