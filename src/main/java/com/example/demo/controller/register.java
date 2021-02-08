package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author DONG
 * @title: register
 * @projectName demo
 * @description: TODO
 * @date 2021/1/23        16:00
 */

@Controller
public class register {

    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private AdminService adminService;

    @RequestMapping({"/register.html", "/register"})//注册页
    public String register() {


        return "register";
    }

    @ResponseBody
    @PostMapping("/PostSignUp")
    public String main(User user, Model model) {


        //学生登录即返回student
        //教师登录即返回teacher
        //管理员登录即返回admin
        System.out.println("注册—邮箱测试点：" + user.getEmail());
        System.out.println("注册—密码测试点：" + user.getPassword());
        System.out.println("注册—身份测试点：" + user.getShenfen());

        //如果身份选择为学生
        if (user.getShenfen().equals("student")) {


            //查询该电子邮箱是否注册过
            Student old_student = this.studentService.student_queryByEmail(user.getEmail());
            System.out.println("old_student:" + user.getEmail() + "/" + old_student);

            //如果电子邮箱不存在，即该电子邮箱未注册过
            if (old_student == null) {

                //创建学生类
                Student students = new Student();
                students.setStudentEmail(user.getEmail());
                students.setStudentPassword(user.getPassword());

                //添加账号信息
                int tag = this.studentService.register_student(students);
                System.out.println("用户不存在，执行添加用户");
                System.out.println("register_student.tag:" + tag);
                if (tag != 1) {
                    //传递（"账号已存在" 2002）信息--数据库插入数据失败
                    model.addAttribute("have", "2004");
                    return "2004";
                } else {
                    //数据库插入数据成功
                    model.addAttribute("have", "2000");
                    return "2000";
                }
            } else {
                System.out.println("用户存在");
                //账号已存在" 2002
                model.addAttribute("have", "2002");
                return "2002";
            }

        } else if (user.getShenfen().equals("teacher")) {
            //如果身份选择为教师

            //查询该电子邮箱是否注册过
            Teacher old_teacher = this.teacherService.teacher_queryByEmail(user.getEmail());
            System.out.println("old_teacher:" + user.getEmail() + "/" + old_teacher);

            //如果电子邮箱不存在，即该电子邮箱未注册过
            if (old_teacher == null) {

                //创建教师类
                Teacher teachers = new Teacher();
                teachers.setTeacherEmail(user.getEmail());
                teachers.setTeacherPassword(user.getPassword());

                //添加教师
                int tag = this.teacherService.register_teacher(teachers);
                System.out.println("用户不存在，执行添加用户");
                System.out.println("register_teacher.tag:" + tag);

                if (tag != 1) {
                    //传递（"账号已存在" 2004）信息====数据库插入数据失败
                    model.addAttribute("have", "2004");
                    System.out.println("2004");
                    return "2004";
                } else {
                    //数据库插入数据成功
                    model.addAttribute("have", "2000");
                    System.out.println("2000");
                    return "2000";
                }
            } else {
                System.out.println("用户存在");
                //"账号已存在" 2002
                model.addAttribute("have", "2002");
                System.out.println("2002");
                return "2002";
            }

        }else {
            return "2006";
        }


    }


}
