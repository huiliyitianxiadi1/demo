package com.example.demo.service.impl;

import com.example.demo.entity.BankSubjective;
import com.example.demo.dao.BankSubjectiveDao;
import com.example.demo.entity.R;
import com.example.demo.service.BankSubjectiveService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 主观题(BankSubjective)表服务实现类
 *
 * @author makejava
 * @since 2021-03-09 14:25:47
 */
@Service("bankSubjectiveService")
public class BankSubjectiveServiceImpl implements BankSubjectiveService {
    @Resource
    private BankSubjectiveDao bankSubjectiveDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BankSubjective queryById(Integer id) {
        return this.bankSubjectiveDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<BankSubjective> queryAllByLimit(int offset, int limit) {
        return this.bankSubjectiveDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bankSubjective 实例对象
     * @return 实例对象
     */
    @Override
    public BankSubjective insert(BankSubjective bankSubjective) {
        this.bankSubjectiveDao.insert(bankSubjective);
        return bankSubjective;
    }

    /**
     * 修改数据
     *
     * @param bankSubjective 实例对象
     * @return 实例对象
     */
    @Override
    public BankSubjective update(BankSubjective bankSubjective) {
        this.bankSubjectiveDao.update(bankSubjective);
        return this.queryById(bankSubjective.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bankSubjectiveDao.deleteById(id) > 0;
    }


    //---------------------------------以下为实际代码


    /***
     *
     * @param bankSubjective
     * @return
     */

    @Override
    public R select_all(BankSubjective bankSubjective) {
        Map<String, Object> searchCondition = new HashMap<String, Object>();


        //科目
        if (StringUtils.isNotBlank(bankSubjective.getKemu())) {
            System.out.println(":" + bankSubjective.getKemu());
            searchCondition.put("kemu", bankSubjective.getKemu());
        } else {
            System.out.println("kemu:null:::" + bankSubjective.getKemu());
            searchCondition.put("kemu", null);
        }


        //题目
        if (StringUtils.isNotBlank(bankSubjective.getTimu())) {
            searchCondition.put("timu", bankSubjective.getTimu());
        } else {
            searchCondition.put("timu", null);
        }

//出题老师iD
        searchCondition.put("teacherid", bankSubjective.getTeacherid());


        System.out.println("imp传值1-bankSubjective:" + bankSubjective);

        System.out.println("imp传值2-searchCondition:" + searchCondition);

        List<BankSubjective> list = bankSubjectiveDao.getUserList(new RowBounds(bankSubjective.getOffset(), bankSubjective.getPageSize()), searchCondition);

        int count = bankSubjectiveDao.getUserListCount(new RowBounds(bankSubjective.getOffset(), bankSubjective.getPageSize()), searchCondition);

        R r = new R(bankSubjective.getDraw(), count, count, list);


        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }

}