package com.example.demo.entity;


import lombok.Data;


/***
 * 分页实体类
 */
@Data
public class Page {


    private int draw;


    private int offset;


    /**
     * 分页大小
     */
    private int pageSize;

}