package com.example.watch_shop.service.manager_watch_branch.impl;

import com.example.watch_shop.dto.BranchDTO;
import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.IBranchRepository;
import com.example.watch_shop.repository.IEmployeeRepository;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.service.manager_watch_branch.IBranchService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService implements IBranchService {
    @Autowired
    private IBranchRepository watchBranchRepository;
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Autowired
    private IWatchRepository watchRepository;
    @Override
    public List<Branch> findAll() {
        return watchBranchRepository.findAll();
    }

    @Override
    public Page<Branch> findAll(String name, Pageable pageable) {
        return watchBranchRepository.findBranchByNameContainingAndIsDelete(name, pageable, false);
    }

    @Override
    public Page<Employee> findAllEmployee(int id , Pageable pageable) {
        return employeeRepository.findByBranchIdBranch(id , pageable);
    }

    @Override
    public Page<Watch> findAllWatch(int id , Pageable pageable) {
        return watchRepository.findWatchByBranchIdBranch(id , pageable);
    }

    @Override
    public Branch findById(int id) {
        return watchBranchRepository.findById(id).get();
    }

    @Override
    public void create(BranchDTO branchDTO) {
        Branch branch = new Branch();
        BeanUtils.copyProperties(branchDTO, branch);
        watchBranchRepository.save(branch);
    }

    @Override
    public void update(BranchDTO branchDTO, int id) {
        Branch branch = watchBranchRepository.findById(id).get();
        BeanUtils.copyProperties(branchDTO, branch);
        watchBranchRepository.save(branch);
    }

    @Override
    public void delete(int id) {
        Optional<Branch> branch = watchBranchRepository.findById(id);
        List<Employee> list = employeeRepository.findByBranchIdBranch(id);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setDelete(true);
            employeeRepository.save(list.get(i));
        }
        if (branch.isPresent()) {
            branch.get().removeWatch(branch.get().getWatchSet());
            branch.get().removeEmployee(branch.get().getEmployeeSet());
            branch.get().setDelete(true);
            watchBranchRepository.save(branch.get());
        }
    }

    @Override
    public String findByNameContainingOrderBy() {
        return watchRepository.findByIdWatch();
    }
}
