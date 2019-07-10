package com.example.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by chenqi on 2017/7/7.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.example")
@MapperScan("com.example.dao.mapper")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置资源文件
     * @param registry
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }




}
