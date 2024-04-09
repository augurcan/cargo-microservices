package com.cargo.userservice.repository;

import com.cargo.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdentificationNumber(long identificationNumber);
}
