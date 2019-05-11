package com.chen.service.impl;

import com.chen.mapper.AppCategoryMapper;
import com.chen.pojo.AppCategory;
import com.chen.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenyong uthor: chen
 * @date : 2019/4/27
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> queryAlllevelOne() {

        return appCategoryMapper.queryAlllevelOne();
    }

    @Override
    public List<AppCategory> queryLevelTwoByLevelOne(Long id) {

        return appCategoryMapper.queryLevelByParentId(id);
    }

}
