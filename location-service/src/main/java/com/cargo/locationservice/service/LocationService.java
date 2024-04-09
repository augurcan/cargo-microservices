package com.cargo.locationservice.service;

import com.cargo.locationservice.dto.AddAddressRequest;

import com.cargo.locationservice.dto.LocationResponse;
import com.cargo.locationservice.dto.converter.LocationDtoConverter;
import com.cargo.locationservice.exception.ResourceNotFoundException;
import com.cargo.locationservice.model.Address;
import com.cargo.locationservice.model.Location;
import com.cargo.locationservice.repository.LocationRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationDtoConverter locationDtoConverter;
    private final AmqpTemplate amqpTemplate;
    private final DirectExchange directExchange;

    public LocationService(LocationRepository locationRepository, LocationDtoConverter locationDtoConverter, AmqpTemplate amqpTemplate, DirectExchange directExchange) {
        this.locationRepository = locationRepository;
        this.locationDtoConverter = locationDtoConverter;
        this.amqpTemplate = amqpTemplate;
        this.directExchange = directExchange;
    }
    public LocationResponse getLocationById(String packageId){
        Location location = findByPackageId(packageId);
        return locationDtoConverter.convertModelToResponse(location);
    }
    public List<LocationResponse> getAllLocations(){
        List<Location> locationList= locationRepository.findAll();
        return locationList.stream().map(locationDtoConverter::convertModelToResponse).collect(Collectors.toList());
    }
    public LocationResponse addNewAddressToLocation(String packageId, AddAddressRequest addAddressRequest){
        Location location = findByPackageId(packageId);
        location.getAddress().add(addAddressRequest.getAddress());
        location.setDeliveryStatus(addAddressRequest.isDeliveryStatus());
        if(location.isDeliveryStatus())
            amqpTemplate.convertAndSend(directExchange.getName(),"statusRoute",location.getPackageId());
        locationRepository.save(location);
        return locationDtoConverter.convertModelToResponse(location);
    }
    public LocationResponse updateAddress(String packageId,int addressIndex, AddAddressRequest addAddressRequest){
        Location location = findByPackageId(packageId);
        if (addressIndex >= 0 && addressIndex < location.getAddress().size()) {
            Address addressToUpdate = location.getAddress().get(addressIndex);
            addressToUpdate.setDetail(addAddressRequest.getAddress().getDetail());
            addressToUpdate.setDistrict(addAddressRequest.getAddress().getDistrict());
            addressToUpdate.setPostalCode(addAddressRequest.getAddress().getPostalCode());
            addressToUpdate.setStreet(addAddressRequest.getAddress().getStreet());
            addressToUpdate.setCity(addAddressRequest.getAddress().getCity());
            location.setDeliveryStatus(addAddressRequest.isDeliveryStatus());
            locationRepository.save(location);
        } else {
            throw new IllegalArgumentException("Invalid address index");
        }
        return locationDtoConverter.convertModelToResponse(location);
    }
    @RabbitListener(queues = "locationAddQueue")
    public void addLocation(String packageId){
        Location location = new Location(packageId,new ArrayList<>(),false);
        locationRepository.save(location);
    }
    public void deleteLocation(String locationId){
        locationRepository.deleteById(locationId);
    }
    private Location findByPackageId(String packageId){
        Location location = locationRepository.findByPackageId(packageId);
        if(location==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location with the specified package ID not found");
        return location;
    }
}
