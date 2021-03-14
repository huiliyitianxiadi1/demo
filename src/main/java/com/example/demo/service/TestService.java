package com.example.demo.service;

import com.example.demo.entity.R;
import com.example.demo.entity.Test;
import com.example.demo.entity.Test;

import java.util.List;

/**
 * (Test)表服务接口
 *
 * @author makejava
 * @since 2021-03-15 18:30:01
 */
public interface TestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Test queryById(Integer id);




    // ----------------------------   有效代码    ----------------------------


    /**
     * 分页
     * @param test
     * @return
     */
    R select_all(Test test);



    /**
     * 新增数据
     *
     * @param test 实例对象
     * @return 实例对象
     */
    int insert(Test test);

    /**
     * 修改数据
     *
     * @param test 实例对象
     * @return 实例对象
     */
    int update(Test test);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}