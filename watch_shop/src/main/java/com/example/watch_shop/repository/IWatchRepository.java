package com.example.watch_shop.repository;

import com.example.watch_shop.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IWatchRepository extends JpaRepository<Watch,Integer> {
    @Transactional
    @Query(value = "select * from watch w join branchSet b where b.idBranch =:idBranch" , nativeQuery = true)
    List<Watch> findByBranchIdBranch(@Param("idBranch") int idBranch);
}
