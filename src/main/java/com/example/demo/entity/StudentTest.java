package com.example.demo.entity;

import com.example.demo.entity.Page;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 考试与学生关系表(StudentTest)实体类
 *
 * @author makejava
 * @since 2021-03-17 15:03:53
 */
@Data
public class StudentTest extends Page {

    private Integer id;
    /**
     * 学生id
     */
    private Integer studentid;
    /**
     * 考试码
     */
    private Integer testid;
    /**
     * 成绩
     */
    private Integer chengji;
    /**
     * 交卷时间
     */
    private Date time;
    /**
     * 是否创建考试表====1为已创建====2为已交卷
     */
    private Integer ny;
    /**
     * 对应test_table 中的id
     */
    private Integer shitiid;

    private String daan;

    private Test test;
    private Teacher teacher;

    private Student student;
}