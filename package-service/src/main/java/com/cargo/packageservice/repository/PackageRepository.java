package com.cargo.packageservice.repository;

import com.cargo.packageservice.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageRepository extends MongoRepository<Package,Long> {
}
