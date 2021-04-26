package com.fjj.admin.controller;

import com.fjj.admin.bean.Msg;
import com.fjj.admin.bean.User;
import com.fjj.admin.mapper.UserMapper;
import com.fjj.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

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

}
