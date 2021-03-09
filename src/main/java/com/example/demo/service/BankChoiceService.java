package com.example.demo.service;



import com.example.demo.entity.BankChoice;
import com.example.demo.entity.R;
import com.example.demo.entity.Student;

import java.util.List;

/**
 * 选择题题库(BankChoice)表服务接口
 *
 * @author makejava
 * @since 2021-03-09 14:25:50
 */
public interface BankChoiceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BankChoice queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BankChoice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bankChoice 实例对象
     * @return 实例对象
     */
    BankChoice insert(BankChoice bankChoice);

    /**
     * 修改数据
     *
     * @param bankChoice 实例对象
     * @return 实例对象
     */
    BankChoice update(BankChoice bankChoice);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    //-------------------------------测试部分begin---------------------------//
    /**
     *
     * @param bankChoice
     * @return
     */
    R select_all(BankChoice bankChoice);

}