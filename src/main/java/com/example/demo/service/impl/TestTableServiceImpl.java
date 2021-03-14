package com.example.demo.service.impl;

import com.example.demo.entity.BankChoice;
import com.example.demo.entity.R;
import com.example.demo.entity.TestTable;
import com.example.demo.dao.TestTableDao;
import com.example.demo.service.TestTableService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (TestTable)表服务实现类
 *
 * @author makejava
 * @since 2021-03-12 14:43:03
 */
@Service("testTableService")
public class TestTableServiceImpl implements TestTableService {
    @Resource
    private TestTableDao testTableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestTable queryById(Integer id) {
        return this.testTableDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TestTable> queryAllByLimit(int offset, int limit) {
        return this.testTableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    @Override
    public TestTable insert(TestTable testTable) {
        this.testTableDao.insert(testTable);
        return testTable;
    }

    /**
     * 修改数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    @Override
    public TestTable update(TestTable testTable) {
        this.testTableDao.update(testTable);
        return this.queryById(testTable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.testTableDao.deleteById(id) > 0;
    }

    //    有效代码

    /**
     * 根据id查询
     *
     * @param testid
     * @return
     */
    @Override
    public List<TestTable> selectByTestId(Integer testid) {
        return this.testTableDao.selectByTestId(testid);
    }

    /***
     *分页
     * @param testTable
     * @return
     */

    @Override
    public R select_all(TestTable testTable) {
        Map<String, Object> searchCondition = new HashMap<String, Object>();



/*
        //题目
        if (StringUtils.isNotBlank(testTable.getTimu())) {
            searchCondition.put("timu", bankChoice.getTimu());
        } else {
            searchCondition.put("timu", null);
        }
*/

        //begin
        searchCondition.put("begin", null);
        //end
        searchCondition.put("end", null);
        //出题老师iD
        searchCondition.put("testid", null);


        System.out.println("imp传值1-bankChoice:" + testTable);

        System.out.println("imp传值2-searchCondition:" + searchCondition);

        List<TestTable> list = testTableDao.getUserList(new RowBounds(testTable.getOffset(), testTable.getPageSize()), searchCondition);
        System.out.println("imp1:" + list);

        int count = testTableDao.getUserListCount(new RowBounds(testTable.getOffset(), testTable.getPageSize()), searchCondition);
        System.out.println("count:" + count);

        R r = new R(testTable.getDraw(), count, count, list);

        System.out.println("r:" + r);
        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }

}