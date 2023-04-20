package com.example.watch_shop.repository;

import antlr.collections.impl.LList;
import com.example.watch_shop.model.OrderDetail;
import com.example.watch_shop.model.OrderDetailID;
import com.example.watch_shop.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderDetailRepository extends PagingAndSortingRepository<OrderDetail, OrderDetailID> {
    @Transactional
    @Query(value = "select watch.name_watch , watch.image , sum(order_detail.quantity) as sum from watch join order_detail on order_detail.id_watch = watch.id_watch group by watch.id_watch" , nativeQuery = true)
    List<PostCommentSummary> getQuantityByOderDetail();
    Page<OrderDetail> findAllByOrderDetailID_IdOrder(Integer id,PageRequest pageRequest);
}
