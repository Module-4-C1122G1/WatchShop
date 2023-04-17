package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.OrderWatch;
import com.example.watch_shop.repository.IOrderWatchRepository;
import com.example.watch_shop.service.IOrderWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class OrderWatchService implements IOrderWatchService {
    @Autowired
    IOrderWatchRepository iOrderWatchRepository;

    @Override
    public Page<OrderWatch> findAll(PageRequest pageRequest) {
        return iOrderWatchRepository.findAll(pageRequest);
    }
}
