package com.example.demo.dao;


import com.example.demo.entity.Dajuan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dajuan)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-17 15:27:32
 */
@Mapper
public interface DajuanDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dajuan queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dajuan> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dajuan 实例对象
     * @return 对象列表
     */
    List<Dajuan> queryAll(Dajuan dajuan);

    /**
     * 新增数据
     *
     * @param dajuan 实例对象
     * @return 影响行数
     */
    int insert(Dajuan dajuan);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    //------------------------------------------------------------------------------------------

    /**
     * 新增数据
     *
     * @param dajuan 实例对象
     * @return 影响行数
     */
    int sendAllMessage(Dajuan dajuan);

//==========================================================学生查看答卷==========================================
    /**
     * 单选题
     *
     * @param dajuan
     * @return
     */
    List<Dajuan> selectShiJuanDan(Dajuan dajuan);


    /**
     * 填空题
     *
     * @param dajuan
     * @return
     */
    List<Dajuan> selectShiJuanTian(Dajuan dajuan);


    /**
     * 主观题
     *
     * @param dajuan
     * @return
     */
    List<Dajuan> selectShiJuanZhu(Dajuan dajuan);


//=========================================================================================================


    /**
     * 修改数据
     *
     * @param dajuan 实例对象
     * @return 影响行数
     */
    int update(Dajuan dajuan);

}