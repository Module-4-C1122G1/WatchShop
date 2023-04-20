package com.example.watch_shop.repository;

import com.example.watch_shop.model.Customer;
import com.example.watch_shop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee ,Integer> {
    List<Employee> findByBranchIdBranch(int idBranch);

    Page<Employee> findEmployeeByNameContainingAndIsDelete(String name, PageRequest pageRequest, boolean b);


    Page<Employee> findByBranch(Integer idBranch, PageRequest pageRequest);

    
    
    void deleteEmployeeByBranchIdBranch(int deleteId);

}

