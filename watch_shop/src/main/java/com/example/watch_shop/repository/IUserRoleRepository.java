package com.example.watch_shop.repository;

import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByAppUser(AppUser appUser);
    UserRole findUserRoleByAppUser(AppUser appUser);

}
