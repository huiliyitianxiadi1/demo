package com.example.demo.service;

import com.example.demo.entity.BankChoice;
import com.example.demo.entity.R;
import com.example.demo.entity.TestTable;

import java.util.List;

/**
 * (TestTable)表服务接口
 *
 * @author makejava
 * @since 2021-03-12 14:43:03
 */
public interface TestTableService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestTable queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TestTable> queryAllByLimit(int offset, int limit);

    /**
     * 修改数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    TestTable update(TestTable testTable);



    // ----------------------------   测试代码    ----------------------------


    /**
     * 根据id查询
     *
     * @param testid
     * @return
     */
    List<TestTable> selectByTestId(Integer testid);


    // ----------------------------   有效代码    ----------------------------    ----------------------------        ----------------------------


    /**
     * 新增数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    int insert(TestTable testTable);



    /**
     * 根据传入类移除试卷
     *
     * @param testTable 传入类
     * @return 影响行数
     */
    boolean deleteById(TestTable testTable);

}