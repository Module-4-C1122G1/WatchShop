package com.example.watch_shop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CartID implements Serializable {
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "id_watch")
    private Integer idWatch;

    public CartID(Integer idCustomer, Integer idWatch) {
        this.idCustomer = idCustomer;
        this.idWatch = idWatch;
    }

    public CartID() {
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Integer getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Integer idWatch) {
        this.idWatch = idWatch;
    }

}
