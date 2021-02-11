package com.tvscredit.tvscredit.models.person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tvscredit.tvscredit.models.shop.Shop;

import javax.persistence.*;

@Entity
public class ShopCustomer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    private Double creditAmount;

    private Boolean isCreditAmountVerified;

    @JsonIgnore
    @ManyToOne
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Boolean getCreditAmountVerified() {
        return isCreditAmountVerified;
    }

    public void setCreditAmountVerified(Boolean creditAmountVerified) {
        isCreditAmountVerified = creditAmountVerified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
