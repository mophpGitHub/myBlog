package com.whz.myblog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:30
 * @Version 1.0
 */
@Data
public class Admin implements Serializable {

    /**
     * 管理员id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String header;

    /**
     * 签名
     */
    private String signature;

    /**
     * 介绍
     */
    private String comment;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;


}
