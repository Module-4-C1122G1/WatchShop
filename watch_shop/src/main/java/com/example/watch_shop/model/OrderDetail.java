package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailID orderDetailID;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Integer price;
    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "id_order")
    OrderWatch orderWatch;
    @ManyToOne
    @MapsId("idWatch")
    @JoinColumn(name = "id_watch")
    Watch watch;


    public OrderDetail() {
    }

    public OrderDetail(OrderDetailID orderDetailID, Integer quantity, Integer price, OrderWatch orderWatch, Watch watch) {
        this.orderDetailID = orderDetailID;
        this.quantity = quantity;
        this.price = price;
        this.orderWatch = orderWatch;
        this.watch = watch;
    }

    public OrderDetailID getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(OrderDetailID orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public OrderWatch getOrderWatch() {
        return orderWatch;
    }

    public void setOrderWatch(OrderWatch orderWatch) {
        this.orderWatch = orderWatch;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }
}
