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
    private Set<StockOfItems> soldItems;

    private Double amountPaid;

    @Column(columnDefinition="TEXT")
    private String invoiceImageUrl;

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Set<StockOfItems> getSoldItems() {
        return soldItems;
    }

    public void setSoldItems(Set<StockOfItems> soldItems) {
        this.soldItems = soldItems;
    }

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

    public void setSoldItemsUsingList(List<StockOfItems> soldItems) {
        this.soldItems = new HashSet<>(soldItems);
    }
}
