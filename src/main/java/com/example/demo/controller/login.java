package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author DONG
 * @title: login
 * @projectName demo
 * @description: TODO
 * @date 2021/1/21        23:12
 */
@Slf4j
@Controller
public class login {

    /**
     * 首先可以通过注解的方式  获取一个 request
     */
    @Autowired
    HttpServletRequest request;
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private AdminService adminService;

    @RequestMapping({"/login.html", "/login"})//访问登录页
    public String login() {
        return "login";
    }


    @PostMapping("/Postlogin")
    public String main(User user, HttpSession session, Model model) {

        //学生登录即返回student
        //教师登录即返回teacher
        //管理员登录即返回admin
        System.out.println("身份测试点：" + user.getShenfen());

        session.setAttribute("shenfen", user);


        if (user.getShenfen().equals("student")) {
            //如果身份选择为学生
            List<Student> student = this.studentService.select_one_login(user.getEmail(), user.getPassword());

            if (student.size() == 1) {
                System.out.println("学生login测试点：" + student.get(0));

                Student studentuser = new Student();
                studentuser = student.get(0);

                //把登陆成功的用户保存起来
                session.setAttribute("loginUser", studentuser);
                //登录成功重定向到main.html;  重定向防止表单重复提交
                return "redirect:/welcome.html";
            }

        } else if (user.getShenfen().equals("teacher")) {
            //选择身份为教师
            List<Teacher> teacher = this.teacherService.select_teacher_login(user.getEmail(), user.getPassword());

            if (teacher.size() == 1) {
                System.out.println("教师login测试点：" + teacher.get(0));

                Teacher teacheruser = new Teacher();
                teacheruser = teacher.get(0);

                //把登陆成功的用户保存起来
                session.setAttribute("loginUser", teacheruser);
                //登录成功重定向到main.html;  重定向防止表单重复提交
                return "redirect:/welcome.html";
            }
        } else if (user.getShenfen().equals("admin")) {
            //选择身份为管理员
            List<Admin> admin = this.adminService.select_admin_login(user.getEmail(), user.getPassword());

            if (admin.size() == 1) {
                System.out.println("管理员login测试点：" + admin.get(0));

                Admin adminuser = new Admin();
                adminuser = admin.get(0);

                //把登陆成功的用户保存起来
                session.setAttribute("loginUser", adminuser);
                //登录成功重定向到main.html;  重定向防止表单重复提交
                return "redirect:/welcome.html";
            }


        }


        //传递（账号或密码错误）信息
        model.addAttribute("msg", "账号或密码错误");
        //重新回到登录页面
        return "login";
    }


}
