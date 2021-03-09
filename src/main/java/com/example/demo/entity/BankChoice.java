package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 选择题题库(BankChoice)实体类
 *
 * @author makejava
 * @since 2021-03-09 13:58:29
 */
@Data
public class BankChoice extends Page {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 科目
     */
    private String kemu;
    /**
     * 题目
     */
    private String timu;

    private String a;

    private String b;

    private String c;

    private String d;
    /**
     * 答案
     */
    private String answer;

    /**
     * 出题人id
     */
    private Integer teacherid;

    /**
     * 分值
     */
    private Integer fenzhi;


    /**
     * 引入teacher
     */
    private Teacher teacher;

}