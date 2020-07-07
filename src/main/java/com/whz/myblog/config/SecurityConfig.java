package com.whz.myblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whz.myblog.config.jwt.JwtAuthenticationTokenFilter;
import com.whz.myblog.config.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.whz.myblog.utils.Result;
import javax.annotation.Resource;
import java.io.PrintWriter;


/**
 * @Author 卫宏哲
 * @Date 2020/6/8 16:51
 * @Version 1.0
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter {


    @Resource
    MyUserDetailsService myUserDetailsService;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    /*
     * 配置不需要拦截的接口
     *
     * */

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/verifyCode","/refreshtoken","/authentication","/admin/getAdmin"
                ,"/about/read","/type/getList","/blog/getByPage","/blog/getTimeLine","/blog/read/**"
        );
    }


    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req,resp, authentication) -> {
                    Result res = new Result<>(40003,"退出登录");
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(res));
                    out.flush();
                    out.close();

                })
                .permitAll()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .anyRequest().access("@rabcService.hasPermission(request,authentication)")
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }



    /**
     *
     * 配置账号密码
     */

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }



}
