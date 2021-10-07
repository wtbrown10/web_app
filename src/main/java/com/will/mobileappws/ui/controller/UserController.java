package com.will.mobileappws.ui.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.will.mobileappws.service.UserService;
import com.will.mobileappws.shared.dto.UserDto;
import com.will.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.will.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// controller will be responsible for all operations that have to do with "users"
@RestController
//requestmapping annotation is used to map web requests onto specific
// handler classes and/or handler methods.
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

     /* @Getmapping Annotation for mapping HTTP GET requests onto specific
        handler methods. Specifically, @GetMapping is a composed
        annotation that acts as a shortcut for
        @RequestMapping(method = RequestMethod. GET)*/
     @GetMapping
    public String getUser() {
        return "get user was called";
    }

    /*@PostMapping Annotation is post request*/
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {


        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

         return returnValue;
    }
    /*put request*/
    @PutMapping
    public String updateUser() {
        return "update user was called";
    }
    /*delete request*/
    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
