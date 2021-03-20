package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.dao.TestDao;
import com.example.demo.service.TeacherService;
import com.example.demo.service.TestService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Test)表服务实现类
 *
 * @author makejava
 * @since 2021-03-15 18:30:01
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;
    @Resource
    private TeacherService teacherService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Test queryById(Integer id) {
        return this.testDao.queryById(id);
    }


//======================================================================





    /***
     *分页
     * @param test
     * @return
     */

    @Override
    public R select_all(Test test) {
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


        System.out.println("imp传值1-test:" + test);

        System.out.println("imp传值2-searchCondition:" + searchCondition);

        List<TestTable> list = testDao.getUserList(new RowBounds(test.getOffset(), test.getPageSize()), searchCondition);
        System.out.println("imp1:" + list);

        int count = testDao.getUserListCount(new RowBounds(test.getOffset(), test.getPageSize()), searchCondition);
        System.out.println("count:" + count);

        R r = new R(test.getDraw(), count, count, list);

        System.out.println("r:" + r);
        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }


    /**
     * 新增数据
     *
     * @param test 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Test test) {

        return this.testDao.insert(test);
    }

    /**
     * 修改数据
     *
     * @param test 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Test test) {

        return this.testDao.update(test);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.testDao.deleteById(id) > 0;
    }

}