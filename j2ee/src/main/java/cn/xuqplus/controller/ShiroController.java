package cn.xuqplus.controller;

import cn.xuqplus.domain.Captcha;
import cn.xuqplus.domain.User;
import cn.xuqplus.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by qqx on 2017/7/12.
 */
@RestController
@RequestMapping("/api/public")
public class ShiroController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
            @ModelAttribute("user") User user,
            @ModelAttribute("captcha") Captcha captcha,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/public/html/dashboard.html");
        /**
         * 检查验证码
         */
        captcha.setCaptcha_time(new Date().getTime());
        Map map = Captcha.check(request, captcha);
        request.getSession().removeAttribute("captcha");
        if (!(boolean) map.get("success")) {
            return mav;
        }
        /**
         * shiro登录
         */
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(user.getUser_email(), user.getUser_password());
        try {
            subject.login(token);
        } catch (Exception e) {
        }
        return mav;
    }

    @RequestMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        mav.setViewName("redirect:/public/html/login.html");
        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @ModelAttribute("user") User user,
            @ModelAttribute("captcha") Captcha captcha,
            HttpServletRequest request
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/public/html/register.html");
        /**
              * 检查验证码
              */
        captcha.setCaptcha_time(new Date().getTime());
        Map map = Captcha.check(request, captcha);
        request.getSession().removeAttribute("captcha");
        if (!(boolean) map.get("success")) {
            return mav;
        }
        /**
         * 注册新用户
         */
        try {
            userMapper.insertUser(
                    user.getUser_id(),
                    user.getUser_name(),
                    user.getUser_email(),
                    user.getUser_password()
            );
            mav.setViewName("redirect:/public/html/login.html");
        } catch (Exception e) {
        }
        return mav;
    }
}
