package com.example.watch_shop.dto;

import com.example.watch_shop.model.Manufacturer;
import com.example.watch_shop.model.TypeWatch;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class WatchDTO {
    private Integer idWatch;
    @NotEmpty(message = "Không được để trống ")

    private String name;
    @NotEmpty(message = "Không được để trống ")

    private Integer price;

    private String image;
    private String strapMaterial;
    private String diameter;
    private String color;
    private String origin;
    private String detail;
    @NotEmpty
    private Integer quantity ;
    @ManyToOne
    @JoinColumn(name = "id_type_watch")
    private TypeWatch typeWatch;
    @ManyToOne
    @JoinColumn(name = "id_manufacturer")
    private Manufacturer manufacturer;
}
