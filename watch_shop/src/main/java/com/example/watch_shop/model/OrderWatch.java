package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "order_watch")
public class OrderWatch {
    @Id
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "date_order")
    private String date;
    @Column(name = "total_price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    Customer customer;

    public OrderWatch() {
    }

    public OrderWatch(Integer idOrder, String date, Integer price, Customer customer) {
        this.idOrder = idOrder;
        this.date = date;
        this.price = price;
        this.customer = customer;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
