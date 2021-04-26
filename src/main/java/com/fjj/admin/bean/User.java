package com.fjj.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("tbl_users")
public class User {

    private int userId;
    private String username;
    private String password;
    private String email;
    private String phone;

    @TableField(exist = false)
    private String code;
}
