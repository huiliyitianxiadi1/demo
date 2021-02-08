package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author DONG
 * @title: logout
 * @projectName demo
 * @description: TODO
 * @date 2021/1/27        17:35
 */
@Controller
public class logout {

    /***
     * 用户退出
     * @param request x
     * @return
     */

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        System.out.println("退出测试点,清除所有Session");


        Enumeration em = request.getSession().getAttributeNames();
        while (em.hasMoreElements()) {
            System.out.println("待清除Session:" + em.toString());
            request.getSession().removeAttribute(em.nextElement().toString());
        }
        return "redirect:/welcome.html";
    }

}
