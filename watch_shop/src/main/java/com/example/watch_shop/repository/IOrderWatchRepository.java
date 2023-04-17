package com.example.watch_shop.repository;

import com.example.watch_shop.model.OrderWatch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderWatchRepository extends PagingAndSortingRepository<OrderWatch,Integer> {
}
