package com.example.demo.service.impl;

import com.example.demo.entity.R;
import com.example.demo.entity.Student;
import com.example.demo.dao.StudentDao;
import com.example.demo.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2021-01-25 15:19:22
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;


    //-----------------------------------------------增-----------------------------------------------

    /**
     * 注册功能
     *
     * @param student 添加的学生信息
     * @return
     */
    @Override
    public int register_student(Student student) {
        return this.studentDao.register_student(student);
    }


    //----------------------------------------------改------------------------------------------------

    /**
     * 修改数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Student student) {

        return this.studentDao.update(student);
    }


    //-----------------------------------------------查-----------------------------------------------

    /**
     * 通过Istudentd和studentPassword查询单条数据
     *
     * @param studentEmail    登录账号
     * @param studentPassword 登录密码
     * @return
     */
    @Override
    public List<Student> select_one_login(String studentEmail, String studentPassword) {
        return this.studentDao.select_one_login(studentEmail, studentPassword);
    }

    /**
     * 根据studentEmail来查找用户
     *
     * @param studentEmail
     * @return
     */
    @Override
    public Student student_queryByEmail(String studentEmail) {
        return this.studentDao.student_queryByEmail(studentEmail);
    }


    /**
     * 无条件查询全部
     */
    @Override
    public List<Student> queryAll_student() {
        return this.studentDao.selectALL();
    }


    //-------------------------------测试部分begin---------------------------//


    @Override
    public R getPageUserList(Student student) {
        //查询条件
        Map<String, Object> searchCondition = new HashMap<String, Object>();



        //名字
        if (StringUtils.isNotBlank(student.getStudentName())) {
            searchCondition.put("studentName", student.getStudentName());
        } else {
            searchCondition.put("studentName", null);
        }

        //电子邮箱
        if (StringUtils.isNotBlank(student.getStudentEmail())) {
            searchCondition.put("studentEmail", student.getStudentEmail());
        } else {
            searchCondition.put("tudentEmail", null);
        }

        //密码
        if (StringUtils.isNotBlank(student.getStudentPassword())) {
            searchCondition.put("studentPassword", student.getStudentPassword());
        } else {
            searchCondition.put("studentPassword", null);
        }


        //学号
        if (StringUtils.isNotBlank(student.getStudentNumber())) {
            searchCondition.put("studentNumber", student.getStudentNumber());
        } else {
            searchCondition.put("studentNumber", null);
        }

        //性别
        if (StringUtils.isNotBlank(student.getStudentSex())) {
            searchCondition.put("studentSex", student.getStudentSex());
        } else {
            searchCondition.put("studentSex", null);
        }

        //当前学校
        if (StringUtils.isNotBlank(student.getStudentSchool())) {
            searchCondition.put("studentSchool", student.getStudentSchool());
        } else {
            searchCondition.put("studentSchool", null);
        }


        //当前手机号
        if (StringUtils.isNotBlank(student.getStudentPhone())) {
            searchCondition.put("studentPhone", student.getStudentPhone());
        } else {
            searchCondition.put("studentPhone", null);
        }

        //当前学生身份状态
        if (StringUtils.isNotBlank(student.getStudentStatus())) {
            searchCondition.put("studentStatus", student.getStudentStatus());
        } else {
            searchCondition.put("studentStatus", null);
        }


        List<Student> list = studentDao.getUserList(new RowBounds(student.getOffset(), student.getPageSize()), searchCondition);
        int count = studentDao.getUserListCount(new RowBounds(student.getOffset(), student.getPageSize()), searchCondition);

        R r = new R(student.getDraw(), count, count, list);

        System.out.println("list:" + list);
        System.out.println("count:" + count);
        System.out.println("R:" + r);
        return r;
    }


    //-------------------------------测试部分end---------------------------//


    //-------------------------------分割线---------------------------//

    /**
     * 通过ID查询单条数据
     *
     * @param studentId 主键
     * @return 实例对象
     */
    @Override
    public Student queryById(Integer studentId) {
        return this.studentDao.queryById(studentId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Student> queryAllByLimit(int offset, int limit) {
        return this.studentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }


    /**
     * 通过主键删除数据
     *
     * @param studentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer studentId) {
        return this.studentDao.deleteById(studentId) > 0;
    }
}