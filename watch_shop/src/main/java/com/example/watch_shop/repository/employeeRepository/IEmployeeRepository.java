package com.example.watch_shop.repository.employeeRepository;

import com.example.watch_shop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    Page<Employee> findByNameContaining(String name,Pageable pageRequest);
}
