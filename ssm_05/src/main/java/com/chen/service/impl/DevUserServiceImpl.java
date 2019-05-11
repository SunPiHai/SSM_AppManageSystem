package com.chen.service.impl;

import com.chen.mapper.DevUserMapper;
import com.chen.pojo.DevUser;
import com.chen.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyong uthor: chen
 * @date : 2019/4/22
 */
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService{
    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public DevUser login(DevUser devUser) {
        List<DevUser> users=devUserMapper.queryByNamePsd(devUser);
        if (users!=null && users.size()==1){
            return users.get(0);
        }
        return  null;
    }
}
