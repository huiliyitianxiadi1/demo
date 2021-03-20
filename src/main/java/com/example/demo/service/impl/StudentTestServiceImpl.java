package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.dao.StudentTestDao;

import com.example.demo.service.StudentTestService;
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
 * 考试与学生关系表(StudentTest)表服务实现类
 *
 * @author makejava
 * @since 2021-03-17 01:53:49
 */
@Service("studentTestService")
public class StudentTestServiceImpl implements StudentTestService {
    @Resource
    private StudentTestDao studentTestDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public StudentTest queryById(Integer id) {
        return this.studentTestDao.queryById(id);
    }


    /**
     * 修改数据
     *
     * @param studentTest 实例对象
     * @return 实例对象
     */
    @Override
    public StudentTest update(StudentTest studentTest) {
        this.studentTestDao.update(studentTest);
        return this.queryById(studentTest.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.studentTestDao.deleteById(id) > 0;
    }


    //=====================================有效代码==========================

    @Override
    public List<Test> TeacherSelectStudentTest(){

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Teacher teacher = (Teacher) request.getSession().getAttribute("loginUser");


        return this.studentTestDao.TeacherSelectStudentTest(teacher.getTeacherId());
    }



    /**
     * 获得所有该用户数据
     *
     * @return
     */
    @Override
    public List<StudentTest> getUserList(Integer studentid) {
        return this.studentTestDao.getUserList(studentid);
    }

    /**
     * 新增数据
     *
     * @param studentTest 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(StudentTest studentTest) {

        return this.studentTestDao.insert(studentTest);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param studentTest 实例对象
     * @return 对象列表
     */
    @Override
    public List<StudentTest> queryAll(StudentTest studentTest) {
        return this.studentTestDao.queryAll(studentTest);
    }


}