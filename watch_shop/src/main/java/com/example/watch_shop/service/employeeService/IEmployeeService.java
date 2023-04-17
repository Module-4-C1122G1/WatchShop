package com.example.watch_shop.service.employeeService;

import com.example.watch_shop.dto.EmployeeDTO;
import com.example.watch_shop.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findByAll(String name,PageRequest pageRequest);

    void save(EmployeeDTO employee);

    Employee findById(Integer id);

    void delete(Integer id);

    void update(Employee employee);
    List<Employee> list();


}
