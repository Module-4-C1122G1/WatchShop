package com.example.watch_shop.dto;

public class WatchUpdateDTO {
    Integer qtt;
    Integer idWatch;
    Integer idCus;

    public WatchUpdateDTO() {
    }

    public WatchUpdateDTO(Integer qtt, Integer idWatch, Integer idCus) {
        this.qtt = qtt;
        this.idWatch = idWatch;
        this.idCus = idCus;
    }

    public Integer getQtt() {
        return qtt;
    }

    public void setQtt(Integer qtt) {
        this.qtt = qtt;
    }

    public Integer getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Integer idWatch) {
        this.idWatch = idWatch;
    }

    public Integer getIdCus() {
        return idCus;
    }

    public void setIdCustomer(Integer idCus) {
        this.idCus = idCus;
    }
}
