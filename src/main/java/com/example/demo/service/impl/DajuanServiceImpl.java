package com.example.demo.service.impl;


import com.example.demo.dao.DajuanDao;
import com.example.demo.entity.Dajuan;
import com.example.demo.service.DajuanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dajuan)表服务实现类
 *
 * @author makejava
 * @since 2021-03-17 15:27:33
 */
@Service("dajuanService")
public class DajuanServiceImpl implements DajuanService {
    @Resource
    private DajuanDao dajuanDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dajuan queryById(Integer id) {
        return this.dajuanDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Dajuan> queryAllByLimit(int offset, int limit) {
        return this.dajuanDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dajuan 实例对象
     * @return 实例对象
     */
    @Override
    public Dajuan insert(Dajuan dajuan) {
        this.dajuanDao.insert(dajuan);
        return dajuan;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dajuanDao.deleteById(id) > 0;
    }


    //------------------------------------------------

    /**
     * 新增数据
     *
     * @param dajuan 实例对象
     * @return 实例对象
     */
    @Override
    public int sendAllMessage(Dajuan dajuan) {
        return this.dajuanDao.sendAllMessage(dajuan);
    }


    //=========================================学生查看试卷=============================================
    @Override
    public List<Dajuan> selectShiJuanDan(Dajuan dajuan) {
        return this.dajuanDao.selectShiJuanDan(dajuan);
    }

    @Override
    public List<Dajuan> selectShiJuanTian(Dajuan dajuan) {
        return this.dajuanDao.selectShiJuanTian(dajuan);
    }

    @Override
    public List<Dajuan> selectShiJuanZhu(Dajuan dajuan) {
        return this.dajuanDao.selectShiJuanZhu(dajuan);
    }




    /**
     * 修改数据
     *
     * @param dajuan 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Dajuan dajuan) {

        return this.dajuanDao.update(dajuan);
    }

}