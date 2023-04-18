package com.example.watch_shop.controller;

import com.example.watch_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("order")
public class OrderWatchController {
    @Autowired
    IOrderService iOrderService;
    @GetMapping("")
    public String findAll(Model model, @RequestParam(name = "page",defaultValue = "0")Integer page){
        model.addAttribute("listOrder",iOrderService.findAll(PageRequest.of(page,4)));
        return "admin/cart/list";
    }


}
