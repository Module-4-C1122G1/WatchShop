package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.TypeWatch;
import com.example.watch_shop.repository.ITypeWatchRepository;
import com.example.watch_shop.service.ITypeWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeWatchService implements ITypeWatchService {
@Autowired
    ITypeWatchRepository iTypeWatchRepository;

    @Override
    public List<TypeWatch> findAll() {
        return iTypeWatchRepository.findAll();
    }
}
