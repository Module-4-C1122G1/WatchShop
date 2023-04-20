package com.example.watch_shop.model;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "app_user", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK", columnNames = "user_name") })
public class AppUser {
    //    @Id
//    @Column(name = "name_account")
//    @NotBlank(message = "Tài khoản không được để trống")
//    private String name;
//    @Column(name = "pass_word")
//    @NotBlank(message = "Mật khẩu không được để trống")
//    @Size(min = 6, message = "Mật khẩu phải trên 6 ký tự")
//    private String pass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "user_name", length = 36, nullable = false)
    @NotBlank(message = "Tài khoản không được để trống")
    private String userName;

    @Column(name = "encryted_password", length = 128, nullable = false)
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải trên 6 ký tự")
    private String encrytedPassword;

    @Column(name = "enabled", length = 1, nullable = false)
    @Value("${some.key: true}")
    private boolean enabled;


    public AppUser() {
    }

    public AppUser(String userName, String encrytedPassword, boolean enabled) {
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.enabled = enabled;
    }

    public AppUser(Integer userId, String userName, String encrytedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }

    public AppUser(String userName, String encrytedPassword) {
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
    }

    public AppUser(Integer userId, String userName, String encrytedPassword, boolean enabled) {
        this.userId = userId;
        this.userName = userName;
        this.encrytedPassword = encrytedPassword;
        this.enabled = enabled;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
