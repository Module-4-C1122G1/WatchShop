package com.example.watch_shop.service;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();

    void update(CartID cartID,Integer qtt);
    Cart findById(CartID cartID);
    List<Cart> findByCusId(Integer id);
    public Double totalPrice();
}
