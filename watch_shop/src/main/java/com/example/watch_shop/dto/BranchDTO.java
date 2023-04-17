package com.example.watch_shop.dto;

public class BranchDTO {
    private Integer idBranch;
    private String name;
    private String address;
    private double area;

    public BranchDTO() {
    }

    public BranchDTO(Integer idBranch, String name, String address, double area) {
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
