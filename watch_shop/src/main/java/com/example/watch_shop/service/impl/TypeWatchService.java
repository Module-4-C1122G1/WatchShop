package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.TypeWatch;
import com.example.watch_shop.repository.ITypeWatchRepository;
import com.example.watch_shop.service.ITypeWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeWatchService implements ITypeWatchService {
    @Autowired
    private ITypeWatchRepository iTypeWatchRepository;

    @Override
    public List<TypeWatch> findAll() {
        return iTypeWatchRepository.findAll();
    }

    @Override
    public Page<TypeWatch> findById(Integer id, PageRequest pageRequest) {
        return null;
    }

}
