package com.cargo.locationservice.dto;

import com.cargo.locationservice.model.Address;

public class AddAddressRequest{
    private Address address;
    private boolean deliveryStatus;

    public AddAddressRequest() {
    }

    public AddAddressRequest(Address address, boolean deliveryStatus) {
        this.address = address;
        this.deliveryStatus = deliveryStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
