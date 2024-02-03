package com.platform_analysis.pa.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.platform_analysis.pa.model.DTO.UserDTO;
import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import com.platform_analysis.pa.repository.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserDataService {
    private final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
    private final UserInfoMapper userInfoMapper;

    @Autowired
    public UserDataService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public List<UserDataEntity> getAllUserData(){
        return userInfoMapper.getAllUserList();
    }

    public UserDataEntity getUserDataById(Long id){
        return userInfoMapper.getUserDataById(id);
    }

    public int setUserData(UserDTO userDTO){
        return userInfoMapper.setUserData(setParameter(userDTO));
    }

    public boolean checkLoginInfo(UserDTO userDTO){
//        UserInfoMapper userinfo = userInfoMapper.getUserDataById();
        return true;
    }


    private HashMap<String, Object> setParameter(UserDTO userDTO){
        HashMap<String, Object> hmUserData = new HashMap<>();

        hmUserData.put("username", userDTO.getName());
        hmUserData.put("email", userDTO.getEmail());
        hmUserData.put("password", pwEncoder.encode(userDTO.getPassword()));
        hmUserData.put("birthday", userDTO.getBirthday());
        hmUserData.put("address", userDTO.getAddress());

        return hmUserData;
    }



}
