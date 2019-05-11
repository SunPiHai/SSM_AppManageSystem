package com.chen.mapper;

import com.chen.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DevUserMapper {

    List<DevUser> queryByNamePsd( DevUser devUser);
}