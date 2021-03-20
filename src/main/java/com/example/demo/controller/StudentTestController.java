package com.example.demo.controller;

import java.util.Date;

import com.example.demo.entity.*;
import com.example.demo.service.DajuanService;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentTestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * 考试与学生关系表(StudentTest)表控制层
 *
 * @author makejava
 * @since 2021-03-17 01:53:49
 */
@RestController
@RequestMapping("studentTest")
public class StudentTestController {
    /**
     * 服务对象
     */
    @Resource
    private StudentTestService studentTestService;
    @Resource
    private StudentService studentService;
    /**
     * 服务对象
     */
    @Resource
    private DajuanService dajuanService;



    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public StudentTest selectOne(Integer id) {
        return this.studentTestService.queryById(id);
    }


    //=====================================有效代码==========================

    /**
     * 添加
     *
     * @return 单条数据
     */
    @GetMapping("insert")
    public int selectOne(StudentTest studentTest) {


        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Student user = (Student) request.getSession().getAttribute("loginUser");


        System.out.println("studentTest/insert----------begin");
        studentTest.setStudentid(user.getStudentId());
        studentTest.setNy(-1);


        System.out.println("学生Id：" + studentTest.getStudentid());
        System.out.println("考试码Id：" + studentTest.getTestid());

        System.out.println("studentTest/insert----------end");


        List<StudentTest> studentTestList = new LinkedList<>();
        studentTestList = this.studentTestService.queryAll(studentTest);

        int w = -1;

        //判断是否存在
        w = studentTestList.size();
        System.out.println("判断点=w:" + w);
        int t = -1;
        if (w == 0) {
            t = this.studentTestService.insert(studentTest);
            System.out.println("执行添加操作" + t);
        } else {
            t = -1;
        }


        Dajuan dajuan = new Dajuan();


        dajuan.setKaoshima( studentTest.getTestid());
        dajuan.setStudentid(user.getStudentId());


         int wx= this.dajuanService.sendAllMessage(dajuan);



        //

        return t;
    }


}