package com.example.demo.dao;


import com.example.demo.entity.BankChoice;
import com.example.demo.entity.R;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 选择题题库(BankChoice)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-09 14:25:50
 */
@Mapper
public interface BankChoiceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BankChoice queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<BankChoice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bankChoice 实例对象
     * @return 对象列表
     */
    List<BankChoice> queryAll(BankChoice bankChoice);

    /**
     * 新增数据
     *
     * @param bankChoice 实例对象
     * @return 影响行数
     */
    int insert(BankChoice bankChoice);

    /**
     * 修改数据
     *
     * @param bankChoice 实例对象
     * @return 影响行数
     */
    int update(BankChoice bankChoice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 以下为测试
     */

    //-------------------------------测试部分begin---------------------------//


    //查询分页数据

    /**
     *
     * @param rowBounds
     * @param map
     * @return
     */
    List<BankChoice> getUserList(RowBounds rowBounds, Map<String, Object> map);

    //查询数据总条数

    /**
     *
     * @param rowBounds
     * @param map
     * @return
     */
    int getUserListCount(RowBounds rowBounds, Map<String, Object> map);

}