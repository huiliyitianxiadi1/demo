package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DONG
 * @title: welcome
 * @projectName demo
 * @description: TODO
 * @date 2021/1/22        1:45
 */

@Controller
public class welcome {

    /**
     * 首先可以通过注解的方式  获取一个 request
     */
    @Autowired
    private HttpServletRequest request;

    @RequestMapping({"/welcome.html", "/", "/welcome"})
    public String welcome(Model model) {

        //获得Session 中存储的shenfen存储的user对象
        User SHENFEN = (User) request.getSession().getAttribute("shenfen");


        //SHENFEN不为空则根据身份创建相应的学生，教师，管理员对象
        if (SHENFEN != null) {
            System.out.println("welcome页面Object SHENFEN：" + SHENFEN.getShenfen());

            model.addAttribute("SHENFEN", SHENFEN.getShenfen());

            if (SHENFEN.getShenfen().equals("student")) {
                //学生身份
                //获取Session内存储的用户
                Student user = (Student) request.getSession().getAttribute("loginUser");
                if (user != null) {
                    System.out.println("welcome页面对登录后用户测试点:" + user.getStudentName() + "===" + user.getStudentEmail());

                    //将获取Session内存储用户后将user的name放入model发送到页面
                    model.addAttribute("username_ok", user.getStudentName());
                }
            } else if (SHENFEN.getShenfen().equals("teacher")) {
                //教师身份
                //获取Session内存储的用户
                Teacher user = (Teacher) request.getSession().getAttribute("loginUser");
                if (user != null) {
                    System.out.println("welcome页面对登录后用户测试点:" + user.getTeacherName() + "===" + user.getTeacherEmail());

                    //将获取Session内存储用户后将user的name放入model发送到页面
                    model.addAttribute("username_ok", user.getTeacherName());
                }

            } else if (SHENFEN.getShenfen().equals("admin")) {
                //管理员身份
                //获取Session内存储的用户
                Admin user = (Admin) request.getSession().getAttribute("loginUser");
                if (user != null) {
                    System.out.println("welcome页面对登录后用户测试点:" + user.getAdminName() + "===" + user.getAdminEmail());

                    //将获取Session内存储用户后将user的name放入model发送到页面
                    model.addAttribute("username_ok", user.getAdminName());
                }

            }
        }


        return "welcome";
    }


}

