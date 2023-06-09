package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @EmbeddedId
    CartID cartID;
    @Column(name = "price")
    private Integer price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "check_order")
    private Integer check;
    @Column(name = "check_delete")
    private Integer check_delete;
    @ManyToOne
    @MapsId("idCustomer")
    @JoinColumn(name = "id_customer")
    Customer customer;
    @ManyToOne
    @MapsId("idWatch")
    @JoinColumn(name = "id_watch")
    Watch watch;

    public Cart() {
    }

    public Cart(CartID cartID, Integer price, Integer quantity, Integer check,Integer check_delete, Customer customer, Watch watch) {
        this.cartID = cartID;
        this.price = price;
        this.quantity = quantity;
        this.check = check;
        this.check_delete=check_delete;
        this.customer = customer;
        this.watch = watch;
    }

    public CartID getCartID() {
        return cartID;
    }

    public Integer getCheck_delete() {
        return check_delete;
    }

    public void setCheck_delete(Integer check_delete) {
        this.check_delete = check_delete;
    }

    public void setCartID(CartID cartID) {
        this.cartID = cartID;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }
}
