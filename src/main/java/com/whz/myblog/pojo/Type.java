package com.whz.myblog.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:30
 * @Version 1.0
 */
@Data
public class Type implements Serializable {
    /**
     * 分类id
     */
    private Integer typeId;

    /**
     * 分类名称
     */
    private String typeName;

    /**
     * 帖子数
     */
    private Integer typeBlogCount;

    /**
     * 是否启用，0否1是
     */
    private Integer enable;

    /**
     * 是否删除，0否1是
     */
    private Integer deleted;
}
