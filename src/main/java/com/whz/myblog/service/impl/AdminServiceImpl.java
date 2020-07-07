package com.whz.myblog.service.impl;

import com.whz.myblog.mapper.AdminMapper;
import com.whz.myblog.pojo.Admin;
import com.whz.myblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:45
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    @Override
    public Admin getByUsername(String username) {
        return adminMapper.getByUsername(username);
    }

    /**
     * 查询管理员
     *
     * @return
     */
    @Override
    public Admin getAdmin() {
        return adminMapper.getAdmin();
    }

    /**
     * 更新个人信息
     *
     * @param admin
     */
    @Override
    public void updateInfo(Admin admin) {
        adminMapper.update(admin);
    }

    /**
     * 更新密码
     *
     * @param admin
     */
    @Override
    public void updatePassword(Admin admin) {
        Admin oldAdmin = adminMapper.getAdmin();
        oldAdmin.setPassword(admin.getPassword());
        adminMapper.update(oldAdmin);
    }
}
