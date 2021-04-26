package com.fjj.admin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author GoldenRetriever
 * @time 2020/10/12 19:53
 * @description 重置密码实体，对应resetPassword表
 */
@Data
@TableName(value = "resetPassword")
@Repository
public class ResetPassword {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 重置用户密码的用户id
     */
    @TableField(value = "user_id")
    private int userId;

    /**
     * 随机生成的16位验证码
     */
    @TableField(value = "code")
    private String code;

    /**
     * 开始时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 截至时间
     */
    @TableField(value = "deadline")
    private Date deadline;

    /**
     * 是否有效，若当前时间超出截至时间，则判定当前验证码无效，0代表无效，1代表有效
     */
    @TableField(value = "is_effective")
    private int isEffective;

    /**
     * 重置次数，记录当前重置次数
     */
    @TableField(value = "reset_num")
    private int resetNum;

    /**
     * 当日限定重置次数, 默认为3次
     */
    @TableField(value = "limit_num")
    private int limitNum;

}