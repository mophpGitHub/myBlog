package com.whz.myblog.config.service;

import com.whz.myblog.config.entity.MyUserDetails;
import com.whz.myblog.pojo.Admin;
import com.whz.myblog.service.AdminService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 卫宏哲
 * @Date 2020/6/25 18:14
 * @Version 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private AdminService adminService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //加载基础用户信息
         Admin admin = adminService.getByUsername(username);
         MyUserDetails myUserDetails = new MyUserDetails();
         myUserDetails.setUsername(admin.getUsername());
         myUserDetails.setPassword(admin.getPassword());
         List<String>authorities = new ArrayList<>();
         authorities.add("ROLE_admin");
         authorities.add("/admin/getAdmin");

         myUserDetails.setAuthorities(
                 AuthorityUtils.commaSeparatedStringToAuthorityList(
                         String.join(",",authorities)
                 )
         );
        myUserDetails.setEnabled(true);
        myUserDetails.setAccountNonExpired(true);
        myUserDetails.setCredentialsNonExpired(true);
        myUserDetails.setAccountNonLocked(true);

        return myUserDetails;
    }
}
