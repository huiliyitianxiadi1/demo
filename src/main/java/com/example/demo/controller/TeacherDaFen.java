package com.example.demo.controller;

import com.example.demo.entity.Dajuan;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentTest;
import com.example.demo.entity.Test;
import com.example.demo.service.DajuanService;
import com.example.demo.service.StudentTestService;
import com.example.demo.service.TeacherService;
import com.example.demo.service.TestService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherDaFen {


    @Resource
    private TestService testService;
    @Resource
    private DajuanService dajuanService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private StudentTestService studentTestService;


    /**
     * 教师查询回答自己试卷的学生试卷Html
     *
     * @return
     */
    @RequestMapping({"/Teacher_Select_Student_Test.html", "/Teacher_Select_Student_Test"})
    public String Teacher_Select_Student_Test_Html(Model model) {


        List<Test> list = this.studentTestService.TeacherSelectStudentTest();

        System.out.println("Teacher_Select_Student_Test_Html:" + list);

        model.addAttribute("lists", list);

        return "Teacher_Select_Student_Test";
    }
    /**
     * 局部刷新，注意返回值
     * @param model
     * @return
     */
    @RequestMapping("/local")
    public String localRefresh(Model model) {
        List<Test> list = this.studentTestService.TeacherSelectStudentTest();

        System.out.println("Teacher_Select_Student_Test_Html/local:" + list);

        model.addAttribute("lists", list);

        // "test"是test.html的名，
        // "table_refresh"是test.html中需要刷新的部分标志,
        // 在标签里加入：th:fragment="table_refresh"
        return "Teacher_Select_Student_Test::table_refresh";
    }

    //http://localhost:8080/student/select_one_login?studentEmail=1@qq.com&studentPassword=123456


    @PostMapping("xxxx")
    public List<Test> xxxx(ModelMap modelMap) {


        return this.studentTestService.TeacherSelectStudentTest();
    }


    /**
     * 教师进入回答自己试卷的学生试卷Html
     * 可以预览回答试卷
     *
     * @return
     */
    @RequestMapping({"/shijuanTeacher.html", "/shijuanTeacher"})
    public String shijuanTeacher(Model m, Integer textID, Integer StudentID) {

        System.out.println("shijuan/textID:" + textID);
        System.out.println("shijuan/StudentID:" + StudentID);

        Dajuan dajuan = new Dajuan();


        dajuan.setKaoshima(textID);
        dajuan.setStudentid(StudentID);

        System.out.println("shijuanTeacher/shijuan:" + dajuan);

        List<Dajuan> dajuanListDan = this.dajuanService.selectShiJuanDan(dajuan);
        List<Dajuan> dajuanListTian = this.dajuanService.selectShiJuanTian(dajuan);
        List<Dajuan> dajuanListZhu = this.dajuanService.selectShiJuanZhu(dajuan);

        m.addAttribute("TdajuanListDan", dajuanListDan);
        m.addAttribute("TdajuanListTian", dajuanListTian);
        m.addAttribute("TdajuanListZhu", dajuanListZhu);

        return "shijuanTeacher";
    }


}
