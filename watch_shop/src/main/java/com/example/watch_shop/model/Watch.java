package com.example.watch_shop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "watch")
public class Watch {
    @Id
    @Column(name = "id_watch")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idWatch;
    @Column(name = "name_watch")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "image")
    private String image;
    @Column(name = "strap_material")
    private String strapMaterial;
    @Column(name = "diameter")
    private String diameter;
    @Column(name = "face_color")
    private String color;
    @Column(name = "origin")
    private String origin;
    @Column(name = "detail")
    private String detail;
    @Column(name = "quantity")
    private Integer quantity ;
    @ManyToOne
    @JoinColumn(name = "id_type_watch")
    private TypeWatch typeWatch;
    @ManyToOne
    @JoinColumn(name = "id_manufacturer")
    private Manufacturer manufacturer;

    @ManyToMany
    @JoinTable(name = "manage_product_branch" , joinColumns = @JoinColumn(name = "id_watch") , inverseJoinColumns = @JoinColumn(name = "id_branch"))
    private Set<Branch> branchSet;

    public Watch() {
    }

    public Watch(Integer idWatch, String name, Integer price, String image, String strapMaterial, String diameter, String color, String origin, String detail, Integer quantity, TypeWatch typeWatch, Manufacturer manufacturer) {
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
}
