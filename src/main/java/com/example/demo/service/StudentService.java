package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2021-01-25 15:19:22
 */
public interface StudentService {


    //-----------------------------------------------增-----------------------------------------------

    /**
     * 注册功能
     *
     * @param student 添加的学生信息
     * @return
     */
    public int register_student(Student student);

    //-----------------------------------------------查-----------------------------------------------

    /**
     * 通过Istudentd和studentPassword查询单条数据
     *
     * @param studentEmail    登录账号
     * @param studentPassword 登录密码
     * @return
     */
    public List<Student> select_one_login(String studentEmail, String studentPassword);


    /**
     * 根据studentEmail来查找用户
     *
     * @param studentEmail
     * @return
     */
    public Student student_queryByEmail(String studentEmail);
    //-------------------------------分割线---------------------------//

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    Student queryById(Integer studentId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer studentId);

}