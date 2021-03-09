package com.example.demo.service.impl;


import com.example.demo.entity.BankChoice;
import com.example.demo.dao.BankChoiceDao;
import com.example.demo.entity.R;
import com.example.demo.entity.Student;
import com.example.demo.service.BankChoiceService;
import com.example.demo.dao.BankChoiceDao;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param limit  查询条数
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


    //---------------------------------以下为实际代码


    /***
     *
     * @param bankChoice
     * @return
     */

    @Override
    public R select_all(BankChoice bankChoice) {
        Map<String, Object> searchCondition = new HashMap<String, Object>();


        //科目
        if (StringUtils.isNotBlank(bankChoice.getKemu())) {
            System.out.println(":" + bankChoice.getKemu());
            searchCondition.put("kemu", bankChoice.getKemu());
        } else {
            System.out.println("kemu:null:::" + bankChoice.getKemu());
            searchCondition.put("kemu", null);
        }


        //题目
        if (StringUtils.isNotBlank(bankChoice.getTimu())) {
            searchCondition.put("timu", bankChoice.getTimu());
        } else {
            searchCondition.put("timu", null);
        }

//出题老师iD
        searchCondition.put("teacherid", bankChoice.getTeacherid());


        System.out.println("imp传值1-bankChoice:" + bankChoice);

        System.out.println("imp传值2-searchCondition:" + searchCondition);

        List<BankChoice> list = bankChoiceDao.getUserList(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);
        int count = bankChoiceDao.getUserListCount(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);

        R r = new R(bankChoice.getDraw(), count, count, list);


        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }

}