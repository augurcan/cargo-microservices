package com.cargo.locationservice.controller;

import com.cargo.locationservice.dto.AddAddressRequest;
import com.cargo.locationservice.dto.LocationResponse;
import com.cargo.locationservice.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/location")
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping("/{locationId}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable String locationId){
        return ResponseEntity.ok(locationService.getLocationById(locationId));
    }
    @GetMapping
    public ResponseEntity<List<LocationResponse>> getAllLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
    }
    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable String locationId){
        locationService.deleteLocation(locationId);
        return ResponseEntity.ok("Location Deleted");
    }
    @PostMapping("/{locationId}/address")
    public ResponseEntity<LocationResponse> addAddress(@PathVariable String locationId,
                                                       @RequestBody AddAddressRequest addAddressRequest){
        return ResponseEntity.ok(locationService.addNewAddressToLocation(locationId,addAddressRequest));
    }
    @PutMapping("/{locationId}/address/{addressIndex}")
    public ResponseEntity<LocationResponse> updateAddress(@PathVariable String locationId,
                                                          @PathVariable int addressIndex,
                                                          @RequestBody AddAddressRequest addAddressRequest){
        return ResponseEntity.ok(locationService.updateAddress(locationId,addressIndex,addAddressRequest));
    }
}
