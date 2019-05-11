package com.chen.controller;
import com.chen.pojo.DevUser;
import com.chen.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 主要用于登录退出
 * @author chenyong uthor: chen
 * @date : 2019/4/21
 */
@Controller
@RequestMapping("/dev")
public class DevUserController {

        @Autowired
       private DevUserService devUserServices;

    @RequestMapping("/toLogin")
    public String index(DevUser devUser){
        return "dev/login";
    }
//    @Autowired
//       private AppInfoService appInfoService;
//
//    @RequestMapping("/toLogin")
//    public String index(DevUser devUser){
//        return "dev/login";
//    }

    /**
     * 登录
     * @param devUser
     * @param model
     * @return
     */
    @RequestMapping("Login")
    public String login(DevUser devUser, Model model, HttpSession session){
        devUser= devUserServices.login(devUser);
        if (devUser !=null){
            session.setAttribute("devUser",devUser);
             return "/dev/index";
        }else {
            model.addAttribute("errMsg","登录失败");
            return "dev/login";
        }
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //重定向
        session.removeAttribute("devUser");
        session.invalidate();
        return "redirect:/";
       //return "/dev/login";
    }
}
