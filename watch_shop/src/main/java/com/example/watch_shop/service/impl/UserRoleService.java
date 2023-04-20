package com.example.watch_shop.service.impl;

import com.example.watch_shop.model.AppUser;
import com.example.watch_shop.model.UserRole;
import com.example.watch_shop.repository.IUserRoleRepository;
import com.example.watch_shop.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Override
    public List<UserRole> findAllUserRole() {
        return userRoleRepository.findAll();
    }

    @Override
    public void saveUserRole(UserRole userRole) {
       userRoleRepository.save(userRole);
    }

    @Override
    public void findById(Integer id) {
     userRoleRepository.findById(id);
    }

    @Override
    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    @Override
    public UserRole findUserRoleByAppUser(AppUser appUser) {
        return userRoleRepository.findUserRoleByAppUser(appUser);
    }
}
