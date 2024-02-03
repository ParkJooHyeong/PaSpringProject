package com.platform_analysis.pa.controller;


import com.platform_analysis.pa.model.DTO.UserDTO;
import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import com.platform_analysis.pa.service.UserDataService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDataController {
    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("/getUserData")
    public List<UserDataEntity> getAllUserData(){
        return userDataService.getAllUserData();
    }

    @PostMapping("/getUserData/{id}")
    public UserDataEntity getUserDataById(@PathVariable Long id){
        return userDataService.getUserDataById(id);
    }

    @PostMapping("/setUserData")
    public int setUserData(@RequestBody UserDTO userDTO){
        return userDataService.setUserData(userDTO);
    }

    @PostMapping("/login")
    public boolean checkLoginInfo(@RequestBody UserDTO userDTO){
        return userDataService.checkLoginInfo(userDTO);
    }
}