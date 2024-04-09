package com.cargo.userservice.service;

import com.cargo.userservice.dto.AddUserRequest;
import com.cargo.userservice.dto.UserResponse;
import com.cargo.userservice.dto.converter.UserDtoConverter;
import com.cargo.userservice.exception.ResourceNotFoundException;
import com.cargo.userservice.model.User;
import com.cargo.userservice.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }
    @RabbitListener(queues = "userQueue")
    public UserResponse addUser(AddUserRequest addUserRequest){
        User checkUser = userRepository.findByIdentificationNumber(addUserRequest.getIdentificationNumber());
        if(checkUser!= null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A user with this identification number already exists");

        User user = userDtoConverter.convertRequestToModel(addUserRequest);
        userRepository.save(user);
        return userDtoConverter.convertModeltoResponse(user);
    }
    public UserResponse getUserById(Long userId){
        return userDtoConverter.convertModeltoResponse(findByUserId(userId));
    }
    public List<UserResponse> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userDtoConverter::convertModeltoResponse).collect(Collectors.toList());
    }
    public UserResponse updateUser(Long userId, AddUserRequest addUserRequest){
        User user = findByUserId(userId);
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        user.setPhoneNumber(addUserRequest.getPhoneNumber());
        user.setEmail(addUserRequest.getEmail());
        user.setIdentificationNumber(addUserRequest.getIdentificationNumber());
        userRepository.save(user);
        return userDtoConverter.convertModeltoResponse(user);
    }
    public void deleteUser(Long userId){
        userRepository.delete(findByUserId(userId));
    }
    private User findByUserId(Long userId){
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
    }
}
