package com.example.controller;

import com.example.common.annotation.TimeAnn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: liuhuan
 * @Description: 页面跳转控制层
 * @date: 2019/3/12
 */
@Controller
public class IndexWebController {

    @RequestMapping(value = {"/","/index"})
    @TimeAnn
    public ModelAndView toIndex(HttpServletRequest request, ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;

    }
    @ResponseBody
    @RequestMapping(value = "/test",produces = {"application/json;charset=UTF-8"})
    @TimeAnn
    public String test(){
        return "ok";
    }
}
