package com.example.watch_shop.repository;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICartRepository extends PagingAndSortingRepository<Cart, CartID> {
    public List<Cart> findCartByCartID_IdCustomer(Integer id);
}
