package com.chen.controller;

import com.chen.pojo.AppCategory;
import com.chen.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 根据分类一查询分类二，
 * @author chenyong uthor: chen
 * @date : 2019/4/27
 */
@Controller
@RequestMapping("/category")
public class AppCategoryController {
   @Autowired
  private AppCategoryService appCategoryService;

    @ResponseBody
    @RequestMapping(value = "/queryLevelTwoByLevelOne/{levelOneId}")
    public List<AppCategory> queryLevelTwoByLevelOne(@PathVariable("levelOneId") Long id,Model model){
        List<AppCategory> levelTwo=appCategoryService.queryLevelTwoByLevelOne(id);
        //model.addAttribute("levelTwo",levelTwo);
        //return "app/index";
        return levelTwo;
    }

    @ResponseBody
    @RequestMapping(value = "/queryLevelThreeByLevelTwo/{levelTwoId}")
    public List<AppCategory> queryLevelThreeByLevelTwo(@PathVariable("levelTwoId") Long id){
        List<AppCategory> levelThree=appCategoryService.queryLevelTwoByLevelOne(id);
        return levelThree;
    }
}
