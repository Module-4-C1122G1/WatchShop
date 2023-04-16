package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.model.Diploma;
import com.example.watch_shop.repository.employeeRepository.IDiplomaRepository;
import com.example.watch_shop.service.employeeService.IDilomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DilomaService implements IDilomaService {
    @Autowired
    IDiplomaRepository iDiplomaRepository;
    @Override
    public List<Diploma> list() {
        return (List<Diploma>) iDiplomaRepository.findAll();
    }
}
