package com.example.watch_shop.repository;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICartRepository extends PagingAndSortingRepository<Cart, CartID> {

}
