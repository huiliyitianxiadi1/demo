package com.example.demo.controller;

import com.example.demo.entity.Student;
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
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

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


}
