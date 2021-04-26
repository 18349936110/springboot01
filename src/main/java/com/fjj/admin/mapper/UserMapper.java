package com.fjj.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fjj.admin.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
