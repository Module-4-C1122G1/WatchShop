package com.example.watch_shop.repository;

import com.example.watch_shop.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer> {
    Page<Branch> findBranchByNameContainingAndIsDelete(String name, Pageable pageable , boolean isDelete);
}
