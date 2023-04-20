package com.example.watch_shop.service.employeeService.impl;

import com.example.watch_shop.model.Position;
import com.example.watch_shop.repository.IPositionRepository;
import com.example.watch_shop.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> list() {
        return (List<Position>) iPositionRepository.findAll();
    }
}
