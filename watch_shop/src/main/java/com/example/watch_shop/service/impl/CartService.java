package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.ICartRepository;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository iCartRepository;
    @Autowired
    IWatchRepository iWatchRepository;

    @Override
    public List<Cart> findAll() {
        return (List<Cart>) iCartRepository.findAll();
    }


    @Override
    public void update(CartID cartID, Integer qtt) {
        Cart cart = findById(cartID);
        Watch watch = iWatchRepository.findById(cartID.getIdWatch()).get();
        Integer price = watch.getPrice() * qtt;
        if (qtt <= watch.getQuantity()) {
            cart.setQuantity(qtt);
            cart.setPrice(price);
            iCartRepository.save(cart);
        }

    }

    public void updateCheckAnd(Integer idCus) {
        List<Cart> list = findByCusId(idCus);
        for (Cart cart : list) {
            cart.setCheck(1);
        }
    }

    public void addOrder(Integer idCus) {

    }

    @Override
    public Integer totalPrice(Integer idCus) {
        return iCartRepository.totalPriceOrder(idCus);
    }

    @Override
    public void deleteById(CartID id) {
        Cart cart = findById(id);
        cart.setCheck(1);
        iCartRepository.save(cart);
    }

    @Override
    public Cart findById(CartID cartID) {
        return iCartRepository.findById(cartID).get();
    }

    @Override
    public List<Cart> findByCusId(Integer id) {
        return iCartRepository.findCartByCartID_IdCustomer(id);
    }
}
