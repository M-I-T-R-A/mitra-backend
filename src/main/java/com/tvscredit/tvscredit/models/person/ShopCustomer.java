package com.tvscredit.tvscredit.models.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopCustomer {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String phoneNumber;

    private Double creditAmount;

    private Boolean isCreditAmountVerified;

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
