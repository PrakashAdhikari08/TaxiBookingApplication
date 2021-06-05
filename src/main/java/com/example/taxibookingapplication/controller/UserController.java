package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taxi/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("User registration")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String UserRegister(@RequestBody User user){
        userService.registerUser(user);
        return "User registered";
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<User> showAll(){
        List<User> users = userService.findAll();
        return users;
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return "User Deleted";
    }

    @PutMapping(value = "/update")
    public String updateAddress(final User user, String address){
        userService.updateAddress(user,address);
        return "User Details Updated";
    }


    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> noUserFound(){
        return new ResponseEntity<>("NO user found" , HttpStatus.BAD_REQUEST);
    }
}
