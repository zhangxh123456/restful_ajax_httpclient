package com.dj.ssm.web;

import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * controller 业务处理层
 * 跳转页面
 */
@Controller
public class UserPageController {

    /**
     * service 接口
     */
    @Autowired
    private UserService userService;

    /**
     * 跳转  注册页面
     * @return
     */
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "/register";
    }

    /**
     * 跳转  登陆页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }

    /**
     * 跳转  展示页面
     * @return
     */
    @RequestMapping("/toShow")
    public String toShow(){
        return "/show";
    }


    /**
     * 去跳转页面
     * @return
     */
    @RequestMapping("/toRestfulCrud")
    public String toRestfulCrud(){
        return "/restfulCrud";
    }



    @RequestMapping("/toRestfulCrudTwo")
    public String toRestfulCrudTwo(){
        return "/restfulCrudTwo";
    }



    @RequestMapping("/toFile")
    public String toFile(){
        return "/file";
    }
}
