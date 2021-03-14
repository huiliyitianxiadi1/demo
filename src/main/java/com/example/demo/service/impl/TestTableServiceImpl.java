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

    //    测试代码

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

//  ------------------------------------------------------------------------  有效代码    -----------------------------------------------------------------------

    /**
     * 新增数据
     *
     * @param testTable 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(TestTable testTable) {

        return this.testTableDao.insert(testTable);
    }


    /**
     * 根据传入类移除试卷
     *
     * @param testTable 传入类
     * @return 影响行数
     */
    @Override
    public boolean deleteById(TestTable testTable) {
        return this.testTableDao.deleteById(testTable) > 0;
    }


}