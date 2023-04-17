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
    @Column(name = "image")
    private String img;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idOrder")
    @JoinColumn(name = "id_order")
    OrderWatch orderWatch;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("idWatch")
    @JoinColumn(name = "id_watch")
    Watch watch;


    public OrderDetail() {
    }

    public OrderDetail(OrderDetailID orderDetailID, Integer quantity, Integer price, String img, OrderWatch orderWatch, Watch watch) {
        this.orderDetailID = orderDetailID;
        this.quantity = quantity;
        this.price = price;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
