package com.example.watch_shop.service;

import com.example.watch_shop.model.TypeWatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ITypeWatchService {
    Page<TypeWatch> findById(Integer id, PageRequest pageRequest);
}
