package com.platform_analysis.pa.controller.System;


import com.platform_analysis.pa.model.RequestDTO.System.UserDTO;
import com.platform_analysis.pa.model.ResponseDTO.Common.ResponseWrapper;
import com.platform_analysis.pa.service.System.LogInService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/system/user/")
public class LogInController {
    @Autowired
    private LogInService logInService;

    @PostMapping("checkUserInfo")
    public void checkUserInfo(@RequestBody UserDTO userDTO, HttpServletResponse response) throws IOException {
        logInService.checkUserInfo(userDTO, response);
    }

    @PostMapping("checkDuplicateUserInfo")
    public boolean checkDuplicateUserInfo(@RequestBody UserDTO userDTO) {
        return logInService.checkDuplicateUserInfo(userDTO);
    }

}
