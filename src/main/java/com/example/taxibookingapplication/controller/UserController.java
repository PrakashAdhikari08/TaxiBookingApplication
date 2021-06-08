package com.example.taxibookingapplication.controller;

import com.example.taxibookingapplication.config.userconfig.LoadAdminFromFile;
import com.example.taxibookingapplication.domain.User;
import com.example.taxibookingapplication.dto.UserDto;
import com.example.taxibookingapplication.exception.UserNameAlreadyPresentException;
import com.example.taxibookingapplication.mapper.UserMapper;
import com.example.taxibookingapplication.service.UserService;
import com.example.taxibookingapplication.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/taxi/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoadAdminFromFile loadAdminFromFile;

    @ApiOperation("User registration")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> customerRegister(@RequestBody User user) throws UserNameAlreadyPresentException {
        userService.registerCustomer(user);
        return new ResponseEntity("Customer registered", HttpStatus.CREATED);
    }

    @ApiOperation("Driver registration")
    @RequestMapping(value = "/register/driver", method = RequestMethod.POST)
    public ResponseEntity<String> driverRegister(@RequestBody User user){
        userService.registerDriver(user);
        return new ResponseEntity("Driver registered", HttpStatus.CREATED);
    }

    @GetMapping(value = "/load")
    public void loadAdmin() throws IOException {
        loadAdminFromFile.loadAdmin();
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> showAll(){
        List<User> users = userService.findAll();
        List<UserDto> userDtos = UserMapper.toDtoList(users);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted",HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateAddress(final User user, String address){
        userService.updateAddress(user,address);
        return new ResponseEntity<>("User Details Updated", HttpStatus.CONTINUE);
    }

    @ExceptionHandler(UserNameAlreadyPresentException.class)
    public ResponseEntity<String> userNameInuseException(){
        return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);
    }
}
