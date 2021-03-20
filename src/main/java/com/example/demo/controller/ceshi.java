package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.interceptor.ImgRegulation;
import com.example.demo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class ceshi {

    @Resource
    private TestService testService;
    @Resource
    private DajuanService dajuanService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentTestService studentTestService;



    @RequestMapping({"/ceshi.html", "/ceshi"})//
    public String ceshi(Model model) {

        List<Test> list = this.studentTestService.TeacherSelectStudentTest();

        System.out.println("Teacher_Select_Student_Test_Html:" + list);

        model.addAttribute("lists", list);

        return "ceshi";
    }

    /**
     * 局部刷新，注意返回值
     *
     * @param model
     * @return
     */
    @RequestMapping("/local1")
    public String localRefresh(Model model) {
        List<Test> list = this.studentTestService.TeacherSelectStudentTest();

        System.out.println("Teacher_Select_Student_Test_Html/local:" + list);

        model.addAttribute("lists", list);

        // "test"是test.html的名，
        // "table_refresh"是test.html中需要刷新的部分标志,
        // 在标签里加入：th:fragment="table_refresh"
        return "ceshi::table_refresh";
    }

    @RequestMapping({"/ceshi2.html", "/ceshi2"})//
    public String ceshi2() {
        return "ceshi2";
    }


    @RequestMapping({"/ceshi3.html", "/ceshi3"})//
    public String ceshi3() {
        return "ceshi3";
    }






}