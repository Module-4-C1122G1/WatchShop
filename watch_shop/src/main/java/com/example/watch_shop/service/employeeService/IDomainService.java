package com.example.watch_shop.service.employeeService;

import com.example.watch_shop.model.Domain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDomainService {
    List<Domain> findAll();
}
