package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminSpace {


    /**
     * 管理员空间
     * @return
     */
    @RequestMapping({"/AdminSpace.html", "/AdminSpace"})
    public String AdminSpace() {
        return "AdminSpace";
    }

    /**
     * 学生审核
     * @return
     */
    @RequestMapping({"/examineStudent.html", "/examineStudent"})
    public String examineStudent() {
        return "examineStudent";
    }

    /**
     *教师审核
     * @return
     */
    @RequestMapping({"/examineTeacher.html", "/examineTeacher"})
    public String examineTeacher() {
        return "examineTeacher";
    }

}
