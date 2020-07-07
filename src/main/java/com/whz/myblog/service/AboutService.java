package com.whz.myblog.service;

import com.whz.myblog.pojo.About;
import com.whz.myblog.utils.Page;

import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/27 11:18
 * @Version 1.0
 */
public interface AboutService {
    /**
     *发布
     */
    void save(About about);

    /**
     *更新
     */
    void update(About about);

    /**
     *根据ID查询
     */
    About getById(Integer id);


    /**
     *根据ID删除
     */
    void deleteById(Integer id);

    /**
     *启用
     */
    void enableById(Integer id );

    /**
     *弃用
     */
    void disableById(Integer id );

    /**
     *分页查询
     */
    Page<About> getByPage(Page<About> page);

    /**
    *更新阅读数
    */
    About read();
}
