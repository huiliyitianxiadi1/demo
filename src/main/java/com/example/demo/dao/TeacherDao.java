package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * (Teacher)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-25 17:15:45
 */
@Mapper
public interface TeacherDao {


    //-----------------------------------------------增-----------------------------------------------

    /**
     * @param teacher 添加的教师信息
     * @return
     */
    int register_teacher(Teacher teacher);


    //-----------------------------------------------查-----------------------------------------------
    /**
     * 通过teacherEmail和teacherPassword查询单条数据
     *
     * @param teacherEmail    登录账号
     * @param teacherPassword 登录密码
     * @return
     */
    List<Teacher> select_teacher_login(@Param("teacherEmail") String teacherEmail, @Param("teacherPassword") String teacherPassword);


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
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<Teacher> queryAll(Teacher teacher);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param teacherId 主键
     * @return 影响行数
     */
    int deleteById(Integer teacherId);


    //-------------------------------测试部分begin---------------------------//

    //查询分页数据

    /**
     *
     * @param rowBounds
     * @param map
     * @return
     */
    List<Teacher> getUserList(RowBounds rowBounds, Map<String, Object> map);

    //查询数据总条数

    /**
     *
     * @param rowBounds
     * @param map
     * @return
     */
    int getUserListCount(RowBounds rowBounds, Map<String, Object> map);


    //-------------------------------测试部分end---------------------------//



}