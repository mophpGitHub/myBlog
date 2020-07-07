package com.whz.myblog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:30
 * @Version 1.0
 */
@Data
public class Blog implements Serializable {

    /**
     * 帖子id
     */
    private String blogId;

    /**
     * 标题
     */
    private String blogTitle;

    /**
     * 封面
     */
    private String blogImage;

    /**
     * 帖子内容
     */
    private String blogContent;

    /**
     * 阅读数
     */
    private Integer blogRead;

    /**
     * 博客分类
     */
    private Integer blogType;

    /**
     * 简介
     */
    private String blogRemark;

    /**
     * 文章来源（爬虫时使用）
     */
    private String blogSource;

    /**
     * 创建时间
     */
    private String createdTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;
}
