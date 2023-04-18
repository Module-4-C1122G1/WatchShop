package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WatchService implements IWatchService {
    @Autowired
    IWatchRepository iWatchRepository;
    @Override
    public Page<Watch> findAll(PageRequest pageRequest) {
        return iWatchRepository.findAll(pageRequest);
    }

    @Override
    public Page<Watch> findByType(Integer id, PageRequest pageRequest) {
        return iWatchRepository.findWatchByTypeWatchId(id,pageRequest);
    }


    public Watch findById(Integer id){
        return iWatchRepository.findById(id).get();
    }

    @Override
    public Page<Watch> findByName(String name, PageRequest pageRequest) {
        return iWatchRepository.findWatchByNameContaining(name,pageRequest);
    }

    public void updateQuantity(Integer qtt,Integer id){
        Watch watch=findById(id);
        watch.setQuantity(qtt);
        iWatchRepository.save(watch);
    }
}
