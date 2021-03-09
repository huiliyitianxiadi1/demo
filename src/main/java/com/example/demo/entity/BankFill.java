package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 提空题题库(BankFill)实体类
 *
 * @author makejava
 * @since 2021-03-09 13:58:29
 */
@Data
public class BankFill extends Page {

    private Integer id;
    /**
     * 科目
     */
    private String kemu;
    /**
     * 题目
     */
    private String timu;
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