package com.platform_analysis.pa.repository.System;


import com.platform_analysis.pa.model.RequestDTO.System.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface LogInMapper {
    UserDTO checkLogIn(HashMap<String, Object> params);
}
