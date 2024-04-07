package com.cargo.locationservice.service;

import com.cargo.locationservice.dto.AddAddressRequest;
import com.cargo.locationservice.dto.AddLocationRequest;
import com.cargo.locationservice.dto.LocationResponse;
import com.cargo.locationservice.dto.converter.LocationDtoConverter;
import com.cargo.locationservice.exception.ResourceNotFoundException;
import com.cargo.locationservice.model.Address;
import com.cargo.locationservice.model.Location;
import com.cargo.locationservice.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationDtoConverter locationDtoConverter;

    public LocationService(LocationRepository locationRepository, LocationDtoConverter locationDtoConverter) {
        this.locationRepository = locationRepository;
        this.locationDtoConverter = locationDtoConverter;
    }
    public LocationResponse getLocationById(Long locationId){
        return locationDtoConverter.convertModelToResponse(findLocationById(locationId));
    }
    public List<LocationResponse> getAllLocations(){
        List<Location> locationList= locationRepository.findAll();
        return locationList.stream().map(locationDtoConverter::convertModelToResponse).collect(Collectors.toList());
    }

    public LocationResponse addNewAddressToLocation(Long locationId, AddAddressRequest addAddressRequest){
        Location location = findLocationById(locationId);
        location.getAddress().add(addAddressRequest.getAddress());
        location.setDeliveryStatus(addAddressRequest.isDeliveryStatus());
        locationRepository.save(location);
        return locationDtoConverter.convertModelToResponse(location);
    }
    public LocationResponse updateAddress(Long locationId,int addressIndex, AddAddressRequest addAddressRequest){
        Location location = findLocationById(locationId);
        if (addressIndex >= 0 && addressIndex < location.getAddress().size()) {
            Address addressToUpdate = location.getAddress().get(addressIndex);
            addressToUpdate.setDetail(addAddressRequest.getAddress().getDetail());
            addressToUpdate.setDistrict(addAddressRequest.getAddress().getDistrict());
            addressToUpdate.setPostalCode(addAddressRequest.getAddress().getPostalCode());
            addressToUpdate.setStreet(addAddressRequest.getAddress().getStreet());
            addressToUpdate.setCity(addAddressRequest.getAddress().getCity());
            locationRepository.save(location);
        } else {
            throw new IllegalArgumentException("Invalid address index");
        }
        return locationDtoConverter.convertModelToResponse(location);
    }
    public LocationResponse addLocation(AddLocationRequest addLocationRequest){
        Location location = locationDtoConverter.convertRequestToModel(addLocationRequest);
        locationRepository.save(location);
        return locationDtoConverter.convertModelToResponse(location);
    }
    public LocationResponse updateLocation(Long locationId, AddLocationRequest addLocationRequest){
        Location location = findLocationById(locationId);
        location.setPackageId(addLocationRequest.getPackageId());
        location.setAddress(addLocationRequest.getAddressList());
        location.setDeliveryStatus(addLocationRequest.isDeliveryStatus());
        locationRepository.save(location);
        return locationDtoConverter.convertModelToResponse(location);
    }
    public void deleteLocation(Long locationId){
        locationRepository.delete(findLocationById(locationId));
    }
    private Location findLocationById(Long locationId){
        return locationRepository.findById(locationId).orElseThrow(()->new ResourceNotFoundException("Location","Id",locationId));
    }
}
