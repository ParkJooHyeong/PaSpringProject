package com.platform_analysis.pa.repository;

import com.platform_analysis.pa.model.DTO.UserDTO;
import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserDTO> getAllUserData();

    UserDTO getUserDataById(@Param("id") Long id);

    int setUserData(HashMap<String, Object> hmUsersData);

    List<UserDTO> checkLoginInfo(@Param("username") String username, @Param("password") String password);
}
