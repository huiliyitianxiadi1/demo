package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2021-01-27 18:48:52
 */
@Data
public class Student {

    /**
     * 学生-id编号
     */
    private Integer studentId;
    /**
     * 学生-名字
     */
    private String studentName;
    /**
     * 学生-电子邮箱
     */
    private String studentEmail;
    /**
     * 学生—密码
     */
    private String studentPassword;
    /**
     * 学生-学号
     */
    private String studentNumber;
    /**
     * 学生-性别
     */
    private String studentSex;
    /**
     * 学生-当前学校
     */
    private String studentSchool;
    /**
     * 学生-手机号
     */
    private String studentPhone;
    /**
     * 学生身份状态，1为已确认，2为待确认，3为未确认
     */
    private String studentStatus;


    private byte[] photo;
}