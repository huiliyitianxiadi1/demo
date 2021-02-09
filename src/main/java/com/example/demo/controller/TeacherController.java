package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.service.TeacherService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * (Teacher)表控制层
 *
 * @author makejava
 * @since 2021-01-25 17:15:45
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;


    //------以下为测试API模块，实际应用不在该java类中


    /***
     * 根据邮箱和密码查询
     * @param teacherEmail
     * @param teacherPassword
     * @return
     *   http://localhost:8080/teacher/select_teacher_login?teacherEmail=21@qq.com&teacherPassword=123456
     */

    @ResponseBody
    @GetMapping("select_teacher_login")
    public List<Teacher> select_teacher_login(@Param("teacherEmail") String teacherEmail,
                                              @Param("teacherPassword") String teacherPassword) {
        System.out.println(teacherEmail);
        System.out.println(teacherPassword);
        List<Teacher> teacher = this.teacherService.select_teacher_login(teacherEmail, teacherPassword);
        if (teacher.size() == 1) {
            System.out.println(teacher.get(0));
        }
        return teacher;
    }

    /***API
     * 用户注册测试模块
     * @param teacher
     * @param map
     * @return
     * http://localhost:8080/teacher/register_teacher?teacherEmail=21@qq.com&teacherPassword=123456
     */

    @ResponseBody
    @GetMapping("register_teacher")
    public String register_teacher(Teacher teacher, Map<String, Object> map) {

        Teacher old_teacher = this.teacherService.teacher_queryByEmail(teacher.getTeacherEmail());

        System.out.println("old_teacher:" + teacher.getTeacherEmail() + "/" + old_teacher);
        if (old_teacher == null) {
            System.out.println("用户不存在，执行添加用户");
            //不为空
            //执行添加操作
            int tag = teacherService.register_teacher(teacher);
            System.out.println("register_teacher.tag:" + tag);
            if (tag != 1) {
                //"账号已存在"
                return "2002";
            } else {
                //数据库插入数据成功
                return "2000";
            }
        } else {
            System.out.println("用户存在");
            //"账号已存在"
            return "2002";
        }
    }


    /***API
     * 通过teacherEmail查询单条数据
     * @param teacherEmail
     * @return
     * http://localhost:8080/teacher/teacher_queryByEmail?&teacherEmail=21@qq.com
     */
    @GetMapping("teacher_queryByEmail")
    public Teacher teacher_queryByEmail(String teacherEmail) {
        System.out.println(teacherEmail);
        return this.teacherService.teacher_queryByEmail(teacherEmail);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     * http://localhost:8080/teacher/selectOne?&id=1
     */
    @GetMapping("selectOne")
    public Teacher selectOne(Integer id) {
        return this.teacherService.queryById(id);
    }






    /**
     * 教师-检查旧密码模块
     *可优化（懒得改）
     * @param oldPassword
     * @return
     */
    @ResponseBody
    @PostMapping("check_teacher_old_password")
    public String check_teacher_old_password(String oldPassword) {


        System.out.println("-----check_teacher_old_password模块begin-----");

        //刷新
        //获得当前Session的账号密码
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        System.out.println(user.getEmail());
        System.out.println(user.getPassword());

        //根据Session的账号和密码获得学生所有信息
        List<Teacher> teacher = this.teacherService.select_teacher_login(user.getEmail(), user.getPassword());
        System.out.println(teacher.get(0));

        System.out.println("-----check_teacher_old_password模块end-----");
        //检查获取的密码是否与旧密码相同
        //不相同，返回0
        //相同，返回1
        if (teacher.get(0).getTeacherPassword().equals(oldPassword)) {
            return "1";
        } else {
            return "0";
        }


    }







    /***API
     * 通过teacherEmail修改数据
     * @param
     * @return
     *
     * http://localhost:8080/teacher/teacher_update?teacherEmail=1@qq.com&teacherPassword=123456
     * http://localhost:8080/teacher/teacher_update?teacherEmail=1@qq.com&teacherSex=男&teacherName=a&teacherPassword=1&teacherNumber=aa&teacherSchool=aa&teacherPhone=111
     */

    @ResponseBody
    @PostMapping("teacher_update")
    public int teacher_update(Teacher teacher) {

        //获得电子邮箱 teacherEmail
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        teacher.setTeacherEmail(user.getEmail());


        System.out.println("teacher_update测试点:"+teacher);


        return this.teacherService.update(teacher);

    }







}