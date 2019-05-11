package com.chen.controller;

import com.chen.constant.CommonCodeConstant;
import com.chen.dto.AppInfoDTO;
import com.chen.pojo.AppCategory;
import com.chen.pojo.AppInfo;
import com.chen.pojo.DataDictionary;
import com.chen.pojo.DevUser;
import com.chen.service.AppCategoryService;
import com.chen.service.AppInfoService;
import com.chen.service.DataDictionaryService;
import com.chen.service.DevUserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用于app开发者业务处理
 * @author chenyong uthor: chen
 * @date : 2019/4/23
 */
@Controller
@RequestMapping("/app")
public class DevAppController {

      @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private AppCategoryService appCategoryService;

    /**
     * 根据id来查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/index/devId/{id}")
    public String index(@PathVariable("id") Long id, Model model, HttpSession session){
        session.setAttribute("USER_ID",id);
        PageInfo<AppInfo> pageInfo=new PageInfo<>();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(1);
        pageInfo=appInfoService.queryByDevUserId(id,pageInfo);
        //查询所有的平台
        List<DataDictionary> appFlatforms=appInfoService.queryAllFlatforms();
        //查询所有的APP的状态
        List<DataDictionary> appStatuses=appInfoService.queryAllAppstatus();
        //查询所有一级分类
        List<AppCategory> levelOne=appCategoryService.queryAlllevelOne();
        model.addAttribute("page",pageInfo);
        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);

        return "app/index";
   }

   //查询按钮
    @RequestMapping("/query")
    public String query(AppInfoDTO appInfoDTO,Model model,HttpSession session){
        Object obj=session.getAttribute("USER_ID");
        if(obj!=null){
            long userId=(long)obj;
            appInfoDTO.setDevUserId(userId);
            PageInfo<AppInfo> pageInfo= appInfoService.query(appInfoDTO);
            //查询所有的平台
            List<DataDictionary> appFlatforms=appInfoService.queryAllFlatforms();
            //查询所有的APP的状态
            List<DataDictionary> appStatuses=appInfoService.queryAllAppstatus();
            //查询所有一级分类
            List<AppCategory> levelOne=appCategoryService.queryAlllevelOne();
            model.addAttribute("appFlatforms",appFlatforms);
            model.addAttribute("appStatuses",appStatuses);
            model.addAttribute("levelOne",levelOne);
            model.addAttribute("page",pageInfo);
            model.addAttribute("appInfoDTO",appInfoDTO);
            return "app/index";
        }else {
            return "redirect:/";
        }
    }

    public DataDictionaryService getDataDictionaryService() {
        return dataDictionaryService;
    }

    public void setDataDictionaryService(DataDictionaryService dataDictionaryService) {
        this.dataDictionaryService = dataDictionaryService;
    }

    @RequestMapping("/toadd")
    public String toadd(Model model){
        //查询所有的APP的状态
        List<DataDictionary> appStatuses=appInfoService.queryAllAppstatus();
        //查询所有一级分类
        List<AppCategory> levelOne=appCategoryService.queryAlllevelOne();
        //查询所有的平台
        List<DataDictionary> appFlatforms=appInfoService.queryAllFlatforms();
        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);
        model.addAttribute("appFlatforms",appFlatforms);
        return "app/add";
    }
    @RequestMapping("/add")
    public String add(AppInfo appInfo,HttpSession session){
        //开发者
        Object id = session.getAttribute("USER_ID");
        long userId=Long.parseLong(id.toString());
        boolean flag=appInfoService.add(appInfo,userId);
        //转发到action
        return "redirect:/app/index/devId/"+userId+".do";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")Long id, HttpSession session){
        Object uid = session.getAttribute("USER_ID");
        long userId=Long.parseLong(uid.toString());
        boolean flag=appInfoService.delete(id);
        return "redirect:/app/index/devId/"+userId+".do";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id")Long id, HttpSession session,Model model){
      AppInfo appInfo=appInfoService.queryById(id);
        //查询所有的APP的状态
        List<DataDictionary> appStatuses=appInfoService.queryAllAppstatus();
        //查询所有一级分类
        List<AppCategory> levelOne=appCategoryService.queryAlllevelOne();
        //查询所有的平台
        List<DataDictionary> appFlatforms=appInfoService.queryAllFlatforms();
        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);
        model.addAttribute("appFlatforms",appFlatforms);
        model.addAttribute("app",appInfo);
      return "app/edit";
    }
    @RequestMapping("/edit")
    public String edit(AppInfo appInfo,Model model,HttpSession session){
        Object uid = session.getAttribute("USER_ID");
        long userId=Long.parseLong(uid.toString());
        DevUser devUser=new DevUser();
        devUser.setId(userId);
        appInfo.setModifyBy(userId);
        appInfo.setCreatedBy(userId);
        appInfo.setDevUser(devUser);
        appInfoService.update(appInfo);
        return "redirect:/app/query.do";
    }

    @RequestMapping("/queryById/{id}")
    public String queryById(@PathVariable("id") Long id,Model model){
        AppInfo app=appInfoService.queryDetailById(id);
        //查询所有的APP的状态
        List<DataDictionary> appStatuses=appInfoService.queryAllAppstatus();
        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("app",app);
        return "app/appDetail";
    }
}
