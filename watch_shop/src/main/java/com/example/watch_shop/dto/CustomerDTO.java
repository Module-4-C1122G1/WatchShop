package com.example.watch_shop.dto;

import com.example.watch_shop.model.Account;
import com.example.watch_shop.model.CustomerType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {

    private Integer idCustomer;
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotBlank(message = "Ngày sinh không được để trống")
    private String dayOfBirth;
    @NotBlank(message = " Đia chỉ không được để trống")
    private String address;
    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Không đúng định dạng example@gmail")
    private String email;
    @NotBlank(message = "Số điện thoai không được để trống")
    @Pattern(regexp = "\\d{9,10}", message = "Số điện thoại phải từ 9 đến 10 số")
    private String phone;
    private CustomerType customerType;
//    @NotBlank(message = "Account không được để trống")
//    @Size(min = 6, message = "Account phải trên 6 ký tự")
    private Account account;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String dayOfBirth, String address, String email, String phone, CustomerType customerType, Account account) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.account = account;
    }

    public CustomerDTO(Integer idCustomer, String name, String dayOfBirth, String address, String email, String phone, CustomerType customerType, Account account) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.account = account;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
