package com.example.watch_shop.controller;

import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("watch")
public class WatchController {
    @Autowired
    IWatchService iWatchService;
    @Autowired
    IManufactureService iManufactureService;

    @GetMapping("detail")
    public String detail(Model model) {
        return "detail";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("watches")
    public String watches(Model model) {
        model.addAttribute("list",iWatchService.findAll());
        model.addAttribute("listManu",iManufactureService.finAll());
        return "watches";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @GetMapping("contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("list", iWatchService.findAll());
        return "index";
    }

//    @GetMapping("cart")
//    public String cart() {
//        return "cart";
//    }
}
