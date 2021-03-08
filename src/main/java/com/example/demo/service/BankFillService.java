package com.example.demo.service;



import com.example.demo.entity.BankFill;
import java.util.List;

/**
 * 提空题题库(BankFill)表服务接口
 *
 * @author makejava
 * @since 2021-03-09 14:25:49
 */
public interface BankFillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BankFill queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BankFill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param bankFill 实例对象
     * @return 实例对象
     */
    BankFill insert(BankFill bankFill);

    /**
     * 修改数据
     *
     * @param bankFill 实例对象
     * @return 实例对象
     */
    BankFill update(BankFill bankFill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}