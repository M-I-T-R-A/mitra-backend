package com.tvscredit.tvscredit.models.shop;

import com.tvscredit.tvscredit.models.Address;
import com.tvscredit.tvscredit.models.Documents;
import com.tvscredit.tvscredit.models.enums.ShopCategory;
import com.tvscredit.tvscredit.models.enums.ShopOwnership;
import com.tvscredit.tvscredit.models.person.Customer;
import java.util.List;

import javax.persistence.*;

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

    private Double electricityAmount;

    @Column(columnDefinition="TEXT")
    private String electricityBillImageUrl;

    private ShopOwnership ownership;

    @ElementCollection
    private List<Documents> shopRelatedDocs;

    @Embedded
    private WareHouse wareHouse;

    @OneToOne
    private Customer owner;

    public List<Documents> getShopRelatedDocs() {
        return shopRelatedDocs;
    }

    public Double getElectricityAmount() {
        return electricityAmount;
    }

    public void setElectricityAmount(Double electricityAmount) {
        this.electricityAmount = electricityAmount;
    }

    public void setShopRelatedDocs(List<Documents> shopRelatedDocs) {
        this.shopRelatedDocs = shopRelatedDocs;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }

    public void setWareHouse(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

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

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
