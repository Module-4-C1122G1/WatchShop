package com.example.watch_shop.service;

import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.model.UserRole;

import java.util.List;

public interface IUserRoleService {
    List<UserRole> findAllUserRole();
    void saveUserRole(UserRole userRole);
    void findById(Integer id);
    void deleteUserRole(UserRole userRole);
    UserRole findUserRoleByAppUser(AppUser appUser);
}
