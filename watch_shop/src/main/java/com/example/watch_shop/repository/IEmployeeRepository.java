package com.example.watch_shop.repository;

import com.example.watch_shop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee , Integer> {
    List<Employee> findByBranchIdBranch(int idBranch);

    @Transactional
//    @Query(value = "delete from employee where branch.id_branch = ?" , nativeQuery = true)
    void deleteEmployeeByBranchIdBranch(int deleteId);
    Page<Employee> findByNameContaining(String name, Pageable pageRequest);
}
