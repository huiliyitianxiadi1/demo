package com.example.demo.controller;

import com.example.demo.entity.BankSubjective;
import com.example.demo.entity.Fileaddress;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.interceptor.ImgRegulation;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
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


    @RequestMapping({"/ceshi3.html", "/ceshi3"})//
    public String ceshi3() {
        return "ceshi3";
    }

}