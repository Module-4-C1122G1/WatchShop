package com.example.watch_shop.repository;

import com.example.watch_shop.model.Watch;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IWatchRepository extends PagingAndSortingRepository<Watch,Integer> {

    List<Watch>findAll();
    Page<Watch>findByNameContaining(String name, Pageable pageable);
    Watch findByIdWatch(int idWatch);
    Page<Watch> findWatchByTypeWatchId(Integer id,PageRequest pageRequest);
    @Transactional
    @Query(value = "select * from watch join manage_product_branch on manage_product_branch.id_watch = watch.id_watch where manage_product_branch.id_branch = ?" , nativeQuery = true)
    List<Watch> findWatchByBranchIdBranch(@Param("idBranch") int idBranch);
}
