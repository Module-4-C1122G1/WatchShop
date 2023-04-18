package com.example.watch_shop.dto;

import com.example.watch_shop.model.Branch;
import com.example.watch_shop.model.Diploma;
import com.example.watch_shop.model.Position;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDTO {

    private Integer id;
    @NotBlank(message = "tên không được để trống")
    @Pattern(regexp = "^[^@;,.=+\\\\-]+$", message = "Tên Không chứa kí tự đặc biệt")
    private String name;

    @NotBlank(message = "ngày sinh không được để trống")
    private String dateOfBirth;

    @NotBlank(message = "giới tính không được để trống")
    private String gender;

    @NotNull(message = "lương không được để trống")
    private Double salary;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\d{9,10}", message = "Số điện thoại phải từ 9 đến 10 số")
    private String phone;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Nhập đúng định dạng example@gmail")
    private String email;
    
    private String img;
    private Diploma diploma;

    private Position position;

    private Branch branch;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String name, String dateOfBirth, String gender, Double salary, String address, String phone, String email, String img) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.salary = salary;
        this.address = address;
        this.phone = phone;
        this.email = email;
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
}
