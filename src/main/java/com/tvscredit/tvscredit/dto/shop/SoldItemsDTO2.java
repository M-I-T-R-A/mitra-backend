package com.tvscredit.tvscredit.dto.shop;

import com.tvscredit.tvscredit.models.person.ShopCustomer;

import java.time.LocalDateTime;
import java.util.List;

public class SoldItemsDTO2 {
    private LocalDateTime timeOfSell;

    private ShopCustomer shopCustomer;

    private String invoiceImageUrl;

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

    public String getInvoiceImageUrl() {
        return invoiceImageUrl;
    }

    public void setInvoiceImageUrl(String invoiceImageUrl) {
        this.invoiceImageUrl = invoiceImageUrl;
    }
}
