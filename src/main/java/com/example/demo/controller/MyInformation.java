package com.example.demo.controller;

/**
 * @author DONG
 * @title: MyInformation
 * @projectName demo
 * @description: TODO
 * @date 2021/2/1        16:27
 */


import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 完善-填写个人信息
 */
@Controller
public class MyInformation {

    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private AdminService adminService;


    /**
     * //访问完善信息页面
     * //学生
     *
     * @return
     */
    @RequestMapping({"/studentInformation.html", "/studentInformation"})
    public String studentInformation(HttpSession session, Model model) {

        System.out.println("当前访问studentInformation.html");


        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        //根据Session的账号和密码获得学生所有信息
        //信息存入Session的loginUser中
        List<Student> student = this.studentService.select_one_login(user.getEmail(), user.getPassword());
        System.out.println(student.get(0));
        Student studentuser = new Student();
        studentuser = student.get(0);
        session.setAttribute("loginUser", studentuser);


        return "studentInformation";
    }







    /**
     * //访问完善信息页面
     * //教师
     *
     * @return
     */
    @RequestMapping({"/teacherInformation.html", "/teacherInformation"})
    public String teacherInformation(HttpSession session, Model model) {

        System.out.println("当前访问teacherInformation.html并刷新数据");


        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        //根据Session的账号和密码获得学生所有信息
        //信息存入Session的loginUser中
        List<Teacher> teachers = this.teacherService.select_teacher_login(user.getEmail(), user.getPassword());
        System.out.println("根据Session的账号和密码获得学生所有信息"+teachers.get(0));

        Teacher teacher = new Teacher();
        teacher = teachers.get(0);
        session.setAttribute("loginUser", teacher);


        return "teacherInformation";
    }



}
