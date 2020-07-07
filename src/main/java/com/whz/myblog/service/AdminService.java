package com.whz.myblog.service;

import com.whz.myblog.pojo.Admin;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:44
 * @Version 1.0
 */
public interface AdminService {
    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    Admin getByUsername(String username);

    /**
     * 查询管理员
     *
     * @return
     */
    Admin getAdmin();
    /**
     * 更新个人信息
     * @param admin
     */
    void updateInfo(Admin admin);

    /**
     * 更新密码
     * @param admin
     */
    void updatePassword(Admin admin);
}
