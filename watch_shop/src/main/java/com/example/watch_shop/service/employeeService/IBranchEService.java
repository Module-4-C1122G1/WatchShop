package com.example.watch_shop.service.employeeService;

import com.example.watch_shop.model.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBranchEService {
    List<Branch> list();
    List<Branch> findById(Integer id, PageRequest pageRequest);
}
