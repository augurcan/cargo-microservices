package com.cargo.locationservice.dto;

import com.cargo.locationservice.model.Address;

import java.util.ArrayList;

public class LocationResponse{
    private Long id;
    private Long packageId;
    private ArrayList<Address> addressArrayList;
    private boolean deliveryStatus;

    public LocationResponse() {
    }

    public LocationResponse(Long id, Long packageId, ArrayList<Address> addressArrayList, boolean deliveryStatus) {
        this.id = id;
        this.packageId = packageId;
        this.addressArrayList = addressArrayList;
        this.deliveryStatus = deliveryStatus;
    }

    public ArrayList<Address> getAddressArrayList() {
        return addressArrayList;
    }

    public void setAddressArrayList(ArrayList<Address> addressArrayList) {
        this.addressArrayList = addressArrayList;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
