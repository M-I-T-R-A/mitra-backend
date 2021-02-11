package com.tvscredit.tvscredit.models.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.shop.PurchasedItemStock;
import com.tvscredit.tvscredit.models.surrogates.BaseSurrogates;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class PurchasedItemBill {

    @Id
    @GeneratedValue
    private Long id;

    private String supplierName;

    private String supplierMobile;

    @Column(columnDefinition="TEXT")
    private String imageUrl;

    @JsonIgnore
    @OneToOne(mappedBy = "purchasedItemBill")
    private PurchasedItemStock purchasedItemStock;

    @ManyToOne
    private InstantLoanSurrogates instantLoanSurrogates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InstantLoanSurrogates getInstantLoanSurrogates() {
        return instantLoanSurrogates;
    }

    public void setInstantLoanSurrogates(InstantLoanSurrogates instantLoanSurrogates) {
        this.instantLoanSurrogates = instantLoanSurrogates;
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

    public PurchasedItemStock getPurchasedItemStock() {
        return purchasedItemStock;
    }

    public void setPurchasedItemStock(PurchasedItemStock purchasedItemStock) {
        this.purchasedItemStock = purchasedItemStock;
    }

    @Override
    public String toString() {
        return "SupplierBills{" +
                ", supplierName='" + supplierName + '\'' +
                ", supplierMobile='" + supplierMobile + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}