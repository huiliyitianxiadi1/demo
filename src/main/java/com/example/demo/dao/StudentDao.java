package com.example.demo.dao;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 15:19:21
 */
@Mapper
public interface StudentDao {

    //-----------------------------------------------增-----------------------------------------------

    /**
     * @param student 添加的学生信息
     * @return
     */
    int register_student(Student student);


    //-----------------------------------------------查-----------------------------------------------

    /***
     *  通过studentEmail和studentPassword查询单条数据
     * @param studentEmail 登录账号
     * @param studentPassword 登录密码
     * @return
     */
    List<Student> select_one_login(@Param("studentEmail") String studentEmail, @Param("studentPassword") String studentPassword);


    /**
     * 根据studentEmail来查找用户
     *
     * @param studentEmail
     * @return
     */
    Student student_queryByEmail(String studentEmail);


    //-------------------------------分割线---------------------------//

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    Student queryById(Integer studentId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param student 实例对象
     * @return 对象列表
     */
    List<Student> queryAll(Student student);

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int insert(Student student);

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 影响行数
     */
    int update(Student student);

    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 影响行数
     */
    int deleteById(Integer studentId);

}