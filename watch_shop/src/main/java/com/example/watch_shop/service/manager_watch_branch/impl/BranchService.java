package com.example.watch_shop.service.manager_watch_branch.impl;

import com.example.watch_shop.dto.BranchDTO;
import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.IBranchRepository;
import com.example.watch_shop.repository.IEmployeeRepository;
import com.example.watch_shop.repository.IManagerWatchBranch;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.service.manager_watch_branch.IBranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService {
    @Autowired
    private IBranchRepository watchBranchRepository;
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IWatchRepository watchRepository;
    @Override
    public Page<Branch> findAll(String name, Pageable pageable) {
        return watchBranchRepository.findBranchByNameContainingAndIsDelete(name, pageable , false);
    }

    @Override
    public List<Employee> findAllEmployee(int id) {
        return employeeRepository.findByBranchIdBranch(id);
    }

    @Override
    public List<Watch> findAllWatch(int idBranch) {
        return watchRepository.findByBranchIdBranch(idBranch);
    }

    @Override
    public Branch findById(int id) {
        return watchBranchRepository.findById(id).get();
    }

    @Override
    public void create(BranchDTO branchDTO) {
        Branch branch = new Branch();
        BeanUtils.copyProperties(branchDTO , branch);
        watchBranchRepository.save(branch);
    }

    @Override
    public void update(BranchDTO branchDTO , int id) {
        Branch branch = watchBranchRepository.findById(id).get();
        BeanUtils.copyProperties(branchDTO , branch);
        watchBranchRepository.save(branch);
    }
    @Override
    public void delete(int id) {
        Branch branch = watchBranchRepository.findById(id).get();
        branch.setDelete(true);
        watchBranchRepository.save(branch);
    }
}
