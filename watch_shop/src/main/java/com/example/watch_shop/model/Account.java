package com.example.watch_shop.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "account_user")
public class Account {
    @Id
    @Column(name = "name_account")
    @NotBlank(message = "Tài khoản không được để trống")
    private String name;
    @Column(name = "pass_word")
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải trên 6 ký tự")
    private String pass;
    @ManyToMany
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "name_account"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Account() {
    }

    public Account(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Account(String name, String pass, Set<Role> roles) {
        this.name = name;
        this.pass = pass;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
