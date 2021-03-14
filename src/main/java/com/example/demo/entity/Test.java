package com.example.demo.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Test)实体类
 *
 * @author makejava
 * @since 2021-03-15 18:30:01
 */
@Data
public class Test extends Page {
    /**
     * 考试码
     */
    private Integer id;


    private String name;

    private Date begin;

    private Date end;

    private Integer fenzhi;

    private Integer teacherid;


    private Teacher teacher;

    private  Integer quanxian;
}