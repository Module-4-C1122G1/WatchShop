package com.example.watch_shop.repository;

import com.example.watch_shop.model.Watch;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IWatchRepository extends PagingAndSortingRepository<Watch,Integer> {
}
