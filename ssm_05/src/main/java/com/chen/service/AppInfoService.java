package com.chen.service;

import com.chen.dto.AppInfoDTO;
import com.chen.pojo.AppInfo;
import com.chen.pojo.DataDictionary;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AppInfoService {
    PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo pageInfo);

    List<DataDictionary> queryAllAppstatus();

    List<DataDictionary> queryAllFlatforms();

    PageInfo<AppInfo> query(AppInfoDTO appInfoDTO);

    boolean add(AppInfo appInfo, long userId);

    boolean delete(Long id);

    AppInfo queryById(Long id);

    void update(AppInfo appInfo);

    AppInfo queryDetailById(Long id);
}
