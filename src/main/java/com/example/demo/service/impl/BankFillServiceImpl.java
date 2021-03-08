package com.example.demo.service.impl;



import com.example.demo.entity.BankFill;
import com.example.demo.dao.BankFillDao;
import com.example.demo.service.BankFillService;
import com.example.demo.dao.BankFillDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 提空题题库(BankFill)表服务实现类
 *
 * @author makejava
 * @since 2021-03-09 14:25:50
 */
@Service("bankFillService")
public class BankFillServiceImpl implements BankFillService {
    @Resource
    private BankFillDao bankFillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BankFill queryById(Integer id) {
        return this.bankFillDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BankFill> queryAllByLimit(int offset, int limit) {
        return this.bankFillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bankFill 实例对象
     * @return 实例对象
     */
    @Override
    public BankFill insert(BankFill bankFill) {
        this.bankFillDao.insert(bankFill);
        return bankFill;
    }

    /**
     * 修改数据
     *
     * @param bankFill 实例对象
     * @return 实例对象
     */
    @Override
    public BankFill update(BankFill bankFill) {
        this.bankFillDao.update(bankFill);
        return this.queryById(bankFill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bankFillDao.deleteById(id) > 0;
    }
}