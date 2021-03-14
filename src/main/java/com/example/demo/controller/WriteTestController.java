package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.TestService;
import com.example.demo.service.TestTableService;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
    @Resource
    private TestService testService;


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
     * 教师进入添加试卷(试题)界面
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


    /**
     * 分页查询考试信息-开始结束时间-出题人-考试编号-考试名称
     *
     * @param test
     * @return
     */

    @ResponseBody
    @PostMapping("/chakan/select_all")
    public R select_all(Test test) {

        System.out.println("传值test:" + test);


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher user = (Teacher) request.getSession().getAttribute("loginUser");


        //核心
        R r = this.testService.select_all(test);


        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("1:" + r.getData());


        //将r.getData()解析为list数组
        List<Test> testList = (List<Test>) r.getData();

        System.out.println("teacher.getTeacherId()" + user.getTeacherId());

        for (int i = 0; i < testList.size(); i++) {
            //如果当前教师id与题库的出题教师id相同
            if ((user.getTeacherId()).equals(testList.get(i).getTeacherid())) {
                testList.get(i).setQuanxian(1);
            } else {
                testList.get(i).setQuanxian(0);
            }
        }

        System.out.println("2:" + r.getData());
        return r;
    }


    /**
     * 将题库里的题加入到试卷中
     *
     * @param testTable
     * @return
     */
    @ResponseBody
    @GetMapping("/chakan/AddTestTable")
    public int AddTestTable(TestTable testTable) {

        System.out.println("将题添加到试卷- 测试点" + testTable);
        int i = 0;

        i = testTableService.insert(testTable);

        return i;
    }

    /**
     * 将试卷里的题移除
     *
     * @param testTable
     * @return
     */
    @ResponseBody
    @GetMapping("/chakan/DelTestTable")
    public boolean DelTestTable(TestTable testTable) {

        System.out.println("将试卷里的题移除-测试点" + testTable);


        boolean t = testTableService.deleteById(testTable);

        return t;
    }










}
