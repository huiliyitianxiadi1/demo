package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.BankChoiceService;
import com.example.demo.service.BankFillService;
import com.example.demo.service.BankSubjectiveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class questionsController {


    /**
     * 服务对象
     */
    @Resource
    private BankChoiceService bankChoiceService;

    /**
     * 服务对象
     */
    @Resource
    private BankFillService bankFillService;

    /**
     * 服务对象
     */
    @Resource
    private BankSubjectiveService bankSubjectiveService;

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
    public R select_all(BankChoice bankChoice) {

        System.out.println("传值" + bankChoice);

        R r = this.bankChoiceService.select_all(bankChoice);


        return r;
    }

    @ResponseBody
    @GetMapping("/bankChoiceService/get")
    public BankChoice getById(Integer id) {

        System.out.println("bankChoiceService/getById:" + id);
        return bankChoiceService.queryById(id);
    }


    //==============================提空题--测试部分begin==============================-->

    @ResponseBody
    @PostMapping("/bankFillService/select_all")
    public R select_all_tiankong(BankFill bankFill) {

        System.out.println("bankFillService传值:" + bankFill);




        R r = this.bankFillService.select_all(bankFill);


        return r;
    }

    @ResponseBody
    @GetMapping("/bankFillService/get")
    public BankFill getById_tiankong(Integer id) {

        System.out.println("bankFillService/getById:" + id);
        return bankFillService.queryById(id);
    }


    //==============================主观题--测试部分begin==============================-->

    @ResponseBody
    @PostMapping("/bankSubjectiveService/select_all")
    public R select_all_zhuguan(BankSubjective bankSubjective) {

        System.out.println("传值bankSubjective:" + bankSubjective);

        R r = this.bankSubjectiveService.select_all(bankSubjective);


        return r;
    }

    @ResponseBody
    @GetMapping("/bankSubjectiveService/get")
    public BankSubjective getById_zhuguan(Integer id) {

        System.out.println("bankSubjective/getById:" + id);
        return bankSubjectiveService.queryById(id);
    }

}
