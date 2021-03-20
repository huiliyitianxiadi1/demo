package com.example.demo.controller;


import com.example.demo.entity.Dajuan;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentTest;
import com.example.demo.entity.TestTable;
import com.example.demo.service.DajuanService;
import com.example.demo.service.StudentTestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentTestWeb {

    /**
     * 服务对象
     */
    @Resource
    private DajuanService dajuanService;
    /**
     * 服务对象
     */
    @Resource
    private StudentTestService studentTestService;

    /**
     * 学生进入考试查看界面
     *
     * @return
     */
    @RequestMapping({"/student_select_test.html", "/student_select_test"})
    public String student_select_test() {
        return "student_select_test";
    }


    /**
     * 学生进入个人考试查看列表
     *
     * @return
     */
    @RequestMapping({"/student_myTest.html", "/student_myTest"})
    public String student_myTest(Model m) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Student user = (Student) request.getSession().getAttribute("loginUser");


        List<StudentTest> studenttestList = this.studentTestService.getUserList(user.getStudentId());

        System.out.println("studenttestList:" + studenttestList);

        m.addAttribute("studenttestList", studenttestList);
        return "student_myTest";
    }


    /**
     * 学生进入个人考试查看试卷
     * 可以预览回答试卷
     *
     * @return
     */
    @RequestMapping({"/shijuan.html", "/shijuan"})
    public String shijuan(Model m, Integer textID) {

        System.out.println("shijuan:" + textID);

        Dajuan dajuan = new Dajuan();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Student user = (Student) request.getSession().getAttribute("loginUser");

        dajuan.setKaoshima(textID);


        dajuan.setStudentid(user.getStudentId());


        List<Dajuan> dajuanListDan = this.dajuanService.selectShiJuanDan(dajuan);
        List<Dajuan> dajuanListTian = this.dajuanService.selectShiJuanTian(dajuan);
        List<Dajuan> dajuanListZhu = this.dajuanService.selectShiJuanZhu(dajuan);

        m.addAttribute("dajuanListDan", dajuanListDan);
        m.addAttribute("dajuanListTian", dajuanListTian);
        m.addAttribute("dajuanListZhu", dajuanListZhu);

        return "shijuan";
    }


    /**
     * *填写试卷
     * 保存
     *
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/shijuan/tianxie")
    public int tianxie(Integer st, String daan) {
        int t = 0;
        System.out.println("传入的dajuan表的id:" + st);

        System.out.println("传入的dajuan表的daan:" + daan);


        if (!daan.equals("") && daan != null && !st.equals("") && st != null) {

            Dajuan dajuan = new Dajuan();
            dajuan.setId(st);
            dajuan.setDaan(daan);


            t = this.dajuanService.update(dajuan);
        }
        return t;
    }



    /**
     * *试卷打分
     * 保存
     *
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/shijuan/dafen")
    public int dafen(Integer st, Integer fenzhi) {
        int t = 0;
        System.out.println("传入的dajuan表的id:" + st);
        System.out.println("传入的dajuan表的fenzhi:" + fenzhi);
        Dajuan dajuan = new Dajuan();

        if (!fenzhi.equals("") && fenzhi != null && !st.equals("") && st != null) {


            dajuan.setId(st);
            dajuan.setFenzhi(fenzhi);
            t = this.dajuanService.update(dajuan);
        }else {
            dajuan.setId(st);
            dajuan.setFenzhi(0);
            t = this.dajuanService.update(dajuan);
        }

        return t;
    }
}
