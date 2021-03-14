package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.Test;
import com.example.demo.service.TestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * (Test)表控制层
 *
 * @author makejava
 * @since 2021-03-15 18:30:01
 */
@RestController
@RequestMapping("test")
public class TestController {
    /**
     * 服务对象
     */
    @Resource
    private TestService testService;


//=============================================================================================

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Test selectOne(Integer id) {
        return this.testService.queryById(id);
    }

    /**
     * 添加考试
     *
     * @return 单条数据
     */
    @GetMapping("AddTest")
    public int AddTest(Test test) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher user = (Teacher) request.getSession().getAttribute("loginUser");

        test.setTeacherid(user.getTeacherId());

        System.out.println("添加一条考试test接收：" + test);
        return this.testService.insert(test);
    }


    /**
     * 修改
     *
     * @return 单条数据
     */
    @GetMapping("UpTest")
    public int UpTest(Test test) {
        System.out.println("修改一条考试test接收：" + test);
        return this.testService.update(test);
    }


    /**
     * 通过主键删除
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("DelTest")
    public boolean DelTest(Integer id) {
        System.out.println("删除一条考试id接收：" + id);
        return this.testService.deleteById(id);
    }


}