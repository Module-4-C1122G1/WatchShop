package com.example.watch_shop.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "order_watch")
public class OrderWatch{
    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;
    @Column(name = "date_order")
    private LocalDate date;
    @Column(name = "total_price")
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    Customer customer;

    public OrderWatch() {
    }

    public OrderWatch(LocalDate date, Integer price, Customer customer) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
