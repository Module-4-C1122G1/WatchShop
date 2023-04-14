package com.example.watch_shop.controller;

import com.example.watch_shop.model.CartID;
import com.example.watch_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
    @Autowired
    ICartService iCartService;

    @PostMapping("")
    public void update(@RequestParam("qtt") Integer qtt) {
        CartID cartID = new CartID(1, 1);
        iCartService.update(cartID, qtt);
    }
}
