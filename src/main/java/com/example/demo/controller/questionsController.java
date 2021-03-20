package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.stream.Entity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class questionsController {


    @Resource
    private BankChoiceService bankChoiceService;
    @Resource
    private BankFillService bankFillService;
    @Resource
    private BankSubjectiveService bankSubjectiveService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private TestService testService;


    //-------------------------------------------------------------单选题主观题填空题页面跳转------------------------------------------------
    /**
     * 单选
     *
     * @return
     */
    @RequestMapping({"/teacher_danxuan.html", "/teacher_danxuan"})
    public String dan() {
        return "teacher_danxuan";
    }


    /**
     * 填空题
     *
     * @return
     */
    @RequestMapping({"/teacher_tiankong.html", "/teacher_tiankong"})
    public String tiankong() {
        return "teacher_tiankong";
    }


    /**
     * 主观题
     *
     * @return
     */
    @RequestMapping({"/teacher_zhuguan.html", "/teacher_zhuguan"})
    public String zhuguan() {
        return "teacher_zhuguan";
    }

    //==============================单选题--测试部分begin==============================-->

    @ResponseBody
    @PostMapping("/bankChoiceService/select_all")
    public R select_all(BankChoice bankChoice, HttpSession session, Model model) {

        System.out.println("传值" + bankChoice);


        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        //根据Session的账号和密码获得学生所有信息
        //信息存入Session的loginUser中
        List<Teacher> teachers = this.teacherService.select_teacher_login(user.getEmail(), user.getPassword());
        System.out.println("根据Session的账号和密码获得教师所有信息" + teachers.get(0));

        Teacher teacher = new Teacher();
        teacher = teachers.get(0);

        System.out.println("teacher.getTeacherId():" + teacher.getTeacherId());


        R r = this.bankChoiceService.select_all(bankChoice);


        System.out.println("++++++++++++++++++++++++++++");
        System.out.println(r.getData());


        //将r.getData()解析为list数组
        List<BankChoice> bankChoiceList = (List<BankChoice>) r.getData();

        System.out.println("teacher.getTeacherId()" + teacher.getTeacherId());

        for (int i = 0; i < bankChoiceList.size(); i++) {
            //如果当前教师id与题库的出题教师id相同
            if ((teacher.getTeacherId()).equals(bankChoiceList.get(i).getTeacherid())) {

                bankChoiceList.get(i).setQuanxian(1);
            } else {

                bankChoiceList.get(i).setQuanxian(0);
            }
        }


        return r;
    }


    @ResponseBody
    @GetMapping("/bankChoiceService/get")
    public BankChoice getById(Integer id) {

        System.out.println("bankChoiceService/getById:" + id);
        return bankChoiceService.queryById(id);
    }

    /**
     * 添加
     *
     * @param bankChoice
     * @return
     */
    @ResponseBody
    @GetMapping("/bankChoiceService/add")
    public boolean choice_add(BankChoice bankChoice) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher user = (Teacher) request.getSession().getAttribute("loginUser");

        System.out.println("teacher:" + user);

        bankChoice.setTeacherid(user.getTeacherId());

        System.out.println("add/bankChoice:" + bankChoice);

        boolean t = this.bankChoiceService.insert(bankChoice);

        System.out.println("add/t:" + t);

        return t;

    }

    /**
     * 修改
     *
     * @param bankChoice
     * @return
     */
    @ResponseBody
    @GetMapping("/bankChoiceService/up")
    public int choice_up(BankChoice bankChoice) {

        System.out.println("up/bankChoice:" + bankChoice);

        int t = this.bankChoiceService.update(bankChoice);

        System.out.println("up/t:" + t);

        return t;

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/bankChoiceService/del")
    public int choice_del(Integer id) {


        System.out.println("del/id:" + id);

        int t = this.bankChoiceService.deleteById(id);

        System.out.println("del/t:" + t);

        return t;

    }
    //==============================提空题--测试部分begin==============================-->

    @ResponseBody
    @PostMapping("/bankFillService/select_all")
    public R select_all_tiankong(BankFill bankFill) {

        System.out.println("bankFillService传值:" + bankFill);


        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        //根据Session的账号和密码获得学生所有信息
        //信息存入Session的loginUser中
        List<Teacher> teachers = this.teacherService.select_teacher_login(user.getEmail(), user.getPassword());
        System.out.println("根据Session的账号和密码获得学生所有信息" + teachers.get(0));

        Teacher teacher = new Teacher();
        teacher = teachers.get(0);

        System.out.println("teacher.getTeacherId():" + teacher.getTeacherId());


        //核心
        R r = this.bankFillService.select_all(bankFill);


        System.out.println("++++++++++++++++++++++++++++");
        System.out.println(r.getData());


        //将r.getData()解析为list数组
        List<BankFill> bankFillList = (List<BankFill>) r.getData();

        System.out.println("teacher.getTeacherId()" + teacher.getTeacherId());

        for (int i = 0; i < bankFillList.size(); i++) {
            //如果当前教师id与题库的出题教师id相同
            if ((teacher.getTeacherId()).equals(bankFillList.get(i).getTeacherid())) {
                bankFillList.get(i).setQuanxian(1);
            } else {
                bankFillList.get(i).setQuanxian(0);
            }
        }


        return r;
    }


    @ResponseBody
    @GetMapping("/bankFillService/get")
    public BankFill getById_tiankong(Integer id) {

        System.out.println("bankFillService/getById:" + id);
        return bankFillService.queryById(id);
    }

    /**
     * 添加
     *
     * @param bankFill
     * @return
     */
    @ResponseBody
    @GetMapping("/BankFillService/add")
    public boolean choice_add(BankFill bankFill) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher user = (Teacher) request.getSession().getAttribute("loginUser");

        System.out.println("teacher:" + user);

        bankFill.setTeacherid(user.getTeacherId());

        System.out.println("add/BankFill:" + bankFill);

        boolean t = this.bankFillService.insert(bankFill);

        System.out.println("add/t:" + t);

        return t;

    }

    /**
     * 修改
     *
     * @param bankFill
     * @return
     */
    @ResponseBody
    @GetMapping("/BankFillService/up")
    public int choice_up(BankFill bankFill) {

        System.out.println("up/BankFill:" + bankFill);

        int t = this.bankFillService.update(bankFill);

        System.out.println("up/t:" + t);

        return t;

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/BankFillService/del")
    public int fill_del(Integer id) {


        System.out.println("del/id:" + id);

        int t = this.bankFillService.deleteById(id);

        System.out.println("del/t:" + t);

        return t;

    }
    //==============================主观题--测试部分begin==============================-->

    @ResponseBody
    @PostMapping("/bankSubjectiveService/select_all")
    public R select_all_zhuguan(BankSubjective bankSubjective) {

        System.out.println("传值bankSubjective:" + bankSubjective);

        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        //根据Session的账号和密码获得学生所有信息
        //信息存入Session的loginUser中
        List<Teacher> teachers = this.teacherService.select_teacher_login(user.getEmail(), user.getPassword());
        System.out.println("根据Session的账号和密码获得学生所有信息" + teachers.get(0));

        Teacher teacher = new Teacher();
        teacher = teachers.get(0);

        System.out.println("teacher.getTeacherId():" + teacher.getTeacherId());


        //核心
        R r = this.bankSubjectiveService.select_all(bankSubjective);


        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("1:" + r.getData());


        //将r.getData()解析为list数组
        List<BankSubjective> subjectiveList = (List<BankSubjective>) r.getData();

        System.out.println("teacher.getTeacherId()" + teacher.getTeacherId());

        for (int i = 0; i < subjectiveList.size(); i++) {
            //如果当前教师id与题库的出题教师id相同
            if ((teacher.getTeacherId()).equals(subjectiveList.get(i).getTeacherid())) {
                subjectiveList.get(i).setQuanxian(1);
            } else {
                subjectiveList.get(i).setQuanxian(0);
            }
        }
        System.out.println("2:" + r.getData());

        return r;
    }

    @ResponseBody
    @GetMapping("/bankSubjectiveService/get")
    public BankSubjective getById_zhuguan(Integer id) {

        System.out.println("bankSubjective/getById:" + id);
        return bankSubjectiveService.queryById(id);
    }


    /**
     * 添加
     *
     * @param bankSubjective
     * @return
     */
    @ResponseBody
    @GetMapping("/BankSubjectiveService/add")
    public boolean subjectivity_add(BankSubjective bankSubjective) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher user = (Teacher) request.getSession().getAttribute("loginUser");

        System.out.println("teacher:" + user);

        bankSubjective.setTeacherid(user.getTeacherId());

        System.out.println("add/BankSubjective:" + bankSubjective);

        boolean t = this.bankSubjectiveService.insert(bankSubjective);

        System.out.println("add/t:" + t);

        return t;

    }

    /**
     * 修改
     *
     * @param bankSubjective
     * @return
     */
    @ResponseBody
    @GetMapping("/BankSubjectiveService/up")
    public int subjectivity_up(BankSubjective bankSubjective) {

        System.out.println("up/BankSubjective:" + bankSubjective);

        int t = this.bankSubjectiveService.update(bankSubjective);

        System.out.println("up/t:" + t);

        return t;

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping("/BankSubjectiveService/del")
    public int subjectivity_del(Integer id) {


        System.out.println("del/id:" + id);

        int t = this.bankSubjectiveService.deleteById(id);

        System.out.println("del/t:" + t);

        return t;

    }


}
