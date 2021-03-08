package com.example.demo.dao;


import com.example.demo.entity.BankFill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 提空题题库(BankFill)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-09 14:25:47
 */
@Mapper
public interface BankFillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BankFill queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BankFill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param bankFill 实例对象
     * @return 对象列表
     */
    List<BankFill> queryAll(BankFill bankFill);

    /**
     * 新增数据
     *
     * @param bankFill 实例对象
     * @return 影响行数
     */
    int insert(BankFill bankFill);

    /**
     * 修改数据
     *
     * @param bankFill 实例对象
     * @return 影响行数
     */
    int update(BankFill bankFill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}