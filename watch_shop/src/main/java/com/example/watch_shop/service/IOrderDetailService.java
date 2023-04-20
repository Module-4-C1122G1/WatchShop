package com.example.watch_shop.service;

import com.example.watch_shop.model.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IOrderDetailService {
    void save(OrderDetail orderDetail);

    Page<OrderDetail> findByIdOrder(Integer id, PageRequest pageRequest);
}
