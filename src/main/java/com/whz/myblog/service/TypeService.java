package com.whz.myblog.service;

import com.whz.myblog.pojo.Type;

import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/27 11:19
 * @Version 1.0
 */
public interface TypeService {
    /**
     * 添加
     * @param type
     */
    void save(Type type);

    /**
     * 查询所有
     * @return
     */
    List<Type> getAll();

    /**
     * 前台查询所有
     * @return
     */
    List<Type> getTypeList();

    /**
     * 更新
     * @param type
     */
    void update(Type type);

    /**
     * 根据id启用
     * @param id
     */
    void enableById(Integer id);

    /**
     * 根据id弃用
     * @param id
     */
    void disableById(Integer id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Type getById(Integer id);
}
