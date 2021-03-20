package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Dajuan)实体类
 *
 * @author makejava
 * @since 2021-03-17 15:27:31
 */
@Data
public class Dajuan {


    private Integer id;

    private Integer studentid;

    private Integer kaoshima;

    private Integer tiid;

    private Integer fenzhi;

    private String daan;


    private TestTable testTable;

    private Integer xx;

    private BankChoice bankChoice;
    private BankFill bankFill;
    private BankSubjective bankSubjective;
}