package com.example.demo.service.impl;


import com.example.demo.entity.BankFill;
import com.example.demo.dao.BankFillDao;
import com.example.demo.entity.R;
import com.example.demo.service.BankFillService;
import com.example.demo.dao.BankFillDao;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BankFill> queryAllByLimit(int offset, int limit) {
        return this.bankFillDao.queryAllByLimit(offset, limit);
    }

    //---------------------------------以下为实际代码


    /***
     *
     * @param bankFill
     * @return
     */

    @Override
    public R select_all(BankFill bankFill) {
        Map<String, Object> searchCondition = new HashMap<String, Object>();


        //科目
        if (StringUtils.isNotBlank(bankFill.getKemu())) {
            System.out.println(":" + bankFill.getKemu());
            searchCondition.put("kemu", bankFill.getKemu());
        } else {
            System.out.println("kemu:null:::" + bankFill.getKemu());
            searchCondition.put("kemu", null);
        }


        //题目
        if (StringUtils.isNotBlank(bankFill.getTimu())) {
            searchCondition.put("timu", bankFill.getTimu());
        } else {
            searchCondition.put("timu", null);
        }

        //出题老师iD
        searchCondition.put("teacherid", bankFill.getTeacherid());

        //考试ID

        searchCondition.put("textId", bankFill.getTextId());


        System.out.println("imp传值1-bankFill:" + bankFill);

        System.out.println("imp传值2-searchCondition:" + searchCondition);

        R r = new R();
        int count = 0;
        List<BankFill> list = null;


        //查询非考试添加题库
        if (bankFill.getTextId() == null) {
            System.out.println("此处为getUserList==null");
            list = bankFillDao.getUserList(new RowBounds(bankFill.getOffset(), bankFill.getPageSize()), searchCondition);
            count = bankFillDao.getUserListCount(new RowBounds(bankFill.getOffset(), bankFill.getPageSize()), searchCondition);

            r = new R(bankFill.getDraw(), count, count, list);

        }

        /*
*        根据试卷查询
       找不包含在试卷中的题*/
        else {
            if (bankFill.getLr() == 1) {
                System.out.println("此处为getUserListB ！=null+LR=1");
                list = bankFillDao.getUserListC(new RowBounds(bankFill.getOffset(), bankFill.getPageSize()), searchCondition);
                count = bankFillDao.getUserListCountC(new RowBounds(bankFill.getOffset(), bankFill.getPageSize()), searchCondition);
                r = new R(bankFill.getDraw(), count, count, list);

            } else if (bankFill.getLr() == 2) {

                System.out.println("此处为getUserListB ！=null+LR=2");
                list = bankFillDao.getUserListB(new RowBounds(bankFill.getOffset(), bankFill.getPageSize()), searchCondition);
                count = bankFillDao.getUserListCountB(new RowBounds(bankFill.getOffset(), bankFill.getPageSize()), searchCondition);
                r = new R(bankFill.getDraw(), count, count, list);

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
     * @param bankFill 实例对象
     * @return 实例对象
     */
    @Override
    public boolean insert(BankFill bankFill) {

        return this.bankFillDao.insert(bankFill);
    }

    /**
     * 修改数据
     *
     * @param bankFill 实例对象
     * @return 实例对象
     */
    @Override
    public int update(BankFill bankFill) {

        return this.bankFillDao.update(bankFill);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer id) {
        return this.bankFillDao.deleteById(id);
    }


}