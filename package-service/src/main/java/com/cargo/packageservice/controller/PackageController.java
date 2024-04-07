package com.cargo.packageservice.controller;

import com.cargo.packageservice.dto.PackageRequest;
import com.cargo.packageservice.dto.PackageResponse;
import com.cargo.packageservice.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/package")
public class PackageController {
    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }
    @GetMapping("/{packageId}")
    public ResponseEntity<PackageResponse> getPackageById(@PathVariable String packageId){
        return ResponseEntity.ok(packageService.getPackageById(packageId));
    }
    @GetMapping
    public ResponseEntity<List<PackageResponse>> getAllPackages(){
        return ResponseEntity.ok(packageService.getAllPackages());
    }
    @PostMapping
    public ResponseEntity<PackageResponse> addPackage(@RequestBody PackageRequest packageRequest){
        return ResponseEntity.ok(packageService.addPackage(packageRequest));
    }
    @PutMapping("/{packageId}")
    public ResponseEntity<PackageResponse> updatePackage(@PathVariable String packageId, @RequestBody PackageRequest packageRequest){
        return ResponseEntity.ok(packageService.updatePackage(packageId,packageRequest));
    }
    @DeleteMapping("/{packageId}")
    public ResponseEntity<String> deletePackage(@PathVariable String packageId){
        packageService.deletePackage(packageId);
        return ResponseEntity.ok("Package Deleted");
    }

}
