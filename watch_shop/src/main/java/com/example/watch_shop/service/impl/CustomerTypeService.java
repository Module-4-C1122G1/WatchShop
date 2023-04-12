package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.CustomerType;
import com.example.watch_shop.repository.ICustomerRepository;
import com.example.watch_shop.repository.ICustomerTypeRepository;
import com.example.watch_shop.service.ICustomerService;
import com.example.watch_shop.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAllCustomerType() {
        return (List<CustomerType>) customerTypeRepository.findAll();
    }
}
