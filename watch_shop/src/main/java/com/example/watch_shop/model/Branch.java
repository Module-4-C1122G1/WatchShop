package com.example.watch_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "id_branch")
    private Integer idBranch;
    @Column(name = "name_branch")
    private String name;
    @Column(name = "address_branch")
    private String address;
    @Column(name = "area_branch")
    private double area;


    public Branch() {
    }

    public Branch(Integer idBranch, String name, String address, double area) {
        this.idBranch = idBranch;
        this.name = name;
        this.address = address;
        this.area = area;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
