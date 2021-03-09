package com.example.demo.service.impl;

import com.example.demo.entity.R;

import com.example.demo.entity.Teacher;
import com.example.demo.dao.TeacherDao;
import com.example.demo.service.TeacherService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2021-01-25 17:15:45
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;


    //-----------------------------------------------增-----------------------------------------------

    /**
     * 注册功能
     *
     * @param teacher 添加的教师信息
     * @return
     */
    @Override
    public int register_teacher(Teacher teacher) {
        return this.teacherDao.register_teacher(teacher);
    }

    //-----------------------------------------------查-----------------------------------------------

    /**
     * 通过teacherEmail和teacherPassword查询单条数据
     *
     * @param teacherEmail    登录账号
     * @param teacherPassword 登录密码
     * @return
     */
    @Override
    public List<Teacher> select_teacher_login(String teacherEmail, String teacherPassword) {
        return this.teacherDao.select_teacher_login(teacherEmail, teacherPassword);
    }


    /***
     * 通过teacherEmail查询单条数据
     * @param teacherEmail 教师电子邮箱
     * @return 实例对象
     */
    @Override
    public Teacher teacher_queryByEmail(String teacherEmail) {
        return this.teacherDao.teacher_queryByEmail(teacherEmail);
    }
    //-------------------------------分割线---------------------------//


    /**
     * 通过ID查询单条数据
     *
     * @param teacherId 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Integer teacherId) {
        return this.teacherDao.queryById(teacherId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Teacher> queryAllByLimit(int offset, int limit) {
        return this.teacherDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher teacher) {
        this.teacherDao.insert(teacher);
        return teacher;
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Teacher teacher) {

        return this.teacherDao.update(teacher);
    }

    /**
     * 通过主键删除数据
     *
     * @param teacherId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer teacherId) {
        return this.teacherDao.deleteById(teacherId) > 0;
    }


    //-------------------------------测试部分begin---------------------------//


    @Override
    public R getPageUserList(Teacher teacher) {
        //查询条件
        Map<String, Object> searchCondition = new HashMap<String, Object>();



        //名字
        if (StringUtils.isNotBlank(teacher.getTeacherName())) {
            searchCondition.put("teacherName", teacher.getTeacherName());
        } else {
            searchCondition.put("teacherName", null);
        }

        //电子邮箱
        if (StringUtils.isNotBlank(teacher.getTeacherEmail())) {
            searchCondition.put("teacherEmail", teacher.getTeacherEmail());
        } else {
            searchCondition.put("tudentEmail", null);
        }

        //密码
        if (StringUtils.isNotBlank(teacher.getTeacherPassword())) {
            searchCondition.put("teacherPassword", teacher.getTeacherPassword());
        } else {
            searchCondition.put("teacherPassword", null);
        }


        //学号
        if (StringUtils.isNotBlank(teacher.getTeacherNumber())) {
            searchCondition.put("teacherNumber", teacher.getTeacherNumber());
        } else {
            searchCondition.put("teacherNumber", null);
        }

        //性别
        if (StringUtils.isNotBlank(teacher.getTeacherSex())) {
            searchCondition.put("teacherSex", teacher.getTeacherSex());
        } else {
            searchCondition.put("teacherSex", null);
        }




        //当前学校
        if (StringUtils.isNotBlank(teacher.getSchool())) {
            System.out.println("测试1:" + teacher.getSchool());
            searchCondition.put("school", teacher.getSchool());
        } else {
            searchCondition.put("school", null);
        }

        //教授科目
        if (StringUtils.isNotBlank(teacher.getSubject())) {
            System.out.println("测试2:" + teacher.getSubject());
            searchCondition.put("subject", teacher.getSubject());
        } else {
            searchCondition.put("subject", null);
        }






        //当前职称
        if (StringUtils.isNotBlank(teacher.getTitle())) {
            searchCondition.put("title", teacher.getTitle());
        } else {
            searchCondition.put("title", null);
        }


        //当前教师身份状态
        if (StringUtils.isNotBlank(teacher.getTeacherStatus())) {
            searchCondition.put("teacherStatus", teacher.getTeacherStatus());
        } else {
            searchCondition.put("teacherStatus", null);
        }


        List<Teacher> list = teacherDao.getUserList(new RowBounds(teacher.getOffset(), teacher.getPageSize()), searchCondition);
        int count = teacherDao.getUserListCount(new RowBounds(teacher.getOffset(), teacher.getPageSize()), searchCondition);

        R r = new R(teacher.getDraw(), count, count, list);

        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }


    //-------------------------------测试部分end---------------------------//


}