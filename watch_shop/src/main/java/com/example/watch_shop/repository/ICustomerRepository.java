package com.example.watch_shop.repository;

import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    @Query(value = "select * from customer where name_customer like concat('%',:name_customer,'%')", nativeQuery = true)
    Page<Customer> findByNameCustomer(@Param("name_customer") String name, PageRequest pageRequest);

    @Query(value = "select * from customer where id_type_cus = :id_type_cus", nativeQuery = true)
    Page<Customer> findByCustomerType(@Param("id_type_cus") Integer id, PageRequest pageRequest);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    boolean existsByAppUser_UserName(String userName);
}
