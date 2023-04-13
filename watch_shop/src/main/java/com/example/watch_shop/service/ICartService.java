package com.example.watch_shop.service;

import com.example.watch_shop.model.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();
}
