package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.OrderWatch;
import com.example.watch_shop.repository.IOrderRepository;
import com.example.watch_shop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository iOrderRepository;
    public void save(OrderWatch orderWatch){
        iOrderRepository.save(orderWatch);
    }

    @Override
    public Page<OrderWatch> findAll(Pageable pageable) {
        return iOrderRepository.findAll(pageable);
    }
    public void delete(Integer id){
        iOrderRepository.deleteById(id);
    }

    @Override
    public Long totalPrice() {
        return iOrderRepository.totalPrice();
    }
}
