package com.cargo.packageservice.dto.converter;

import com.cargo.packageservice.dto.PackageRequest;
import com.cargo.packageservice.dto.PackageResponse;
import com.cargo.packageservice.model.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageDtoConverter {
    public Package convertRequestToModel(PackageRequest packageRequest){
        return new Package(packageRequest.getSender(),
                packageRequest.getRecipient(),
                packageRequest.getContent(),
                packageRequest.getWeight(),
                packageRequest.getDimension(),
                packageRequest.getDeliveryService(),
                packageRequest.isDeliveryStatus(),
                packageRequest.getShippingFees(),
                packageRequest.getDeliveryAddress());
    }
    public PackageResponse convertModelToResponse(Package packageModel){
        return new PackageResponse(packageModel.getId(),
                packageModel.getSender(),
                packageModel.getRecipient(),
                packageModel.getContent(),
                packageModel.getWeight(),
                packageModel.getDimension(),
                packageModel.getDeliveryService(),
                packageModel.isDeliveryStatus(),
                packageModel.getShippingFees(),
                packageModel.getDeliveryAddress(),
                packageModel.getPickupDate(),
                packageModel.getDeliveryDate());
    }
}
