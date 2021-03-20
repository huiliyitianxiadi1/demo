package com.example.demo.dao;

import com.example.demo.entity.BankChoice;
import com.example.demo.entity.StudentTest;
import com.example.demo.entity.Test;
import com.example.demo.entity.TestTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 考试与学生关系表(StudentTest)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-17 01:53:49
 */
@Mapper
public interface StudentTestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    StudentTest queryById(Integer id);


    /**
     * 修改数据
     *
     * @param studentTest 实例对象
     * @return 影响行数
     */
    int update(StudentTest studentTest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    //=====================================有效代码==========================


    /**
     * 教师查询参加自己考试的学生

     * @return
     */
    List<Test> TeacherSelectStudentTest(Integer teacherid);

    /**
     * 获得所有该用户数据
     *
     * @return
     */
    List<StudentTest> getUserList(Integer studentid);


    /**
     * 新增数据
     *
     * @param studentTest 实例对象
     * @return 影响行数
     */
    int insert(StudentTest studentTest);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param studentTest 实例对象
     * @return 对象列表
     */

    List<StudentTest> queryAll(StudentTest studentTest);


}