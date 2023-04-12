package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "type_customer")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_cus")
    Integer id;
    @Column(name = "name_type_cus")
    String name;

    public CustomerType() {
    }

    public CustomerType(Integer id, String name) {
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

