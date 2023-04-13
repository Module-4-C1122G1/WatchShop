package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @EmbeddedId
    CartID cartID;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "check_order")
    private Integer check;
    @Column(name = "image")
    String img;
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

    public Cart(CartID cartID, Double price, Integer quantity, Integer check, String img, Customer customer, Watch watch) {
        this.cartID = cartID;
        this.price = price;
        this.quantity = quantity;
        this.check = check;
        this.img = img;
        this.customer = customer;
        this.watch = watch;
    }

    public CartID getCartID() {
        return cartID;
    }

    public void setCartID(CartID cartID) {
        this.cartID = cartID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
