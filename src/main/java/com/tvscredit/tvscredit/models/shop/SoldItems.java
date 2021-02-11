package com.tvscredit.tvscredit.models.shop;

import com.tvscredit.tvscredit.models.person.ShopCustomer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
public class SoldItems {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime timeOfSell;

    @ManyToOne
    private Shop shop;

    @OneToOne(cascade = CascadeType.ALL)
    private ShopCustomer shopCustomer;

    @ElementCollection
    private Set<SoldItemsDetail> soldItems;

    private String invoiceImageUrl;

    public String getInvoiceImageUrl() {
        return invoiceImageUrl;
    }

    public void setInvoiceImageUrl(String invoiceImageUrl) {
        this.invoiceImageUrl = invoiceImageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeOfSell() {
        return timeOfSell;
    }

    public void setTimeOfSell(LocalDateTime timeOfSell) {
        this.timeOfSell = timeOfSell;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ShopCustomer getShopCustomer() {
        return shopCustomer;
    }

    public void setShopCustomer(ShopCustomer shopCustomer) {
        this.shopCustomer = shopCustomer;
    }

    public Set<SoldItemsDetail> getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(Set<SoldItemsDetail> soldItems) {
        this.soldItems = soldItems;
    }

    public void setSoldItemsUsingList(List<SoldItemsDetail> soldItems) {
        this.soldItems = new HashSet<>(soldItems);
    }
}
