package com.example.watch_shop.service;

import com.example.watch_shop.model.Account;
import com.example.watch_shop.model.CustomerType;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();
}
