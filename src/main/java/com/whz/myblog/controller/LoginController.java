package com.whz.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.whz.myblog.utils.VerifyCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author 卫宏哲
 * @Date 2020/6/8 18:17
 * @Version 1.0
 */

@RestController
public class LoginController {
    /**
    *请求验证码
    */
    @RequestMapping (value = "/verifyCode",method = RequestMethod.GET)
    public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        String text = vc.getText();
        HttpSession session = req.getSession();
        session.setAttribute("verify_code", text);
        VerifyCode.output(image, resp.getOutputStream());
    }

}
