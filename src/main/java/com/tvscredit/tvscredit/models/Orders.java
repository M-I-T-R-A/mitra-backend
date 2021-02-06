package com.tvscredit.tvscredit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Shop shopId;

    @ElementCollection
    private List<Cart> cart;

    private String customerName;

    private String customerMobile;

    private Double amount;

    private Double bill;

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

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", cart=" + cart +
                ", customerName='" + customerName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", amount=" + amount +
                ", bill=" + bill +
                '}';
    }
}