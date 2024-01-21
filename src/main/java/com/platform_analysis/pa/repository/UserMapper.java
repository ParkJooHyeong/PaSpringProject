package com.platform_analysis.pa.repository;

import com.platform_analysis.pa.model.UserDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDataEntity> getAllUserData();

    UserDataEntity getUserDataById(@Param("id") Long id);

    int setUserData(@Param("username") String username, @Param("email") String email);
}
