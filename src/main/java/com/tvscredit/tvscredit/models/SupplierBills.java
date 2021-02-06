package com.tvscredit.tvscredit.models;

import javax.persistence.*;

@Entity
public class SupplierBills{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    private String supplierName;

    private String supplierMobile;

    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierMobile() {
        return supplierMobile;
    }

    public void setSupplierMobile(String supplierMobile) {
        this.supplierMobile = supplierMobile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "SupplierBills{" +
                "id=" + id +
                ", customer=" + customer +
                ", supplierName='" + supplierName + '\'' +
                ", supplierMobile='" + supplierMobile + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}