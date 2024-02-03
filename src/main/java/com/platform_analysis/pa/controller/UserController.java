package com.platform_analysis.pa.controller;

import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import com.platform_analysis.pa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUser")
    public List<UserDataEntity> getAllUserData(){
        return userService.getAllUserData();
    }

    @GetMapping("/User/{id}")
    public UserDataEntity getUserDataById(@PathVariable Long id){
        return userService.getUserMapper(id);
    }

    @PostMapping("/CreateUser/{username}/{email}")
    public int createUser(@PathVariable String username, @PathVariable String email){
        return userService.setUserData(username, email);
    }
}
