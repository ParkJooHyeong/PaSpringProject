package com.platform_analysis.pa.service.System;

import com.platform_analysis.pa.model.RequestDTO.System.UserDTO;
import com.platform_analysis.pa.repository.System.LogInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LogInService {

    @Autowired
    private LogInMapper logInMapper;

    public boolean checkUserInfo(UserDTO userDTO){
        try {
            HashMap<String, Object> mapPara = new HashMap<>();
            mapPara.put("EMAIL", userDTO.getEmail());
            mapPara.put("PASSWORD_HASH", userDTO.getPasswordHash());

            UserDTO result = logInMapper.checkLogIn(mapPara);

            return result != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
