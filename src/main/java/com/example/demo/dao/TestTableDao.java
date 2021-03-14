package com.example.demo.dao;

import com.example.demo.entity.BankChoice;
import com.example.demo.entity.TestTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * (TestTable)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-12 14:43:03
 */
@Mapper
public interface TestTableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestTable queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TestTable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param testTable 实例对象
     * @return 对象列表
     */
    List<TestTable> queryAll(TestTable testTable);

    /**
     * 新增数据
     *
     * @param testTable 实例对象
     * @return 影响行数
     */
    int insert(TestTable testTable);

    /**
     * 修改数据
     *
     * @param testTable 实例对象
     * @return 影响行数
     */
    int update(TestTable testTable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);



//  ------------------------------------------------------------------------  有效代码    -----------------------------------------------------------------------

    /**
     * 根据id查询
     * @param testid
     * @return
     */
    List<TestTable> selectByTestId(Integer testid);



    //查询分页数据

    /**
     * @param rowBounds
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


}