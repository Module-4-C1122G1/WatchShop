package com.example.watch_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diploma")
public class Diploma {
    @Id
    @Column(name = "id_diploma")
    private Integer id;
    @Column(name = "name_diploma")
    private String name;

    public Diploma() {
    }

    public Diploma(Integer id, String name) {
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
