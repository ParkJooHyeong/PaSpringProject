package com.platform_analysis.pa.service;

import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.platform_analysis.pa.model.DTO.UserDTO;
import com.platform_analysis.pa.repository.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

@Service
public class UserDataService {
    private static final Logger logger = LoggerFactory.getLogger(UserDataService.class);
    private final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserDataService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public List<UserDTO> getAllUserData(){
        logger.info("ALL USER를 조회합니다.");
        return userInfoMapper.getAllUserData();
    }

    public UserDTO getUserDataById(Long id) { return userInfoMapper.getUserDataById(id); }

    public int setUserData(UserDTO userDTO){
        return userInfoMapper.setUserData(setParameter(userDTO));
    }

    public boolean checkLoginInfo(UserDTO userDTO){
        List<UserDTO> liUserDTO = userInfoMapper.checkLoginInfo(userDTO.getUserEmail(), userDTO.getUserPW());
        if (liUserDTO.size() == 0){
            logger.info(">>>>> 로그인 실패 : User 정보를 확인할 수 없음.");
            return false;
        }
        else if(liUserDTO.size() == 1){
            logger.info(">>>>> 로그인 성공");
            return true;
        }
        else{
            logger.info(String.format(">>>>> 로그인 정보가 이상합니다. 데이터를 확인하세요. NAME: %s, EMAIL: %s"
                    ,liUserDTO.get(0).getUserName(), liUserDTO.get(0).getUserEmail()));
            return false;
        }
    }

    public boolean checkUserDuplicate(UserDTO userDTO){
        List<UserDTO> liUserDTO = userInfoMapper.checkUserDuplicate(userDTO.getUserEmail());
        return liUserDTO.size() != 0;
    }


    private HashMap<String, Object> setParameter(UserDTO userDTO){
        HashMap<String, Object> hmUserData = new HashMap<>();

        hmUserData.put("username", userDTO.getUserName());
        hmUserData.put("email", userDTO.getUserEmail());
        hmUserData.put("password", pwEncoder.encode(userDTO.getUserPW()));
        hmUserData.put("birthday", userDTO.getUserBirthday());
        hmUserData.put("address", userDTO.getUserAddress());

        return hmUserData;
    }



}
