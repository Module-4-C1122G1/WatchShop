package com.example.watch_shop.service;

import com.example.watch_shop.model.TypeWatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ITypeWatchService {
    List<TypeWatch> findAll();
    Page<TypeWatch> findById(Integer id, PageRequest pageRequest);
}
