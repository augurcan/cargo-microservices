package com.cargo.locationservice.repository;

import com.cargo.locationservice.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location,String> {
}
