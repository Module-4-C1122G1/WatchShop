package com.example.watch_shop.repository;

import com.example.watch_shop.model.Cart;
import com.example.watch_shop.model.CartID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartRepository extends PagingAndSortingRepository<Cart, CartID> {
    @Query(value = "select *from cart where check_order=0", nativeQuery = true)
    List<Cart> findCartByCartID_IdCustomer(Integer id);

    @Query(value = "select sum(price) from cart where id_customer =:idCus and check_order=0", nativeQuery = true)
    Integer totalPriceOrder(@Param("idCus") Integer idCus);
}
