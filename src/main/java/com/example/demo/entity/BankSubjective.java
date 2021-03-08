package com.example.demo.entity;

import java.io.Serializable;

/**
 * 主观题(BankSubjective)实体类
 *
 * @author makejava
 * @since 2021-03-09 13:58:27
 */
public class BankSubjective implements Serializable {
    private static final long serialVersionUID = -40900032507577794L;
    
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
    * 参考答案
    */
    private String referenceanswer;


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

    public String getReferenceanswer() {
        return referenceanswer;
    }

    public void setReferenceanswer(String referenceanswer) {
        this.referenceanswer = referenceanswer;
    }

}