package com.example.watch_shop.repository;

import com.example.watch_shop.model.OrderDetail;
import com.example.watch_shop.model.OrderDetailID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IOrderDetailRepository extends PagingAndSortingRepository<OrderDetail, OrderDetailID> {
    @Transactional
    @Query(value = "select watch.name_watch , order_detail.quantity from watch join order_detail on order_detail.id_watch = watch.id_watch where watch.id_watch = ?" , nativeQuery = true)
    Integer getQuantityByOderDetail(@Param("id") int id);
}
