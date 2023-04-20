package com.example.watch_shop.service;

import com.example.watch_shop.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    //    Page<Customer> findAllCustomer(PageRequest pageRequest);
    Page<Customer> findAllCustomer(String name, Pageable pageable);

    void saveCustomer(Customer customer);

    void deleteCustomer(Integer idCustomer);

    Customer findByIdCustomer(Integer idCustomer);

    Page<Customer> findByNameCustomer(String nameCustomer, PageRequest pageRequest);

    Page<Customer> findByCustomerType(Integer idCustomerType, PageRequest pageRequest);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByAppUser_UserName(String userName);

    Customer findByNameAccount(String nameAccount);
}
