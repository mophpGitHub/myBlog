package com.whz.myblog.mapper;

import com.whz.myblog.pojo.Admin;
import org.springframework.stereotype.Component;

/**
 * @Author 卫宏哲
 * @Date 2020/6/19 16:43
 * @Version 1.0
 */
@Component
public interface AdminMapper {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    Admin getByUsername(String username);

    /**
     * 查询管理员
     * @return
     */
    Admin getAdmin();

    /**
     * 更新
     * @param admin
     */
    void update(Admin admin);

}
