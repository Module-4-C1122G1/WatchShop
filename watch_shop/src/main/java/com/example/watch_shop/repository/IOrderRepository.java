package com.example.watch_shop.repository;

import com.example.watch_shop.model.OrderWatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends PagingAndSortingRepository<OrderWatch,Integer> {
    Page<OrderWatch> findAll(Pageable pageable);
    @Query(value = "select sum(total_price) from order_watch",nativeQuery = true)
    Long totalPrice();
}
