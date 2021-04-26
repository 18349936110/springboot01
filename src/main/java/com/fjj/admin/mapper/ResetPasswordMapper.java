package com.fjj.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fjj.admin.bean.ResetPassword;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author LKQ
 * @date 2021/3/29 9:11
 * @description
 */
@Mapper
public interface ResetPasswordMapper extends BaseMapper<ResetPassword> {
}
