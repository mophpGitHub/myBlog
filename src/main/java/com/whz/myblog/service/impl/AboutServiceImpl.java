package com.whz.myblog.service.impl;

import com.whz.myblog.enums.ResultEnum;
import com.whz.myblog.enums.StateEnums;
import com.whz.myblog.exception.CustomException;
import com.whz.myblog.mapper.AboutMapper;
import com.whz.myblog.pojo.About;
import com.whz.myblog.service.AboutService;
import com.whz.myblog.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/27 11:19
 * @Version 1.0
 */
@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;


    /**
     * 发布
     *
     * @param about
     */
    @Override
    public void save(About about) {
        aboutMapper.save(about);
    }

    /**
     * 更新
     *
     * @param about
     */
    @Override
    public void update(About about) {
        aboutMapper.updateById(about);

    }

    /**
     * 根据ID查询
     *
     * @param id
     */
    @Override
    public About getById(Integer id) {
        return aboutMapper.getById(id);
    }


    /**
     * 根据ID删除
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        aboutMapper.deleteById(id);
    }

    /**
     * 启用
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void enableById(Integer id) {
        // 查询是否已经存在启用的关于我的
        About about = aboutMapper.getAbout();
        if (about != null) {
            throw new CustomException(ResultEnum.ERROR.getCode(), "当前已存在启用中的关于我的");
        }
        about = aboutMapper.getById(id);
        about.setEnable(StateEnums.ENABLED.getCode());
        aboutMapper.updateEnable(about);
    }

    /**
     * 弃用
     *
     * @param id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void disableById(Integer id) {
        About about = aboutMapper.getById(id);
        about.setEnable(StateEnums.NOT_ENABLE.getCode());
        aboutMapper.updateEnable(about);
    }

    /**
     * 分页查询
     *
     * @param page
     */
    @Override
    public Page<About> getByPage(Page<About> page) {
        // 查询数据
        List<About> aboutList = aboutMapper.getByPage(page);
        page.setList(aboutList);
        // 查询总数
        int totalCount = aboutMapper.getCountByPage(page);
        page.setTotalCount(totalCount);
        return page;
    }

    /**
    *更新阅读数
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public About read() {
        About about = aboutMapper.getAbout();
        if (about == null) {
            return null;
        }
        about.setAboutRead(about.getAboutRead() + 1);
        aboutMapper.updateById(about);
        return about;
    }
}
