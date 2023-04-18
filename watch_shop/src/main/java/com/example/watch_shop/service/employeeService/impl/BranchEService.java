package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.model.Branch;
import com.example.watch_shop.repository.employeeRepository.IBranchERepository;
import com.example.watch_shop.service.employeeService.IBranchEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BranchEService implements IBranchEService {
    @Autowired
    IBranchERepository iBranchERepository;
    @Override
    public List<Branch> list() {
        return (List<Branch>) iBranchERepository.findAll();
    }
}
