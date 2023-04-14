package com.example.watch_shop.controller;

import com.example.watch_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    ICartService iCartService;
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("list",iCartService.findAll());
        model.addAttribute("total",iCartService.totalPrice());
        return "cart";
    }
}
