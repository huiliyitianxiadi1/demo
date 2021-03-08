package com.example.demo.service.impl;



import com.example.demo.entity.BankChoice;
import com.example.demo.dao.BankChoiceDao;
import com.example.demo.service.BankChoiceService;
import com.example.demo.dao.BankChoiceDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 选择题题库(BankChoice)表服务实现类
 *
 * @author makejava
 * @since 2021-03-09 14:25:50
 */
@Service("bankChoiceService")
public class BankChoiceServiceImpl implements BankChoiceService {
    @Resource
    private BankChoiceDao bankChoiceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BankChoice queryById(Integer id) {
        return this.bankChoiceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BankChoice> queryAllByLimit(int offset, int limit) {
        return this.bankChoiceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bankChoice 实例对象
     * @return 实例对象
     */
    @Override
    public BankChoice insert(BankChoice bankChoice) {
        this.bankChoiceDao.insert(bankChoice);
        return bankChoice;
    }

    /**
     * 修改数据
     *
     * @param bankChoice 实例对象
     * @return 实例对象
     */
    @Override
    public BankChoice update(BankChoice bankChoice) {
        this.bankChoiceDao.update(bankChoice);
        return this.queryById(bankChoice.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bankChoiceDao.deleteById(id) > 0;
    }
}