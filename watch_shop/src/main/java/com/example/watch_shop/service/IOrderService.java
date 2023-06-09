package com.example.watch_shop.service;

import com.example.watch_shop.model.OrderWatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    void save(OrderWatch orderWatch);
    Page<OrderWatch> findAll(Pageable pageable);
    void delete(Integer id);
    Long totalPrice();
}
