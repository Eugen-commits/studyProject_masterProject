package com.example.master_study.controller;

import com.example.master_study.persistance.entity.User;
import com.example.master_study.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping ("/user")
@Api("User controller")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping ("/create")
    public ResponseEntity <HttpStatus> create (@RequestBody User user){
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    public ResponseEntity <User> getById (@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @GetMapping ("/phone/{phoneNumber}")
    public ResponseEntity <User> getByPhoneNumber (@PathVariable (value = "phoneNumber") String phoneNumber){
        return new ResponseEntity<>(userService.get(phoneNumber),HttpStatus.OK);
    }

    @GetMapping ("/getUsers")
    public ResponseEntity <Set<User>> getAllUser (){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping ("/delete/{phone}")
    public ResponseEntity <HttpStatus> deleteUser (@PathVariable (value = "phone") String phoneNumber){
        userService.deleteByPhoneNumb(phoneNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
