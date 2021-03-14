package com.example.demo.entity;

import lombok.Data;

/**
 * datatables 接收实体类
 */
@Data
public class R {

    public R() {
    }

    public R(int draw, int recordsTotal, int recordsFiltered, Object data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    private int draw;

    private int recordsTotal;

    private int recordsFiltered;

    private Object data;


}