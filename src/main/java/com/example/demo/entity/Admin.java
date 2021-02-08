package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-01-25 15:06:17
 */
@Data
public class Admin {


    private Integer adminId;

    private String adminName;

    private String adminEmail;

    private String adminPassword;


}