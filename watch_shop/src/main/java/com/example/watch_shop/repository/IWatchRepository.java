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



    Page<Watch> findByNameContaining(String name, Pageable pageable);

    List<Watch>findAll();
    Page<Watch>findByNameContainingAndIsDelete(String name, Pageable pageable,boolean isDelete);
    @Query(value = "select * from watch where is_delete=0",nativeQuery = true)
    Page<Watch>findAllWhereIsDelete(Pageable pageable);

    Watch findByIdWatch(int idWatch);

    Page<Watch> findWatchByTypeWatchId(Integer id, Pageable pageable);

    Page<Watch> findWatchByNameContaining(String name, Pageable pageable);

    @Transactional
    @Query(value = "select * from watch join manage_product_branch on manage_product_branch.id_watch = watch.id_watch where manage_product_branch.id_branch = ?", nativeQuery = true)
    List<Watch> findWatchByBranchIdBranch(@Param("idBranch") int idBranch);

    @Query(value = "select watch.name_watch,sum(order_detail.quantity) from order_detail join watch on order_detail.id_watch=watch.id_watch group by order_detail.id_watch order by sum(order_detail.quantity) desc limit 0,1 ",nativeQuery = true)
    String findByIdWatch();



}
