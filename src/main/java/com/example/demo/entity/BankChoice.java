package com.example.demo.entity;

import java.io.Serializable;

/**
 * 选择题题库(BankChoice)实体类
 *
 * @author makejava
 * @since 2021-03-09 13:58:29
 */
public class BankChoice implements Serializable {
    private static final long serialVersionUID = 291082332449883097L;
    /**
    * 编号
    */
    private Integer id;
    /**
    * 科目
    */
    private String subject;
    /**
    * 题目
    */
    private String title;
    
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    /**
    * 答案
    */
    private String answer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}