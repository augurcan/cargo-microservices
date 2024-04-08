package com.cargo.userservice.dto.converter;

import com.cargo.userservice.dto.AddUserRequest;
import com.cargo.userservice.dto.UserResponse;
import com.cargo.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserResponse convertModeltoResponse(User user){
        return new UserResponse(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getIdentificationNumber());
    }
    public User convertRequestToModel(AddUserRequest addUserRequest){
        return new User(addUserRequest.getName(),
                addUserRequest.getSurname(),
                addUserRequest.getPhoneNumber(),
                addUserRequest.getEmail(),
                addUserRequest.getIdentificationNumber());
    }
}
