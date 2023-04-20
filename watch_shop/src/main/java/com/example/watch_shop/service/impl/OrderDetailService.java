package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.OrderDetail;
import com.example.watch_shop.repository.IOrderDetailRepository;
import com.example.watch_shop.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository iOrderDetailRepository;
    public void save(OrderDetail orderDetail){
        iOrderDetailRepository.save(orderDetail);
    }
    public Page<OrderDetail> findByIdOrder(Integer id,PageRequest pageRequest){
        return iOrderDetailRepository.findAllByOrderDetailID_IdOrder(id,pageRequest);
    }

}
