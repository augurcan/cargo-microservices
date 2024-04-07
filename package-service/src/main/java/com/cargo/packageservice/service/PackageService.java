package com.cargo.packageservice.service;

import com.cargo.packageservice.dto.PackageRequest;
import com.cargo.packageservice.dto.PackageResponse;
import com.cargo.packageservice.dto.converter.PackageDtoConverter;
import com.cargo.packageservice.exception.ResourceNotFoundException;
import com.cargo.packageservice.model.Package;
import com.cargo.packageservice.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackageService {
    private final PackageRepository packageRepository;
    private final PackageDtoConverter packageDtoConverter;

    public PackageService(PackageRepository packageRepository, PackageDtoConverter packageDtoConverter) {
        this.packageRepository = packageRepository;
        this.packageDtoConverter = packageDtoConverter;
    }
    public PackageResponse addPackage(PackageRequest packageRequest){
        Package packageModel = packageDtoConverter.convertRequestToModel(packageRequest);
        packageModel.setPickupDate(LocalDate.now());
        packageRepository.save(packageModel);
        return packageDtoConverter.convertModelToResponse(packageModel);
    }
    public void deletePackage(Long packageId){
        packageRepository.delete(findPackageById(packageId));
    }
    public PackageResponse updatePackage(Long packageId, PackageRequest packageRequest){
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
        return new PackageResponse();
    }
    public PackageResponse getPackageById(Long packageId){
        Package packageModel = findPackageById(packageId);
        return packageDtoConverter.convertModelToResponse(packageModel);
    }
    public List<PackageResponse> getAllPackages(){
        List<Package> packageList = packageRepository.findAll();
        return packageList.stream().map(packageDtoConverter::convertModelToResponse).collect(Collectors.toList());
    }
    private Package findPackageById(Long packageId){
        return packageRepository.findById(packageId).orElseThrow(()->new ResourceNotFoundException("Package","Id",packageId));
    }
}
