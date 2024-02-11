package com.platform_analysis.pa.repository;

import com.platform_analysis.pa.model.Entitiy.UserDataEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Mapper
public interface UserMapper extends JpaRepository<UserDataEntity, Long> {
    List<UserDataEntity> getAllUserData();

    UserDataEntity getUserDataById(@Param("id") Long id);

    int setUserData(@Param("username") String username, @Param("email") String email);
}
