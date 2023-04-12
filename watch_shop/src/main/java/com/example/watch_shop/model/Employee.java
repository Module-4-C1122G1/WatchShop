package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "id_employee")
    private Integer id;
    @Column(name = "name_employee")
    private String name;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "email_employee")
    private String email;
    @Column(name = "img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "id_diploma")
    private Diploma diploma;
    @ManyToOne
    @JoinColumn(name = "id_position")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_branch")
    private Branch branch;

    public Employee() {
    }

    public Employee(Integer id, String name, String dateOfBirth, String gender, Double salary, String address, String phone, String email, String img, Diploma diploma, Position position, Branch branch) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.img = img;
        this.diploma = diploma;
        this.position = position;
        this.branch = branch;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Diploma getDiploma() {
        return diploma;
    }

    public void setDiploma(Diploma diploma) {
        this.diploma = diploma;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
