package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.Account;
import com.example.watch_shop.repository.IAccountRepository;
import com.example.watch_shop.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;
    @Override
    public List<Account> findAllAccount() {
        return (List<Account>) accountRepository.findAll();
    }
}
