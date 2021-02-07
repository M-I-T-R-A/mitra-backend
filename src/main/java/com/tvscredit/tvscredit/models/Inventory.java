package com.tvscredit.tvscredit.models;

import com.tvscredit.tvscredit.models.shop.Shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inventory {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Shop shopId;

    private String name;

    private String type;

    private Double rating;

    private Double price;

    private Long quantity;

    public Inventory(Long id, String name, String type, Double rating, Double price, Long quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shop getShopId() {
        return shopId;
    }

    public void setShopId(Shop shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}