package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.TestTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WriteTestController {

    @Resource
    private TestTableService testTableService;


    /**
     * 教师进入试卷管理界面
     *
     * @return
     */
    @RequestMapping({"/teacher_selectshijuan.html", "/teacher_selectshijuan"})
    public String teacher_selectshijuan() {
        return "teacher_selectshijuan";
    }

    /**
     * 教师进入添加试卷界面
     *
     * @return
     */
    @RequestMapping({"/teacher_Addshijuan.html", "/teacher_Addshijuan"})
    public String teacher_Addshijuan() {
        return "teacher_Addshijuan";
    }



    /**
     * 根据id查询此id下的试卷内容
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/chakan/sellectById")
    public List<TestTable> sellectById(Integer testid) {


        List<TestTable> testTable = this.testTableService.selectByTestId(testid);

        return testTable;
    }


    @ResponseBody
    @PostMapping("/chakan/select_all")
    public R select_all(TestTable testTable) {

        System.out.println("传值testTable:" + testTable);


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher user = (Teacher) request.getSession().getAttribute("loginUser");


        //核心
        R r = this.testTableService.select_all(testTable);


        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("1:" + r.getData());


        //将r.getData()解析为list数组
        List<TestTable> testTableList = (List<TestTable>) r.getData();

        System.out.println("teacher.getTeacherId()" + user.getTeacherId());

        for (int i = 0; i < testTableList.size(); i++) {
            //如果当前教师id与题库的出题教师id相同
            if ((user.getTeacherId()).equals(testTableList.get(i).getTeacherid())) {
                testTableList.get(i).setQuanxian(1);
            } else {
                testTableList.get(i).setQuanxian(0);
            }
        }

        System.out.println("2:" + r.getData());
        return r;
    }


}
