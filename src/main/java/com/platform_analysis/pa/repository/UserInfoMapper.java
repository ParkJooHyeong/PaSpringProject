package com.platform_analysis.pa.repository;

import com.platform_analysis.pa.model.DTO.UserDTO;
import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserInfoMapper {
    // 로그인 유저 정보
    List<UserDTO> getAllUserList();

    UserDTO getUserDataById(@Param("id") Long id);

    int setUserData(HashMap<String, Object> hmUsersData);
}
