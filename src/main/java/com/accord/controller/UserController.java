package com.accord.controller;


import com.accord.model.User;
import com.accord.service.ExternalApiService;
import com.accord.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User : Tanvir Ahmed
 * Date: 10/7/2024.
 */

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ExternalApiService externalApiService;


    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser=  userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }


    @GetMapping("/search")
    public ResponseEntity<Page<User>> getUsers(@RequestParam int page,
                                               @RequestParam int size,
                                               @RequestParam String query) {
        Page<User> users = userService.getUsers(page, size, query);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }


    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user= userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id,  @RequestBody User user) {
        User updateddUser=  userService.updateUser(id, user);
        return new ResponseEntity<>(updateddUser, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/call-google")
    public String callGoogle() {
        return externalApiService.callGoogleApi();
    }

}
