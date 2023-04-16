package com.example.watch_shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class demo {
    @GetMapping("")
    public String showList(){
        return "admins/pages/product/list";
    }
}
