package com.chen.service;

import com.chen.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {

    List<AppCategory> queryAlllevelOne();

    List<AppCategory> queryLevelTwoByLevelOne( Long id);

}
