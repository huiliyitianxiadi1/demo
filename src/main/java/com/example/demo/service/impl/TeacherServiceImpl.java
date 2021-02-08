package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.dao.TeacherDao;
import com.example.demo.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public Teacher update(Teacher teacher) {
        this.teacherDao.update(teacher);
        return this.queryById(teacher.getTeacherId());
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
}