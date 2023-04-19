package com.example.watch_shop.repository;

import com.example.watch_shop.model.Position;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends PagingAndSortingRepository<Position,Integer> {
}
