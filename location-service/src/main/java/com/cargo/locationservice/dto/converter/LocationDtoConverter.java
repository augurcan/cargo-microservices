package com.cargo.locationservice.dto.converter;

import com.cargo.locationservice.dto.LocationResponse;
import com.cargo.locationservice.model.Location;
import org.springframework.stereotype.Component;


@Component
public class LocationDtoConverter {
    public LocationResponse convertModelToResponse(Location location){
        return new LocationResponse(location.getId(),
                location.getPackageId(),
                location.getAddress(),
                location.isDeliveryStatus());
    }
}
