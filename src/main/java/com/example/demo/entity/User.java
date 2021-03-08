package com.example.demo.entity;

import lombok.Data;
import net.sf.json.util.JSONUtils;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2021-01-23 17:14:30
 */
@Data
public class User {

    private String Email;
    private String Password;
    public String Shenfen;

    
}