package com.example.watch_shop.repository.employeeRepository;

import com.example.watch_shop.model.Diploma;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiplomaRepository extends PagingAndSortingRepository<Diploma,Integer> {
}
