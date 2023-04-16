package com.example.watch_shop.repository;

import com.example.watch_shop.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUserName(String username);
}
