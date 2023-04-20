package com.example.watch_shop.repository;

import com.example.watch_shop.model.Customer;
import com.example.watch_shop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee ,Integer> {
    @Transactional
    @Query(value = "select * from employee where employee.id_branch = ?" , nativeQuery = true)
    Page<Employee> findByBranchIdBranch(@Param("id") int id , Pageable pageable);

    Page<Employee> findEmployeeByNameContainingAndIsDelete(String name, PageRequest pageRequest, boolean b);

    List<Employee> findByBranchIdBranch(int id);
    Page<Employee> findByBranch(Integer idBranch, PageRequest pageRequest);
}

