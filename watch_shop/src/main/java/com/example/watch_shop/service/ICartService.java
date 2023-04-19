package com.example.watch_shop.service;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;

import java.util.List;

public interface ICartService {
    List<Cart> findAll();
    void addCart(String nameAcc,Integer idWatch,Integer price,Integer qtt);
    void update(CartID cartID,Integer qtt);
    Cart findById(CartID cartID);
    List<Cart> findByCusId(Integer id);
    Integer totalPrice(Integer idCus);
    void deleteById(CartID id);
    void addOrder(Integer idCus);
    void updateCheck(Integer idCus);
    void save(Cart cart);

    void addOneOrder(String nameAcc, Integer idWatch, Integer qtt, Integer price);
}
