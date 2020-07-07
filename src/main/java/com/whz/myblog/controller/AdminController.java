package com.whz.myblog.controller;

import com.whz.myblog.pojo.Admin;
import com.whz.myblog.service.AdminService;
import com.whz.myblog.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:44
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 查询管理员
     */
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    public Result<Admin> getAdmin() {
        Admin admin = adminService.getAdmin();
        return new Result<>(admin);
    }

    /**
     * 更新个人信息
     * @param admin
     * @return
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
    public Result<Object> updateInfo(@RequestBody Admin admin) {
        adminService.updateInfo(admin);
        return new Result<>("更新成功！");
    }

    /**
     * 更新密码
     * @param admin
     * @return
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    public Result<Object> updatePassword(@RequestBody Admin admin) {
        adminService.updatePassword(admin);
        return new Result<>("更新成功！");
    }



}
