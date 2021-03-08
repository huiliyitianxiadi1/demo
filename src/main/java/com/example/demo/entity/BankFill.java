package com.example.demo.entity;

import java.io.Serializable;

/**
 * 提空题题库(BankFill)实体类
 *
 * @author makejava
 * @since 2021-03-09 13:58:29
 */
public class BankFill implements Serializable {
    private static final long serialVersionUID = -96011807396305960L;
    
    private Integer id;
    /**
    * 科目
    */
    private String subject;
    /**
    * 题目
    */
    private String title;
    /**
    * 答案1
    */
    private String answer1;
    /**
    * 答案2
    */
    private String answer2;
    /**
    * 答案3
    */
    private String answer3;


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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

}