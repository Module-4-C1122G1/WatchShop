package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Manufacturer;
import com.example.watch_shop.repository.IManufactureRepository;
import com.example.watch_shop.service.IManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureService implements IManufactureService {
    @Autowired
    IManufactureRepository iManufactureRepository;

    @Override
    public List<Manufacturer> finAll() {
        return (List<Manufacturer>) iManufactureRepository.findAll();
    }
}
