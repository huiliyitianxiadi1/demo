package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Class)实体类
 *
 * @author makejava
 * @since 2021-01-25 15:06:17
 */
@Data
public class Class {

    private Integer classId;

    private String school;

    private String grade;

    private String classname;
    /**
     * 班级创建者（老师id）\n
     */
    private Integer teacherId;
    /**
     * 班级密码 （学生需要输入密码才能进入该班级）
     */
    private String classPassword;


}