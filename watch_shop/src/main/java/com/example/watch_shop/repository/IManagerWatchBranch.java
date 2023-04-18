package com.example.watch_shop.repository;

import com.example.watch_shop.model.ManageWatchBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IManagerWatchBranch extends JpaRepository<ManageWatchBranch , Integer> {
//    @Transactional
//    @Query(value = "delete from ManageWatchBranch where branch = id")
//    void removeIdBranch(@Param("idBranch") int idBranch);
    void deleteByBranch_IdBranch(int idBranch);
}
