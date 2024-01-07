package com.platform_analysis.pa.controller;

import com.platform_analysis.pa.model.UserDataEntity;
import com.platform_analysis.pa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUser")
    public String getAllUserData(Model model){
        List<UserDataEntity> allUserData = userService.getAllUserData();
        model.addAttribute("allUserData", allUserData);
        return "allUser/list";
    }

    @GetMapping("/User/{id}")
    public String getUserDataById(@PathVariable Long id, Model model){
        UserDataEntity userData = userService.getUserMapper(id);
        model.addAttribute("userData", userData);
        return "User/detail";
    }
}
