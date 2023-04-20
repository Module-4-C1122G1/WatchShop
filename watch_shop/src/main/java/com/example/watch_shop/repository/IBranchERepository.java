package com.example.watch_shop.repository;

import com.example.watch_shop.model.Branch;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchERepository extends PagingAndSortingRepository<Branch,Integer> {
}
