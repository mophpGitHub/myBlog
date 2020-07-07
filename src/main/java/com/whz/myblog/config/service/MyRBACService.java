package com.whz.myblog.config.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 86188
 */
@Component("rabcService")
public class MyRBACService {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();



    /**
     * 判断某用户是否具有该request资源的访问权限
     */
    public boolean hasPermission(HttpServletRequest request,
                                 Authentication authentication){

        Object principal = authentication.getPrincipal();

        if(principal instanceof UserDetails){
            String username = ((UserDetails)principal).getUsername();

            List<String> urls = new ArrayList<>();
            urls.add("ROLE_admin");
            urls.add("/admin/**");
            urls.add("/type/**");
            urls.add("/about/**");
            urls.add("/blog/**");
            urls.add("/upload/uploadImage");

            return urls.stream().anyMatch(
                    url -> antPathMatcher.match(url,request.getRequestURI())
            );

        }
        return false;
    }


}
