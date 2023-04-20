package com.example.watch_shop.repository.employeeRepository;

import com.example.watch_shop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeeRepository extends PagingAndSortingRepository<Employee,Integer> {
    @Query(value = "select * from employee where id_branch = :id_branch", nativeQuery = true)
    Page<Employee> findByBranch(@Param("id_branch") Integer id, PageRequest pageRequest);
}
