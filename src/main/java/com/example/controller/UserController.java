package com.example.controller;

import com.example.common.annotation.TimeAnn;
import com.example.model.SysUser;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: liuhuan
 * @Description: 登陆
 * @date: 2019/3/11
 */

@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    /**
     * @Author liuhuan
     * @Description  登录页面跳转
     * @Date  2019/03/12
     * @Param [request, modelAndView]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/login")
    @TimeAnn
    public ModelAndView toLogin(HttpServletRequest request, ModelAndView modelAndView) {

        modelAndView.setViewName("/user/login");
        return modelAndView;

    }

    /**
     * @Author liuhuan
     * @Description // 登录验证
     * @Date  2019/03/12
     * @Param [request, modelAndView, username 用户名, password 密码]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping("/userLogin")
    @TimeAnn
    public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView, String username, String password) {
        if(null ==username || null ==password){
            modelAndView.setViewName("redirect:/user/login");
            return modelAndView;
        }

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));

        } catch (AuthenticationException ex) {
            System.out.println("登陆失败: " + ex.getMessage());
            modelAndView.setViewName("redirect:/user/login");
            modelAndView.addObject("message", "用户不存在");
            modelAndView.addObject("failuser", username);
            return modelAndView;
        }
        // 登录成功后重定向
        // 如果是别个页面，登陆成功后跳转到开始那个页面，否则返回首页
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        String url = null;
        if (null != savedRequest) {
            url = savedRequest.getRequestUrl();
        }
        if (null != url) {
            modelAndView.setViewName("redirect:"+url);
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/index");
        return modelAndView;

    }
}
