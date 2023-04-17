package com.example.watch_shop.repository;

import com.example.watch_shop.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IWatchRepository extends JpaRepository<Watch,Integer> {
    @Transactional
    @Query(value = "select * from watch join manage_product_branch on manage_product_branch.id_watch = watch.id_watch where manage_product_branch.id_branch = ?" , nativeQuery = true)
    List<Watch> findWatchByBranchIdBranch(@Param("idBranch") int idBranch);
}
