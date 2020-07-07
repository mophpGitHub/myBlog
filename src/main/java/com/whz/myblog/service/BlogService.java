package com.whz.myblog.service;

import com.whz.myblog.pojo.Blog;
import com.whz.myblog.pojo.BlogVo;
import com.whz.myblog.utils.Page;

import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/27 11:18
 * @Version 1.0
 */
public interface BlogService {
    /**
     * 保存
     * @param blog
     */
    void save(Blog blog);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Blog getById(String id);

    /**
     * 更新
     * @param blog
     */
    void update(Blog blog);

    /**
     * 阅读
     * @param id
     * @return
     */
    BlogVo readById(String id);

    /**
     * 根据id删除
     * @param id
     */
    void deleteById(String id);

    /**
     * 分页查询
     * @param page
     * @return
     */
    Page<BlogVo> getByPage(Page<BlogVo> page);

    /**
     * 查询时间轴
     * @return
     */
    List<BlogVo> getTimeLine();

}
