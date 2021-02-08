package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DONG
 * @title: ceshi
 * @projectName demo
 * @description: TODO
 * @date 2021/1/27        18:00
 */
@Controller
public class ceshi {

    @RequestMapping({"/ceshi.html", "/ceshi"})//
    public String ceshi() {
        return "ui-modeceshi";
    }
}
