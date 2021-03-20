package com.example.demo.service;

import com.example.demo.entity.Dajuan;

import java.util.List;

/**
 * (Dajuan)表服务接口
 *
 * @author makejava
 * @since 2021-03-17 15:27:33
 */
public interface DajuanService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dajuan queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dajuan> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dajuan 实例对象
     * @return 实例对象
     */
    Dajuan insert(Dajuan dajuan);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    //------------------------------------------------------------------------------------------

    /**
     * 新增数据
     *
     * @param dajuan 实例对象
     * @return 实例对象
     */
    int sendAllMessage(Dajuan dajuan);


    //------------------------------------------学生查看答卷------------------------------------------------
    List<Dajuan> selectShiJuanDan(Dajuan dajuan);

    List<Dajuan> selectShiJuanTian(Dajuan dajuan);

    List<Dajuan> selectShiJuanZhu(Dajuan dajuan);


    //------------------------------------------------------------------------------------------
    /**
     * 学生填写试卷
     *
     * @param dajuan 实例对象
     * @return 实例对象
     */
    int update(Dajuan dajuan);


}