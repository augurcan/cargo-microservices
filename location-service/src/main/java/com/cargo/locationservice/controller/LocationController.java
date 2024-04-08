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
    @GetMapping("/package/{packageId}")
    public ResponseEntity<LocationResponse> getLocationByPackageId(@PathVariable String packageId){
        return ResponseEntity.ok(locationService.getLocationById(packageId));
    }
    @GetMapping("/package/")
    public ResponseEntity<List<LocationResponse>> getAllLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
    }
    @DeleteMapping("/{locationId}")
    public ResponseEntity<String> deleteLocation(@PathVariable String locationId){
        locationService.deleteLocation(locationId);
        return ResponseEntity.ok("Location Deleted");
    }
    @PostMapping("/package/{packageId}/address")
    public ResponseEntity<LocationResponse> addAddress(@PathVariable String packageId,
                                                       @RequestBody AddAddressRequest addAddressRequest){
        return ResponseEntity.ok(locationService.addNewAddressToLocation(packageId,addAddressRequest));
    }
    @PutMapping("/package/{packageId}/address/{addressIndex}")
    public ResponseEntity<LocationResponse> updateAddress(@PathVariable String packageId,
                                                          @PathVariable int addressIndex,
                                                          @RequestBody AddAddressRequest addAddressRequest){
        return ResponseEntity.ok(locationService.updateAddress(packageId,addressIndex,addAddressRequest));
    }
}
