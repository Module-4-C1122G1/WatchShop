package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Customer;
import com.example.watch_shop.repository.ICustomerRepository;
import com.example.watch_shop.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(PageRequest pageRequest) {
        return customerRepository.findAll(pageRequest);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    @Override
    public void deleteCustomer(Integer idCustomer) {
        customerRepository.deleteById(idCustomer);
    }

    @Override
    public Customer findByIdCustomer(Integer idCustomer) {
        return customerRepository.findById(idCustomer).get();
    }

    @Override
    public Page<Customer> findByNameCustomer(String nameCustomer, PageRequest pageRequest) {
        return customerRepository.findByNameCustomer(nameCustomer, pageRequest);
    }

    @Override
    public Page<Customer> findByCustomerType(Integer idCustomerType, PageRequest pageRequest) {
        return customerRepository.findByCustomerType(idCustomerType, pageRequest);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return customerRepository.existsByPhone(phone);
    }

    @Override
    public boolean existsByAppUser_UserName(String userName) {
        return customerRepository.existsByAppUser_UserName(userName);
    }
}
