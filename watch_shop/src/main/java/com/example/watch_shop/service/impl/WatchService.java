package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.IOrderDetailRepository;
import com.example.watch_shop.repository.IWatchRepository;
import com.example.watch_shop.repository.PostCommentSummary;
import com.example.watch_shop.service.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository iWatchRepository;
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

    @Override
    public Page<Watch> findAll(PageRequest pageRequest) {
        return iWatchRepository.findAll(pageRequest);
    }

    @Override
    public List<Watch> findAll() {
        return iWatchRepository.findAll();
    }

    @Override
    public List<PostCommentSummary> getQuantitySell() {
        return orderDetailRepository.getQuantityByOderDetail();
    }

    @Override
    public Page<Watch> findAllWatch(String name,Pageable pageable) {
        return iWatchRepository.findByNameContainingAndIsDelete(name,pageable,false);
    }

    @Override
    public Watch findByIdWatch(int idWatch) {
        return iWatchRepository.findByIdWatch(idWatch);
    }

    @Override
    public void save(Watch watch) {
        iWatchRepository.save(watch);
    }

    //    @Override
//    public void delete(int idWatch) {
//        iWatchRepository.delete(findById(idWatch));
//    }
    @Override
    public void delete(int idWatch) {
        Optional<Watch> watch = iWatchRepository.findById(idWatch);
        if (watch.isPresent()) {
            watch.get().setDelete(true);
            iWatchRepository.save(watch.get());
        }
    }


    public Page<Watch> findByType(Integer id, PageRequest pageRequest) {
        return iWatchRepository.findWatchByTypeWatchId(id, pageRequest);
    }


    public Watch findById(Integer id) {
        return iWatchRepository.findById(id).get();
    }

    @Override
    public Page<Watch> findByName(String name, PageRequest pageRequest) {
        return iWatchRepository.findWatchByNameContaining(name, pageRequest);
    }

    public void updateQuantity(Integer qtt, Integer id) {
        Watch watch = findById(id);
        watch.setQuantity(qtt);
        iWatchRepository.save(watch);
    }
}
