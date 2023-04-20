package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Domain;
import com.example.watch_shop.repository.IDomainRepository;
import com.example.watch_shop.service.employeeService.IDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainService implements IDomainService {
    @Autowired
    private IDomainRepository domainRepository;

    @Override
    public List<Domain> findAll() {
        return domainRepository.findAll();
    }
}
