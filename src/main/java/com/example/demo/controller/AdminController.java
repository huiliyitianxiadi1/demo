package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author makejava
 * @since 2021-01-25 17:15:45
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;


    /***
     *  通过adminEmail和adminPassword查询单条数据
     * @param adminEmail 登录账号
     * @param adminPassword 登录密码
     * @return
     */

    //http://localhost:8080/admin/select_admin_login?adminEmail=123@qq.com&adminPassword=123
    @ResponseBody
    @GetMapping("select_admin_login")
    public List<Admin> select_admin_login(@Param("adminEmail") String adminEmail,
                                          @Param("adminPassword") String adminPassword) {
        System.out.println(adminEmail);
        System.out.println(adminPassword);
        List<Admin> admin = this.adminService.select_admin_login(adminEmail, adminPassword);
        if (admin.size() == 1) {
            System.out.println(admin.get(0));
        }
        return admin;
    }

    //-----------------------------------------------分界线

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Admin selectOne(Integer id) {
        return this.adminService.queryById(id);
    }

}