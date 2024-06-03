package com.platform_analysis.pa.service.System;

import com.platform_analysis.pa.Utils.Common.ResponseUtil;
import com.platform_analysis.pa.model.RequestDTO.System.UserDTO;
import com.platform_analysis.pa.model.ResponseDTO.Common.ResponseWrapper;
import com.platform_analysis.pa.repository.System.LogInMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
public class LogInService {

    @Autowired
    private LogInMapper logInMapper;

    public void checkUserInfo(UserDTO userDTO, HttpServletResponse response) throws IOException {
        HashMap<String, Object> mapPara = new HashMap<>();
        mapPara.put("EMAIL", userDTO.getEmail());
        mapPara.put("PASSWORD_HASH", userDTO.getPasswordHash());

        try {
            UserDTO result = logInMapper.checkLogIn(mapPara);
            if (result != null) {
                ResponseUtil.success(response, result);
            }
            else {
                ResponseUtil.error(response, "USER 정보를 찾을 수 없습니다.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            ResponseUtil.error(response, "USER 정보를 찾을 수 없습니다. " + e.getMessage());
        }
    }

    public boolean checkDuplicateUserInfo(UserDTO userDTO) {
        HashMap<String, Object> mapPara = new HashMap<>();
        mapPara.put("EMAIL", userDTO.getEmail());

        try {
            int  result = logInMapper.checkDuplicateUserInfo(mapPara);
            return result == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
