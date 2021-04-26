package com.fjj.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fjj.admin.bean.Msg;
import com.fjj.admin.bean.User;
import com.fjj.admin.mapper.UserMapper;
import com.fjj.admin.service.Impl.UserServiceImpl;
import com.fjj.admin.service.ResetPasswordService;
import com.fjj.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
   /* @Autowired
    UserServiceImpl userServiceImpl;*/


    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @PostMapping("/user/register")
    public Msg userRegister(@RequestBody User user){
        System.out.println(user);
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        System.out.println("加密后的密码是："+md5Password);
        user.setPassword(md5Password);
        boolean b = userService.save(user);
        if(b){
            System.out.println("用户注册成功");
            return Msg.success();
        }else {
            return Msg.fail();
        }

    }

    @ResponseBody
    @PostMapping("/user/login")
    public Msg userLogin(@RequestBody User user){

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("username",user.getUsername());
        columnMap.put("password",user.getPassword());
        List<User> users = userMapper.selectByMap(columnMap);
        if(users.size() == 1){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }

    @ResponseBody
    @PostMapping("/user/resetPassword")
    public Msg resetPassword(@RequestBody User user) {
        /*if (user.getUsername()!=null&& user.getEmail()!=null){
            //第一步，传来的是用户名和邮件，其他为空，则生成验证码并发送邮件
            return userServiceImpl.checkUserAndEmail(user);
        }
        if (user.getCode()!=null && user.getUsername()!=null) {
            //第二步，传来code和username，需要验证数据库中的code是否正确
            return userServiceImpl.checkCode(user.getCode(), user.getUsername());
        }
        if (user.getUsername()!=null && user.getPassword()!=null) {
            //最后，用户名和密码同时传过来，开始重置密码。
            return userServiceImpl.resetPassword(user.getUsername(), user.getPassword());
        }*/
        return Msg.fail().add("msg","未知错误");
    }


}
