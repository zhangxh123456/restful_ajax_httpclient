package com.dj.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * user_message   用户信息表实体类       dev
 */
@Data
@TableName("user_message")
public class User {

    /**  id */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 用户身份证号 */
    private String userNumber;

    /**  用户姓名  */
    private String userName;

    /**  用户密码 */
    private String userPwd;

    /**  用户学科 */
    private Integer userSubject;

    /**  用户头像  */
    private String userPicture;




}
