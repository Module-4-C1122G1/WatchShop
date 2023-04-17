package com.example.watch_shop.service;

import com.example.watch_shop.model.OrderWatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IOrderWatchService {
    Page<OrderWatch> findAll(PageRequest pageRequest);
}
