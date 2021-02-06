package com.tvscredit.tvscredit.models;

import javax.persistence.*;

@Embeddable
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Orders order;

    private String name;

    private Integer quantity;

    private Integer productId;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrderId() {
        return order;
    }

    public void setOrderId(Orders orderId) {
        this.order = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", orderId=" + order +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", price=" + price +
                '}';
    }
}
