package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.model.Employee;
import com.example.watch_shop.repository.employeeRepository.IEmployeeRepository;
import com.example.watch_shop.service.employeeService.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findByAll(String name,PageRequest pageRequest) {
        return iEmployeeRepository.findByNameContaining(name,pageRequest);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> list() {
        return (List<Employee>) iEmployeeRepository.findAll();
    }
}
