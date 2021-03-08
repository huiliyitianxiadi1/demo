package com.example.demo.entity;

import lombok.Data;


/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2021-01-25 15:06:18
 */
@Data
public class Teacher  extends Page{


    private Integer teacherId;
    /**
     * 教师名
     */
    private String teacherName;
    /**
     * 教师电子邮箱
     */
    private String teacherEmail;
    /**
     * 教师密码
     */
    private String teacherPassword;
    /**
     * 教师工号
     */
    private String teacherNumber;
    /**
     * 教师性别
     */
    private String teacherSex;
    /**
     * 在职学校
     */
    private String school;
    /**
     * 教授科目
     */
    private String subject;
    /**
     * 职称
     */
    private String title;
    /**
     * 教师身份状态，1为已确认，2为待确认，3为未确认
     */
    private String teacherStatus;


    private byte[]  photo;
}