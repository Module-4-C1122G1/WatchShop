package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.model.Branch;
import com.example.watch_shop.repository.employeeRepository.IBranchRepository;
import com.example.watch_shop.service.employeeService.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BranchService implements IBranchService {
    @Autowired
    IBranchRepository iBranchRepository;
    @Override
    public List<Branch> list() {
        return (List<Branch>) iBranchRepository.findAll();
    }
}
