package com.cargo.userservice.controller;

import com.cargo.userservice.dto.AddUserRequest;
import com.cargo.userservice.dto.UserResponse;
import com.cargo.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody AddUserRequest addUserRequest){
        return ResponseEntity.ok(userService.addUser(addUserRequest));
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId,
                                                   @RequestBody AddUserRequest addUserRequest){
        return ResponseEntity.ok(userService.updateUser(userId, addUserRequest));
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok("User Deleted");
    }
}
