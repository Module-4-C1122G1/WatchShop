package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_domain;
    @Column(name = "name")
    private String name;
    public Domain() {

    }
    public Domain(int id_domain, String name) {
        this.id_domain = id_domain;
        this.name = name;
    }

    public int getId_domain() {
        return id_domain;
    }

    public void setId_domain(int id_domain) {
        this.id_domain = id_domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
