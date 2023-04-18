package com.example.watch_shop.controller;

import com.example.watch_shop.service.employeeService.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/domain")
public class DomainController {
    @Autowired
    private IDomainService domainService;
    @GetMapping("")
    public void showList(){
        domainService.findAll();
    }
}
