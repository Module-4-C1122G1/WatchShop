package com.example.watch_shop.repository;

import com.example.watch_shop.model.ManageWatchBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IManagerWatchBranch extends JpaRepository<ManageWatchBranch , Integer> {
    @Transactional
    @Query(value = "delete from manage_product_branch where id_branch = ?" , nativeQuery = true)
    void deleteManageWatchBranches(@Param("idBranch") int idBranch);
}
