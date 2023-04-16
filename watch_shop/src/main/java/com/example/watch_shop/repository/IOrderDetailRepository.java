package com.example.watch_shop.repository;

import com.example.watch_shop.model.OrderDetail;
import com.example.watch_shop.model.OrderDetailID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderDetailRepository extends PagingAndSortingRepository<OrderDetail, OrderDetailID> {
}
