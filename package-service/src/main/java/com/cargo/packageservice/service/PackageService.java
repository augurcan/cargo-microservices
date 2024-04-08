package com.cargo.packageservice.service;

import com.cargo.packageservice.dto.PackageRequest;
import com.cargo.packageservice.dto.PackageResponse;
import com.cargo.packageservice.dto.converter.PackageDtoConverter;
import com.cargo.packageservice.exception.ResourceNotFoundException;
import com.cargo.packageservice.model.Package;
import com.cargo.packageservice.repository.PackageRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageService {
    private final PackageRepository packageRepository;
    private final PackageDtoConverter packageDtoConverter;
    private final AmqpTemplate amqpTemplate;
    private final DirectExchange directExchange;

    public PackageService(PackageRepository packageRepository, PackageDtoConverter packageDtoConverter, AmqpTemplate amqpTemplate, DirectExchange directExchange) {
        this.packageRepository = packageRepository;
        this.packageDtoConverter = packageDtoConverter;
        this.amqpTemplate = amqpTemplate;
        this.directExchange = directExchange;
    }
    public PackageResponse addPackage(PackageRequest packageRequest){
        Package packageModel = packageDtoConverter.convertRequestToModel(packageRequest);
        packageModel.setPickupDate(LocalDate.now());
        packageRepository.save(packageModel);
        amqpTemplate.convertAndSend(directExchange.getName(),"locationAddRoute",packageModel.getId());
        amqpTemplate.convertAndSend(directExchange.getName(),"userRoute",packageModel.getSender());
        amqpTemplate.convertAndSend(directExchange.getName(),"userRoute",packageModel.getRecipient());
        return packageDtoConverter.convertModelToResponse(packageModel);
    }
    public void deletePackage(String packageId){
        packageRepository.delete(findPackageById(packageId));
    }
    public PackageResponse updatePackage(String packageId, PackageRequest packageRequest){
        Package packageModel = findPackageById(packageId);
        packageModel.setSender(packageRequest.getSender());
        packageModel.setRecipient(packageRequest.getRecipient());
        packageModel.setContent(packageRequest.getContent());
        packageModel.setWeight(packageRequest.getWeight());
        packageModel.setDimension(packageRequest.getDimension());
        packageModel.setDeliveryService(packageRequest.getDeliveryService());
        packageModel.setDeliveryStatus(packageRequest.isDeliveryStatus());
        packageModel.setShippingFees(packageRequest.getShippingFees());
        packageModel.setDeliveryAddress(packageRequest.getDeliveryAddress());
        packageRepository.save(packageModel);
        return packageDtoConverter.convertModelToResponse(packageModel);
    }
    public PackageResponse getPackageById(String packageId){
        Package packageModel = findPackageById(packageId);
        return packageDtoConverter.convertModelToResponse(packageModel);
    }
    public List<PackageResponse> getAllPackages(){
        List<Package> packageList = packageRepository.findAll();
        return packageList.stream().map(packageDtoConverter::convertModelToResponse).collect(Collectors.toList());
    }
    private Package findPackageById(String packageId){
        return packageRepository.findById(packageId).orElseThrow(()->new ResourceNotFoundException("Package","Id",packageId));
    }
}
