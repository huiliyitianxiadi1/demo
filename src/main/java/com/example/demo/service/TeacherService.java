package com.example.demo.service;


import com.example.demo.entity.R;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.Test;

import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author makejava
 * @since 2021-01-25 17:15:45
 */
public interface TeacherService {




    //-----------------------------------------------增-----------------------------------------------

    /**
     * 注册功能
     *
     * @param teacher 添加的教师信息
     * @return
     */
    public int register_teacher(Teacher teacher);

    //-----------------------------------------------查-----------------------------------------------

    /**
     * 通过teacherEmail和teacherPassword查询单条数据
     *
     * @param teacherEmail    登录账号
     * @param teacherPassword 登录密码
     * @return
     */
    List<Teacher> select_teacher_login(String teacherEmail, String teacherPassword);


    /***
     * 通过teacherEmail查询单条数据
     * @param teacherEmail 教师电子邮箱
     * @return 实例对象
     */
    Teacher teacher_queryByEmail(String teacherEmail);


    //-------------------------------分割线---------------------------//


    /**
     * 通过ID查询单条数据
     *
     * @param teacherId 主键
     * @return 实例对象
     */
    Teacher queryById(Integer teacherId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    Teacher insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param teacherId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer teacherId);



    //-------------------------------测试部分begin---------------------------//

    R getPageUserList(Teacher teacher);


    //-------------------------------测试部分end---------------------------//



}