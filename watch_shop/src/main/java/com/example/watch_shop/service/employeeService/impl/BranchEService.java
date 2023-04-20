package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.TypeWatch;
import com.example.watch_shop.repository.IBranchERepository;
import com.example.watch_shop.service.employeeService.IBranchEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class BranchEService implements IBranchEService {
    @Autowired
    private IBranchERepository iBranchERepository;
    @Override
    public List<Branch> list() {
        return (List<Branch>) iBranchERepository.findAll();
    }
    @Override
    public List<Branch> findById(Integer id, PageRequest pageRequest) {
        return (List<Branch>) iBranchERepository.findAll();
    }
}
