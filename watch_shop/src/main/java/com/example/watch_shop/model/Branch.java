package com.example.watch_shop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_branch")
    private Integer idBranch;
    @Column(name = "name_branch")
    private String name;
    @Column(name = "address_branch")
    private String address;
    @Column(name = "area_branch")
    private double area;
    @Column(name = "is_delete" , nullable = false)
    private boolean isDelete;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Employee> employees;

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Branch() {
    }

    public Branch(Integer idBranch, String name, String address, double area) {
        this.idBranch = idBranch;
        this.name = name;
        this.address = address;
        this.area = area;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
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