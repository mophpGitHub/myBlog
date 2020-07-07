package com.whz.myblog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:30
 * @Version 1.0
 */
@Data
public class About implements Serializable {

    /**
    *关于我的文章Id
    */
    private Integer aboutId;
    /**
    *标题
    */
    private String aboutTitle;
    /**
    *内容
    */
    private String aboutContent;
    /**
    *阅读次数
    */
    private Integer aboutRead;
    /**
    *创建时间
    */
    private String createdTime;
    /**
    *更新时间
    */
    private String updateTime;
    /**
    *乐观锁
    */
    private Integer version;
    /**
    *是否启用
    */
    private Integer enable;
    /**
    *逻辑删除
    */
    private Integer deleted;
}
