package com.example.demo.service;

import com.example.demo.entity.BankSubjective;
import java.util.List;

/**
 * 主观题(BankSubjective)表服务接口
 *
 * @author makejava
 * @since 2021-03-09 14:25:47
 */
public interface BankSubjectiveService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BankSubjective queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BankSubjective> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bankSubjective 实例对象
     * @return 实例对象
     */
    BankSubjective insert(BankSubjective bankSubjective);

    /**
     * 修改数据
     *
     * @param bankSubjective 实例对象
     * @return 实例对象
     */
    BankSubjective update(BankSubjective bankSubjective);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}