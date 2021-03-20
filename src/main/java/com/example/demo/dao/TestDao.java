package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.Test;
import com.example.demo.entity.TestTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

/**
 * (Test)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-15 18:30:01
 */
@Mapper
public interface TestDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Test queryById(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param test 实例对象
     * @return 对象列表
     */
    List<Test> queryAll(Test test);

//  ------------------------------------------------------------------------  有效代码    -----------------------------------------------------------------------


    /**
     //查询分页数据
     * @param map
     * @return
     */
    List<TestTable> getUserList(RowBounds rowBounds, Map<String, Object> map);

    //查询数据总条数

    /**
     * @param rowBounds
     * @param map
     * @return
     */
    int getUserListCount(RowBounds rowBounds, Map<String, Object> map);


    /**
     * 新增数据
     *
     * @param test 实例对象
     * @return 影响行数
     */
    int insert(Test test);

    /**
     * 修改数据
     *
     * @param test 实例对象
     * @return 影响行数
     */
    int update(Test test);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


}


