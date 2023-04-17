package com.example.watch_shop.controller;

import com.example.watch_shop.service.IManufactureService;
import com.example.watch_shop.service.ITypeWatchService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("watch")
public class WatchController {
    @Autowired
    private IWatchService iWatchService;
    @Autowired
    private IManufactureService iManufactureService;
    @Autowired
    private ITypeWatchService iTypeWatchService;

    @GetMapping("/detail/{idWatch}")
    public String detail(@PathVariable int idWatch, Model model) {
        model.addAttribute("typeWatchList", iTypeWatchService.findAll());
        model.addAttribute("manufactureList",iManufactureService.findAll());
        model.addAttribute("watch", iWatchService.findByIdWatch(idWatch));
        return "detail";
    }

    //    @GetMapping("/detail/{id}")
//    public String showDetail(@PathVariable int id, Model model) {
//        model.addAttribute("categoryList", iCategoryService.findAll());
//        model.addAttribute("blog", iBlogService.findById(id));
//        return "/detail";
//    }

//    @GetMapping("login")
//    public String login() {
//        return "login";
//    }

    @GetMapping("watches")
    public String watches(Model model) {
        model.addAttribute("list",iWatchService.findAll());
        model.addAttribute("listManu",iManufactureService.findAll());
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
