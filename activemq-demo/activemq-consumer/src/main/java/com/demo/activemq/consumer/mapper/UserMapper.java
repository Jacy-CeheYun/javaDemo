package com.demo.activemq.consumer.mapper;

import com.demo.activemq.consumer.pojo.Username;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    boolean insLogin(Username username);
}
