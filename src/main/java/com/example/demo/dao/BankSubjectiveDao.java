package com.example.demo.dao;


import com.example.demo.entity.BankFill;
import com.example.demo.entity.BankSubjective;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 主观题(BankSubjective)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-09 14:25:47
 */
@Mapper
public interface BankSubjectiveDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BankSubjective queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BankSubjective> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bankSubjective 实例对象
     * @return 对象列表
     */
    List<BankSubjective> queryAll(BankSubjective bankSubjective);

    /**
     * 新增数据
     *
     * @param bankSubjective 实例对象
     * @return 影响行数
     */
    int insert(BankSubjective bankSubjective);

    /**
     * 修改数据
     *
     * @param bankSubjective 实例对象
     * @return 影响行数
     */
    int update(BankSubjective bankSubjective);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);



    //-------------------------------测试部分begin---------------------------//


    //查询分页数据

    /**
     * @param rowBounds
     * @param map
     * @return
     */
    List<BankSubjective> getUserList(RowBounds rowBounds, Map<String, Object> map);

    //查询数据总条数

    /**
     * @param rowBounds
     * @param map
     * @return
     */
    int getUserListCount(RowBounds rowBounds, Map<String, Object> map);


}