package com.tvscredit.tvscredit.models.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
public class PurchasedItemStock {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToOne
    private PurchasedItemBill purchasedItemBill;

    private Date dateOfPurchase;

    @ManyToOne
    private Shop shop;

    @ElementCollection
    private Set<StockOfItems> stockOfItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PurchasedItemBill getPurchasedItemBill() {
        return purchasedItemBill;
    }

    public void setPurchasedItemBill(PurchasedItemBill purchasedItemBill) {
        this.purchasedItemBill = purchasedItemBill;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Set<StockOfItems> getStockOfItems() {
        return stockOfItems;
    }

    public void setStockOfItems(Set<StockOfItems> stockOfItems) {
        this.stockOfItems = stockOfItems;
    }

    public void setStockOfItemsUsingList(List<StockOfItems> stockOfItems) {
        this.stockOfItems = new HashSet<>(stockOfItems);
    }
}
