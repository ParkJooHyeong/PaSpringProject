package com.platform_analysis.pa.service;
import com.platform_analysis.pa.model.UserDataEntity;
import com.platform_analysis.pa.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDataEntity> getAllUserData(){
        return userMapper.getAllUserData();
    }

    public UserDataEntity getUserMapper(Long id){
        return userMapper.getUserDataById(id);
    }
}
