package com.example.watch_shop.dto;

public class CartDTO {
    Integer cusId;
    Integer watchId;
    Integer qtt;
    Integer priceWatch;

    public CartDTO() {
    }

    public CartDTO(Integer cusId, Integer watchId, Integer qtt, Integer priceWatch) {
        this.cusId = cusId;
        this.watchId = watchId;
        this.qtt = qtt;
        this.priceWatch = priceWatch;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getWatchId() {
        return watchId;
    }

    public void setWatchId(Integer watchId) {
        this.watchId = watchId;
    }

    public Integer getQtt() {
        return qtt;
    }

    public void setQtt(Integer qtt) {
        this.qtt = qtt;
    }

    public Integer getPriceWatch() {
        return priceWatch;
    }

    public void setPriceWatch(Integer priceWatch) {
        this.priceWatch = priceWatch;
    }
}
