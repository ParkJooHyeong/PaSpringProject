package com.platform_analysis.pa.controller;


import com.platform_analysis.pa.model.DTO.UserDTO;
import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import com.platform_analysis.pa.service.UserDataService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDataController {
    private static final Logger logger = LoggerFactory.getLogger(UserDataService.class);

    private final UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @PostMapping("/getUserData")
    public List<UserDTO> getAllUserData(){ return userDataService.getAllUserData(); }

    @PostMapping("/getUserDataId/{id}")
    public UserDTO getUserDataById(@PathVariable Long id){
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

    @PostMapping("/checkUserDuplicate")
    public boolean checkUserDuplicate(@RequestBody UserDTO userDTO) { return userDataService.checkUserDuplicate(userDTO); }
}