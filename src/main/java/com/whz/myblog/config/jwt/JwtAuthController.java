package com.whz.myblog.config.jwt;

import com.whz.myblog.exception.CustomException;
import com.whz.myblog.utils.Md5Utils;
import com.whz.myblog.utils.Result;
import com.whz.myblog.utils.StringUtils;
import com.whz.myblog.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author 卫宏哲
 * @Date 2020/6/25 11:54
 * @Version 1.0
 */

@RestController
public class JwtAuthController {

    @Resource
    JwtAuthService jwtAuthService;


    @RequestMapping(value = "/authentication")
    public Result login(@RequestBody Map<String,String> map){
        String code = map.get("code");
        String verify_code = (String) WebUtils.getSession().getAttribute("verify_code");
        if(StringUtils.isBlank(code) || StringUtils.isBlank(verify_code) || !verify_code.toLowerCase().equals(code.toLowerCase())){
            return new Result(40000,"验证码错误！");
        }
        String username = map.get("username");
        String password = map.get("password");
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return new Result("用户名或密码不能为空！");
        }else {
            password = Md5Utils.toMD5(password);
        }
        try {
            return new Result("操作成功！",jwtAuthService.login(username,password));
        }catch (CustomException e){
            return new Result(e.getCode(),e.getMessage());
        }

    }

    @RequestMapping(value = "/refreshtoken")
    public Result refresh(@RequestHeader("${jwt.header}") String token){
           return new Result(jwtAuthService.refreshToken(token));
    }

}
