package com.example.demo.controller;

import com.example.demo.entity.Student;

import com.example.demo.entity.User;
import com.example.demo.service.StudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2021-01-25 15:19:23
 */
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;


    //------以下为测试API模块，实际应用不在该java类中

    /***
     *  通过studentEmail和studentPassword查询单条数据
     * @param studentEmail 登录账号
     * @param studentPassword 登录密码
     * @return
     */
    //http://localhost:8080/student/select_one_login?studentEmail=1@qq.com&studentPassword=123456
    @ResponseBody
    @GetMapping("select_one_login")
    public List<Student> select_one_login(@Param("studentEmail") String studentEmail,
                                          @Param("studentPassword") String studentPassword) {
        System.out.println(studentEmail);
        System.out.println(studentPassword);
        List<Student> student = this.studentService.select_one_login(studentEmail, studentPassword);
        if (student.size() == 1) {
            System.out.println(student.get(0));
        }
        return student;
    }


    /***API
     * 学生注册测试模块
     * http://localhost:8080/student/register_student?studentEmail=1@qq.com&studentPassword=123456
     * @param student
     * @return
     */
    @ResponseBody
    @GetMapping("register_student")
    public String register_student(Student student) {

        Student old_student = this.studentService.student_queryByEmail(student.getStudentEmail());

        System.out.println("old_student:" + student.getStudentEmail() + "/" + old_student);

        if (old_student == null) {

            System.out.println("用户不存在，执行添加用户");
            int tag = studentService.register_student(student);
            System.out.println("register_student.tag:" + tag);
            if (tag != 1) {
                //"账号已存在" 2002
                return "2002";
            } else {
                //数据库插入数据成功
                return "2000";
            }
        } else {
            System.out.println("用户存在");
            //"账号已存在" 2002
            return "2002";
        }

    }


    /***API
     * 通过studentEmail修改数据
     * @param
     * @return
     *
     * http://localhost:8080/student/student_update?studentEmail=1@qq.com&studentPassword=123456
     * http://localhost:8080/student/student_update?studentEmail=1@qq.com&studentSex=男&studentName=a&studentPassword=1&studentNumber=aa&studentSchool=aa&studentPhone=111
     */

    @ResponseBody
    @PostMapping("student_update")
    public int student_update(Student student){

        //获得电子邮箱 StudentEmail
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute("shenfen");

        student.setStudentEmail(user.getEmail());


        System.out.println(student);




        return this.studentService.update(student);

    }




    /***API
     * 通过studentEmail查询单条数据
     * @param studentEmail
     * @return
     *
     * http://localhost:8080/student/student_queryByEmail?studentEmail=1@qq.com
     */
    @ResponseBody
    @GetMapping("student_queryByEmail")
    public Student student_queryByEmail(String studentEmail) {
        System.out.println(studentEmail);
        return this.studentService.student_queryByEmail(studentEmail);
    }



    //-----------------------------------------------分界线

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Student selectOne(Integer id) {
        System.out.println(id);
        return this.studentService.queryById(id);
    }

}