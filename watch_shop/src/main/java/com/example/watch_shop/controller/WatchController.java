package com.example.watch_shop.controller;

import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("type")
    public String type(Model model, @RequestParam(name = "id", required = false) Integer id, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        Page<Watch> page1 = iWatchService.findByType(id, PageRequest.of(page, 10));
        model.addAttribute("list", page1);
        model.addAttribute("listManu", iManufactureService.finAll());
        model.addAttribute("id", id);
        model.addAttribute("check", 1);
        return "watches";
    }


    @GetMapping("watches")
    public String watches(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("list", iWatchService.findAll(PageRequest.of(page, 10)));
        model.addAttribute("listManu", iManufactureService.finAll());
        model.addAttribute("check", 0);
        return "watches";
    }

    @GetMapping("register")
    public String register() {
        return "register";
    }

    @PostMapping("search")
    public String searchByName(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "name", required = false) String name) {
        model.addAttribute("list", iWatchService.findByName(name, PageRequest.of(page, 10)));
        model.addAttribute("listManu", iManufactureService.finAll());
        model.addAttribute("check", 2);
        return "watches";
    }

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page) {
        model.addAttribute("list", iWatchService.findAll(PageRequest.of(page, 10)));
        return "index";
    }

//    @GetMapping("cart")
//    public String cart() {
//        return "cart";
//    }
}
