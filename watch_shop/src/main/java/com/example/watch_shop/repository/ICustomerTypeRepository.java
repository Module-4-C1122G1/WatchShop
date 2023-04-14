package com.example.watch_shop.repository;

import com.example.watch_shop.model.CustomerType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICustomerTypeRepository extends PagingAndSortingRepository<CustomerType, Integer> {
}
