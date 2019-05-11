package com.chen.service.impl;

import com.chen.constant.CommonCodeConstant;
import com.chen.dto.AppInfoDTO;
import com.chen.mapper.AppInfoMapper;
import com.chen.mapper.DataDictionaryMapper;
import com.chen.pojo.AppInfo;
import com.chen.pojo.DataDictionary;
import com.chen.pojo.DevUser;
import com.chen.service.AppInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @author chenyong uthor: chen
 * @date : 2019/4/24
 */
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    /**
     * 显示主体内容
     * @param id
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo pageInfo) {
        //去第几页，页码的大小
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        AppInfoDTO a=new AppInfoDTO();
        a.setDevUserId(id);
        List<AppInfo> l=appInfoMapper.query(a);
        PageInfo<AppInfo> page=new PageInfo<AppInfo>(l);
        return page;
    }

    @Override
    public List<DataDictionary> queryAllAppstatus() {
        return dataDictionaryMapper.queryAllAppstatus();
    }

    @Override
    public List<DataDictionary> queryAllFlatforms() {
        return dataDictionaryMapper.queryAllFlatforms();
    }


    /**
     * 查询按钮
     * @param appInfoDTO
     * @return
     */
    @Override
    public PageInfo<AppInfo> query(AppInfoDTO appInfoDTO) {
        if (appInfoDTO.getPageNum()==null){
            appInfoDTO.setPageNum(1);
        }
        PageHelper.startPage(appInfoDTO.getPageNum(),CommonCodeConstant.PAGE_SIZE);
        List<AppInfo> list =appInfoMapper.query(appInfoDTO);
        PageInfo<AppInfo> page=new PageInfo<AppInfo>(list);
        return page;

    }

    @Override
    public boolean add(AppInfo appInfo, long userId) {
        //先处理这些信息
        appInfo.setCreationDate(new Date());
        DevUser devUser=new DevUser();
        devUser.setId(userId);
        appInfo.setDevUser(devUser);
        appInfo.setCreatedBy(userId);
        DataDictionary dataDictionary=new DataDictionary();
        dataDictionary.setValueId(CommonCodeConstant.APP_STATUS_AUDITED);
        appInfo.setAppStatus(dataDictionary);
       int row= appInfoMapper.add(appInfo);
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (id !=null){
            int row=  appInfoMapper.deleteById(id);
            return row == 1;
        }
        return false;
    }

    @Override
    public AppInfo queryById(Long id) {
        return appInfoMapper.queryById(id);
    }

    @Override
    public void update(AppInfo appInfo) {
        appInfo.setUpdateDate(new Date());
        appInfo.setModifyByDate(new Date());
        appInfoMapper.updateById(appInfo);
    }

    @Override
    public AppInfo queryDetailById(Long id) {

        return appInfoMapper.queryDetailById(id);
    }
}
