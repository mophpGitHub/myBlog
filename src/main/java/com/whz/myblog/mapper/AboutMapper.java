package com.whz.myblog.mapper;

import com.whz.myblog.pojo.About;
import com.whz.myblog.utils.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/27 11:16
 * @Version 1.0
 */

@Component
public interface AboutMapper {

    /**
    *发布
    */
    void save(About about);

    /**
    *根据ID更新
    */
    void updateById(About about);

    /**
    *根据ID查询
    */
    About getById(Integer id);

    /**
    *查询关于
    */
    About getAbout();

    /**
    *根据ID删除
    */
    void deleteById(Integer id);

    /**
    *更新启用状态
    */
    void updateEnable(About about);

    /**
    *分页查询
    */
    List<About> getByPage(Page<About> page);

    /**
    *查询总数
    */
    int getCountByPage(Page<About> page);

}
