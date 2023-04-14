package com.example.watch_shop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role_user")
public class Role {
    @Id
    @Column(name = "id_role")
    Integer id;
    @Column(name = "name_role")
    String name;
    @ManyToMany(mappedBy = "roles")
    private Set<Account> accounts;

    public Role() {
    }

    public Role(Integer id, String name, Set<Account> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
