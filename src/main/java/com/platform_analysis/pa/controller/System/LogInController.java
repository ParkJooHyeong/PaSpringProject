package com.platform_analysis.pa.controller.System;


import com.platform_analysis.pa.model.RequestDTO.System.UserDTO;
import com.platform_analysis.pa.service.System.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user/")
public class LogInController {
    @Autowired
    private LogInService logInService;

    @PostMapping("checkUserInfo")
    public boolean checkUserInfo(@RequestBody UserDTO userDTO) {
        return logInService.checkUserInfo(userDTO);
    }

}
