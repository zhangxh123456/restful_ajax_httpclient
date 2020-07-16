package com.dj.ssm.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.ssm.pojo.RestfulUser;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.User;
import com.dj.ssm.service.UserService;
import com.dj.ssm.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * controller 业务处理层
 */
@RestController
@RequestMapping("/users")
public class UserConteoller {

    /**
     * service  接口
     */
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user 用户实体类
     * @return
     */
    @PostMapping
    public ResultModel registerUser(@RequestBody User user){
        try {
            userService.save(user);
            return new ResultModel().success(user);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    @PostMapping("/list")
    public ResultModel loginUser(@RequestBody User user){
        try {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_name", user.getUserName());
            queryWrapper.eq("user_pwd", user.getUserPwd());

            User user1 = userService.getOne(queryWrapper);
            return new ResultModel().success(user1);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }


    /**
     * 展示
     * @param user
     * @return
     */
    @PostMapping("/list01")
    public ResultModel show(@RequestBody User user) {
        try {
            List<User> list = userService.list();
            return new ResultModel().success(list);
        } catch (Exception e) {
            return new ResultModel().error(e.getMessage());
        }
    }


    /**
     *
     * @param restfulUser  跳转页面的实体类
     * @return
     */
    @PostMapping("/list02")
    public ResultModel get(RestfulUser restfulUser) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("userName", restfulUser.getUserName());
            params.put("userPwd", restfulUser.getUserPwd());

            String restful =  HttpClientUtil.sendHttpRequest("http://localhost:8080/users/list03", HttpClientUtil.HttpRequestMethod.POST, params);
            System.out.println(restful);


            return new ResultModel().success(restful);
        } catch (Exception e) {
            return new ResultModel().error(e.getMessage());
        }
    }


    @RequestMapping("/file")
    public ResultModel file(MultipartFile file){
        try {
            System.out.println(file);
            String filename = file.getOriginalFilename();
            System.out.println(filename);
            if (!file.isEmpty()) {
                String dirPath = "F:/fileDown/";
                File f = new File(dirPath);
                if (!f.exists()) {
                    f.mkdirs();
                }
                file.transferTo(new File(dirPath + filename));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
       }

}
