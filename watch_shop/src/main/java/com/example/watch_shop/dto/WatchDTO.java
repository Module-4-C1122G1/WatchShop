package com.example.watch_shop.dto;

import com.example.watch_shop.model.Manufacturer;
import com.example.watch_shop.model.TypeWatch;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class WatchDTO {
    private Integer idWatch;

    @NotEmpty(message = "Tên không được để trống ")
    private String name;

    @NotNull(message = "Giá không được để trống ")
    @Min(value = 0,message = "Giá phải lớn hơn 0")
    private Integer price;

    private String image;

    private String strapMaterial;

    private String diameter;

    private String color;

    private String origin;

    private String detail;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0,message = "Số lượng ít nhất là không ")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_type_watch")
    private TypeWatch typeWatch;

    @ManyToOne
    @JoinColumn(name = "id_manufacturer")
    private Manufacturer manufacturer;

    public WatchDTO() {
    }

    public WatchDTO(Integer idWatch, String name, Integer price, String image, String strapMaterial, String diameter, String color, String origin, String detail, Integer quantity, TypeWatch typeWatch, Manufacturer manufacturer) {
        this.idWatch = idWatch;
        this.name = name;
        this.price = price;
        this.image = image;
        this.strapMaterial = strapMaterial;
        this.diameter = diameter;
        this.color = color;
        this.origin = origin;
        this.detail = detail;
        this.quantity = quantity;
        this.typeWatch = typeWatch;
        this.manufacturer = manufacturer;
    }

    public Integer getIdWatch() {
        return idWatch;
    }

    public void setIdWatch(Integer idWatch) {
        this.idWatch = idWatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStrapMaterial() {
        return strapMaterial;
    }

    public void setStrapMaterial(String strapMaterial) {
        this.strapMaterial = strapMaterial;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TypeWatch getTypeWatch() {
        return typeWatch;
    }

    public void setTypeWatch(TypeWatch typeWatch) {
        this.typeWatch = typeWatch;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchDTO watchDTO = (WatchDTO) o;
        return Objects.equals(idWatch, watchDTO.idWatch) && Objects.equals(name, watchDTO.name) && Objects.equals(price, watchDTO.price) && Objects.equals(image, watchDTO.image) && Objects.equals(strapMaterial, watchDTO.strapMaterial) && Objects.equals(diameter, watchDTO.diameter) && Objects.equals(color, watchDTO.color) && Objects.equals(origin, watchDTO.origin) && Objects.equals(detail, watchDTO.detail) && Objects.equals(quantity, watchDTO.quantity) && Objects.equals(typeWatch, watchDTO.typeWatch) && Objects.equals(manufacturer, watchDTO.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idWatch, name, price, image, strapMaterial, diameter, color, origin, detail, quantity, typeWatch, manufacturer);
    }
}
