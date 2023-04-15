package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.OrderWatch;
import com.example.watch_shop.repository.IOrderRepository;
import com.example.watch_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository iOrderRepository;
    public void save(OrderWatch orderWatch){
        iOrderRepository.save(orderWatch);
    }
}
