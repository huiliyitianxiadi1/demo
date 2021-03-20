package com.example.demo.service.impl;


import com.example.demo.entity.BankChoice;
import com.example.demo.dao.BankChoiceDao;
import com.example.demo.entity.R;
import com.example.demo.entity.Student;
import com.example.demo.service.BankChoiceService;
import com.example.demo.dao.BankChoiceDao;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
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


    //---------------------------------以下为实际代码


    /***
     *
     * @param bankChoice
     * @return
     */

    @Override
    public R select_all(BankChoice bankChoice) {
        Map<String, Object> searchCondition = new HashMap<String, Object>();



        //题目
        if (StringUtils.isNotBlank(bankChoice.getTimu())) {
            searchCondition.put("timu", bankChoice.getTimu());
        } else {
            searchCondition.put("timu", null);
        }

        //--科目
        if (StringUtils.isNotBlank(bankChoice.getKemu())) {
            System.out.println(":" + bankChoice.getKemu());
            searchCondition.put("kemu", bankChoice.getKemu());
        } else {
            System.out.println("kemu:null:::" + bankChoice.getKemu());
            searchCondition.put("kemu", null);
        }


        //出题老师iD
        searchCondition.put("teacherid", bankChoice.getTeacherid());

        //考试ID

        searchCondition.put("textId", bankChoice.getTextId());


        System.out.println("imp传值1-bankChoice:" + bankChoice);

        System.out.println("imp传值2-searchCondition:" + searchCondition);

        R r = new R();
        int count = 0;
        List<BankChoice> list = null;


        //查询非考试添加题库
        if (bankChoice.getTextId() == null) {
            System.out.println("此处为getUserList==null");
            list = bankChoiceDao.getUserList(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);
            count = bankChoiceDao.getUserListCount(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);

            r = new R(bankChoice.getDraw(), count, count, list);

        }

        /*
*        根据试卷查询
       找不包含在试卷中的题*/
        else {
            if (bankChoice.getLr() == 1) {
                System.out.println("此处为getUserListB ！=null+LR=1");
                list = bankChoiceDao.getUserListC(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);
                count = bankChoiceDao.getUserListCountC(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);
                r = new R(bankChoice.getDraw(), count, count, list);

            } else if (bankChoice.getLr() == 2) {

                System.out.println("此处为getUserListB ！=null+LR=2");
                list = bankChoiceDao.getUserListB(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);
                count = bankChoiceDao.getUserListCountB(new RowBounds(bankChoice.getOffset(), bankChoice.getPageSize()), searchCondition);
                r = new R(bankChoice.getDraw(), count, count, list);

            }
        }

        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }


    /**
     * 新增数据
     *
     * @param bankChoice 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(BankChoice bankChoice) {

        return this.bankChoiceDao.insert(bankChoice);
    }


    /**
     * 修改数据
     *
     * @param bankChoice 实例对象
     * @return 实例对象
     */
    @Override
    public int update(BankChoice bankChoice) {

        return this.bankChoiceDao.update(bankChoice);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.bankChoiceDao.deleteById(id);
    }


}