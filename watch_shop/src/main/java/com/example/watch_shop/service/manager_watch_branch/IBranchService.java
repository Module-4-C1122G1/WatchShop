package com.example.watch_shop.service.manager_watch_branch;

import com.example.watch_shop.dto.BranchDTO;
import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBranchService {
    List<Branch> findAll();
    Page<Branch> findAll(String name , Pageable pageable);
    Page<Employee> findAllEmployee(int id , Pageable pageable);
    Page<Watch> findAllWatch(int id , Pageable pageable);
    Branch findById(int id);
    void create (BranchDTO branchDTO);
    void update(BranchDTO branchDTO , int id);
    void delete(int isDelete);
    String findByNameContainingOrderBy();
}
