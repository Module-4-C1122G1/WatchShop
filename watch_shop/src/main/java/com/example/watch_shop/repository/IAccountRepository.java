package com.example.watch_shop.repository;

import com.example.watch_shop.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepository extends PagingAndSortingRepository<Account, Integer> {
}
