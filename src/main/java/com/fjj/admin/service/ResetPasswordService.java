package com.fjj.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fjj.admin.bean.ResetPassword;

/**
 * @author GoldenRetriever
 * @time 2020/10/12 22:18
 * @description 定义重置密码的接口类，
 */
public interface ResetPasswordService extends IService<ResetPassword> {
    /**
     * 通过userId判断resetPassword表中该用户是否修改过密码，有没有数据
     * @param userId 用户id
     * @return boolean
     */
    boolean isExistUserId(int userId);

    /**
     * 通过userId取出这一条数据
     * @param userId 用户id
     * @return resetPassword对象
     */
    ResetPassword getOneByUserId(int userId);
}
