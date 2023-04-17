package com.example.watch_shop.repository;

import com.example.watch_shop.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IWatchRepository extends PagingAndSortingRepository<Watch,Integer> {
    List<Watch>findAll();
    Page<Watch>findByNameContaining(String name, Pageable pageable);
    Watch findByIdWatch(int idWatch);
}
