package com.example.watch_shop.controller;

import com.example.watch_shop.dto.WatchUpdateDTO;
import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.service.ICartService;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin({"*"})
public class CartRestController {
    @Autowired
    ICartService iCartService;
    @Autowired
    IWatchService iWatchService;

    @PostMapping("")
    public void update(@RequestBody WatchUpdateDTO watch) {
        CartID cartID = new CartID(watch.getIdCus(), watch.getIdWatch());
        iCartService.update(cartID, watch.getQtt());
    }
}
