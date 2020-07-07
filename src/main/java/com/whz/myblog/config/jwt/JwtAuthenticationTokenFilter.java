package com.whz.myblog.config.jwt;

import com.whz.myblog.config.service.MyUserDetailsService;
import com.whz.myblog.utils.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 卫宏哲
 * @Date 2020/6/25 22:04
 * @Version 1.0
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    JwtTokenUtil jwtTokenUtil;

    @Resource
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String jwtToken = request.getHeader(jwtTokenUtil.getHeader());
        if (!StringUtils.isBlank(jwtToken)){
            String username = jwtTokenUtil.getUsernameFromToken(jwtToken);

            if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                if (jwtTokenUtil.validateToken(jwtToken,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
