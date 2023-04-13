package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.repository.ICartRepository;
import com.example.watch_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository iCartRepository;
    @Override
    public List<Cart> findAll() {
        return (List<Cart>) iCartRepository.findAll();
    }
}
