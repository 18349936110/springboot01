package com.fjj.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fjj.admin.bean.User;

public interface UserService extends IService<User> {
    /**
     * 数据库中是否存在用户名
     * @param username 用户名
     * @return boolean
     */
    boolean isExistUser(String username);

    /**
     * 通过用户名查找对应的邮箱号
     * @param username 用户名
     * @return email 邮箱号
     */
    String findEmailByUsername(String username);

    /**
     * 通过用户名查找对应的用户id
     * @param username 用户名
     * @return id
     */
    int findIdByUsername(String username);
}
