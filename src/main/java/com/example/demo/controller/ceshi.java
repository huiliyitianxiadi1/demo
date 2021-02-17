package com.example.demo.controller;

import com.example.demo.entity.Fileaddress;
import com.example.demo.entity.Student;
import com.example.demo.interceptor.ImgRegulation;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author DONG
 * @title: ceshi
 * @projectName demo
 * @description: TODO
 * @date 2021/1/27        18:00
 */
@Controller
public class ceshi {

    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    @RequestMapping({"/ceshi.html", "/ceshi"})//
    public String ceshi() {
        return "ceshi";
    }


    @RequestMapping({"/ceshi2.html", "/ceshi2"})//
    public String ceshi2() {
        return "ceshi2";
    }


    @RequestMapping(value = "/addImg", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addImg(HttpServletRequest request,
                                      @RequestParam("file") MultipartFile file) {

        Student student = new Student();
        student.setStudentEmail("1@qq.com");


        Map<String, Object> result = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        try {
            byte[] data;
            data = file.getBytes();
            params.put("img", data);

            student.setPhoto(data);
            studentService.update(student);
            //插入数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("message", "上传成功");
        return result;
    }


    @RequestMapping(value = "/getImgById", method = RequestMethod.GET)
    public void getImgById(@RequestParam(value = "id") Long id,
                           HttpServletResponse response) {
        try {
            List<Student> students = studentService.select_one_login("1@qq.com", "1");



            Student student = new Student();

            student = students.get(0);

            System.out.println("测试:"+student);

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
}