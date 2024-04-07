package com.cargo.locationservice.dto;

import com.cargo.locationservice.model.Address;

import java.util.ArrayList;

public class AddLocationRequest {
    private String packageId;
    private ArrayList<Address> addressList;
    private boolean deliveryStatus;

    public AddLocationRequest() {
    }

    public AddLocationRequest(String packageId, ArrayList<Address> addressList, boolean deliveryStatus) {
        this.packageId = packageId;
        this.addressList = addressList;
        this.deliveryStatus = deliveryStatus;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public ArrayList<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
