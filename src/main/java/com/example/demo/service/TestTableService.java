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
     * 新增数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    TestTable insert(TestTable testTable);

    /**
     * 修改数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    TestTable update(TestTable testTable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    // ----------------------------   有效代码    ----------------------------


    /**
     * 分页
     * @param testTable
     * @return
     */
    R select_all(TestTable testTable);


    /**
     * 根据id查询
     *
     * @param testid
     * @return
     */
    List<TestTable> selectByTestId(Integer testid);
}