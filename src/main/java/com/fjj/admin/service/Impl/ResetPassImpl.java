package com.fjj.admin.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fjj.admin.bean.ResetPassword;
import com.fjj.admin.mapper.ResetPasswordMapper;
import com.fjj.admin.service.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResetPassImpl extends ServiceImpl<ResetPasswordMapper, ResetPassword> implements ResetPasswordService {

        @Autowired
        private ResetPasswordService resetPasswordService;

        /**
         * 判断是否存在该用户修改的数据，
         * @param userId 用户id
         * @return boolean
         */
        @Override
        public boolean isExistUserId(int userId) {
            QueryWrapper<ResetPassword> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_Id", userId);
            return resetPasswordService.count(queryWrapper) > 0;
        }

        /**
         * 通过用户id获取这条数据
         * @param userId 用户id
         * @return ResetPassword实例
         */
        @Override
        public ResetPassword getOneByUserId(int userId) {
            QueryWrapper<ResetPassword> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_Id", userId);
            return resetPasswordService.getOne(queryWrapper);
        }
}
