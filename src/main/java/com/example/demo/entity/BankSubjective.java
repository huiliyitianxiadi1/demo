package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 主观题(BankSubjective)实体类
 *
 * @author makejava
 * @since 2021-03-09 13:58:27
 */
@Data
public class BankSubjective extends Page {

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
     * 参考答案
     */
    private String referenceanswer;


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
    /**
     * 权限
     */

    private Integer quanxian;

    /**
     * 考试编号ID
     */
    private Integer textId;



    /**
     * 判断左右
     * 1左
     * 2右
     */
    private  Integer lr;
}