package com.example.demo.config;

import com.example.demo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author DONG
 * @title: AdminWebConfig
 * @projectName demo
 * @description: TODO
 * @date 2021/1/23        16:21
 */

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
/*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        //add拦截
        //ex放行
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/Postlogin", "/login", "/login.html", "/welcome", "/welcome.html", "/register", "/register.html", "/assets/**");
    }*/


}
