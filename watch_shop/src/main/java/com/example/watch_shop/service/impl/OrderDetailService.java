package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.OrderDetail;
import com.example.watch_shop.repository.IOrderDetailRepository;
import com.example.watch_shop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository iOrderDetailRepository;
    public void save(OrderDetail orderDetail){
        iOrderDetailRepository.save(orderDetail);
    }
}
