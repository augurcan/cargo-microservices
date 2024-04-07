package com.cargo.locationservice.dto;

import com.cargo.locationservice.model.Address;

import java.util.ArrayList;

public class LocationResponse{
    private String id;
    private String packageId;
    private ArrayList<Address> addressArrayList;
    private boolean deliveryStatus;

    public LocationResponse() {
    }

    public LocationResponse(String id, String packageId, ArrayList<Address> addressArrayList, boolean deliveryStatus) {
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

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
