package com.example.watch_shop.repository;

import com.example.watch_shop.model.Manufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IManufactureRepository extends PagingAndSortingRepository<Manufacturer,Integer> {
}
