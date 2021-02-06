package com.tvscredit.tvscredit.models;

import com.tvscredit.tvscredit.models.enums.ShopCategory;
import com.tvscredit.tvscredit.models.enums.ShopOwnership;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shop {

    @Id
    @GeneratedValue
    private Long id;

    private String shopName;

    @Embedded
    private Address shopAddress;

    private String phoneNumber;

    private Double area;

    private ShopCategory type;

    private Float rating;

    private String GSTIN;

    private String electricityBillImageUrl;

    private ShopOwnership ownership;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Address getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(Address shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public ShopCategory getType() {
        return type;
    }

    public void setType(ShopCategory type) {
        this.type = type;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }

    public String getElectricityBillImageUrl() {
        return electricityBillImageUrl;
    }

    public void setElectricityBillImageUrl(String electricityBillImageUrl) {
        this.electricityBillImageUrl = electricityBillImageUrl;
    }

    public ShopOwnership getOwnership() {
        return ownership;
    }

    public void setOwnership(ShopOwnership ownership) {
        this.ownership = ownership;
    }
}
