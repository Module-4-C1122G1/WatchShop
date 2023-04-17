package com.example.watch_shop.repository;

import com.example.watch_shop.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee , Integer> {
    List<Employee> findByBranchIdBranch(int idBranch);
}
