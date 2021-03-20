package com.example.demo.controller;


import com.example.demo.entity.Dajuan;
import com.example.demo.entity.Student;
import com.example.demo.service.DajuanService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Dajuan)表控制层
 *
 * @author makejava
 * @since 2021-03-17 15:27:33
 */
@RestController
@RequestMapping("dajuan")
public class DajuanController {
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
    public Dajuan selectOne(Integer id) {
        return this.dajuanService.queryById(id);
    }
    //------------------------------------------------------------------------------------------


    //添加习题到预备答卷中
    @GetMapping("sendAllMessage")
    public int sendAllMessage(Integer kaoshima) {

        Dajuan dajuan = new Dajuan();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Student user = (Student) request.getSession().getAttribute("loginUser");

        dajuan.setKaoshima(kaoshima);
        dajuan.setStudentid(user.getStudentId());


        return this.dajuanService.sendAllMessage(dajuan);
    }
    //------------------------------------------------------------------------------------------


}