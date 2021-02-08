package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2021-01-25 17:15:45
 */
public interface AdminService {


    /***
     * 通过adminEmail和adminPassword查询单条数据
     * @param adminEmail 登录账号
     * @param adminPassword 登录密码
     * @return
     */
    List<Admin> select_admin_login(String adminEmail, String adminPassword);


    //-------------------------------分割线---------------------------//


    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    Admin queryById(Integer adminId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer adminId);

}