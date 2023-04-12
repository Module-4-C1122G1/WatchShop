package com.example.watch_shop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailID implements Serializable {
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "id_watch")
    private Integer idWatch;

    public OrderDetailID(Integer idOrder, Integer idWatch) {
        this.idOrder = idOrder;
        this.idWatch = idWatch;
    }

    public OrderDetailID() {

    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Integer idWatch) {
        this.idWatch = idWatch;
    }
}
