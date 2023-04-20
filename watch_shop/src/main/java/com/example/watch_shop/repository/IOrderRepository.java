package com.example.watch_shop.repository;

import com.example.watch_shop.model.OrderWatch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends PagingAndSortingRepository<OrderWatch,Integer> {
    @Query(value = "select sum(total_price) from order_watch",nativeQuery = true)
    Long totalPrice();
}
