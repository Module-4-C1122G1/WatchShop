package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WatchService implements IWatchService {
    @Autowired
    IWatchRepository iWatchRepository;
    @Override
    public List<Watch> findAll() {
        return (List<Watch>) iWatchRepository.findAll();
    }
}
