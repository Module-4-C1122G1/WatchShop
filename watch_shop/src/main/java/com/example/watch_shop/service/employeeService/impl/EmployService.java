package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.dto.EmployeeDTO;
import com.example.watch_shop.model.Employee;
import com.example.watch_shop.repository.IEmployeeRepository;
import com.example.watch_shop.repository.employeeRepository.IEmployeeeRepository;
import com.example.watch_shop.service.employeeService.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IEmployeeeRepository iEmployeeeRepository;

    @Override
    public Page<Employee> findByAll(String name,PageRequest pageRequest) {
        return iEmployeeRepository.findEmployeeByNameContainingAndIsDelete(name,pageRequest , false);
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        Employee employee =new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        Employee employee = iEmployeeRepository.findById(id).get();
        employee.setDelete(true);
        iEmployeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> list() {
        return  iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findByBranch(Integer idBranch, PageRequest pageRequest) {
        return iEmployeeeRepository.findByBranch(idBranch,pageRequest);
    }
}
