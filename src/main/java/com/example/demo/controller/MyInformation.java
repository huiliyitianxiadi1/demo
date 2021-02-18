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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println("根据Session的账号和密码获得学生所有信息" + teachers.get(0));

        Teacher teacher = new Teacher();
        teacher = teachers.get(0);
        session.setAttribute("loginUser", teacher);


        return "teacherInformation";
    }


    /***
     * 学生端
     * 上传学生证
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/addImg", method = RequestMethod.POST)
    @ResponseBody
    public String addImg(@RequestParam("file") MultipartFile file) {

        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");


        System.out.println("---addImg--- ");
        System.out.println("---获得当前Session的账号密码---begin");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getShenfen());
        System.out.println("---获得当前Session的账号密码---end");


        Student student = new Student();
        student.setStudentEmail(user.getEmail());
        student.setStudentStatus("2");


        try {
            byte[] data;
            data = file.getBytes();


            student.setPhoto(data);
            //插入数据库
            int tag = studentService.update(student);
            if (tag == 1) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }


    /**
     * 学生端
     * 显示学生证
     *
     * @param response
     */
    @RequestMapping(value = "/getImgById", method = RequestMethod.GET)
    public void getImgById(HttpServletResponse response) {

        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");


        System.out.println("---getImgById--- ");
        System.out.println("---获得当前Session的账号密码---begin");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getShenfen());
        System.out.println("---获得当前Session的账号密码---end");

        try {
            List<Student> students = studentService.select_one_login(user.getEmail(), user.getPassword());


            Student student = new Student();

            student = students.get(0);


            byte[] data = student.getPhoto();
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputSream = response.getOutputStream();
            outputSream.write(data);
            outputSream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /***
     * 教师端
     * 上传职工证
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/addImg_tea", method = RequestMethod.POST)
    @ResponseBody
    public String addImg_tea(@RequestParam("file") MultipartFile file) {

        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        System.out.println("---addImg_tea--- ");
        System.out.println("---获得当前Session的账号密码---begin");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getShenfen());
        System.out.println("---获得当前Session的账号密码---end");


        Teacher teacher = new Teacher();
        teacher.setTeacherEmail(user.getEmail());
        teacher.setTeacherStatus("2");


        try {
            byte[] data;
            data = file.getBytes();


            teacher.setPhoto(data);
            //插入数据库
            int tag = teacherService.update(teacher);
            if (tag == 1) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }


    /**
     * 教师端
     * 显示职工证
     *
     * @param response
     */
    @RequestMapping(value = "/getImgById_tea", method = RequestMethod.GET)
    public void getImgById_tea(HttpServletResponse response) {

        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        System.out.println("---getImgById_tea---");
        System.out.println("---获得当前Session的账号密码---begin");
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
        System.out.println(user.getShenfen());
        System.out.println("---获得当前Session的账号密码---end");

        try {
            List<Teacher> teachers = teacherService.select_teacher_login(user.getEmail(), user.getPassword());


            Teacher teacher = new Teacher();

            teacher = teachers.get(0);


            byte[] data = teacher.getPhoto();
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputSream = response.getOutputStream();
            outputSream.write(data);
            outputSream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
