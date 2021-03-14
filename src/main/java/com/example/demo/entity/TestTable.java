package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (TestTable)实体类
 * <p>
 * 试卷
 *
 * @author makejava
 * @since 2021-03-12 14:38:44
 */
@Data
public class TestTable extends Page {

    private Integer id;
    /**
     * 考试id
     */
    private Integer testId;
    /**
     * 出卷人id
     */

    private String name;

    private Integer teacherid;
    /**
     * 开始时间
     */
    private Date begin;
    /**
     * 结束时间
     */
    private Date end;
    /**
     * 题型
     * 1：单选
     * 2：填空
     * 3：主官
     */
    private Integer type;
    /**
     * 题id
     */
    private Integer danId;

    private Integer tianId;

    private Integer zhuId;

    private Teacher teacher;

    private BankChoice bankChoice;
    private BankFill bankFill;
    private BankSubjective bankSubjective;

    /**
     * 权限
     */

    private Integer quanxian;
}