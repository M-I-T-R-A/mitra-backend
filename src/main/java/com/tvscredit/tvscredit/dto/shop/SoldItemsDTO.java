package com.tvscredit.tvscredit.dto.shop;

import com.tvscredit.tvscredit.models.person.ShopCustomer;
import com.tvscredit.tvscredit.models.shop.SoldItemsDetail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SoldItemsDTO {

    private Long customerId;

    private LocalDateTime timeOfSell;

    private ShopCustomer shopCustomer;

    private List<SoldItemsDetail> soldItems;

    private String invoiceImageUrl;

    public String getInvoiceImageUrl() {
        return invoiceImageUrl;
    }

    public void setInvoiceImageUrl(String invoiceImageUrl) {
        this.invoiceImageUrl = invoiceImageUrl;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getTimeOfSell() {
        return timeOfSell;
    }

    public void setTimeOfSell(LocalDateTime timeOfSell) {
        this.timeOfSell = timeOfSell;
    }

    public ShopCustomer getShopCustomer() {
        return shopCustomer;
    }

    public void setShopCustomer(ShopCustomer shopCustomer) {
        this.shopCustomer = shopCustomer;
    }

    public List<SoldItemsDetail> getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(List<SoldItemsDetail> soldItems) {
        this.soldItems = soldItems;
    }
}
