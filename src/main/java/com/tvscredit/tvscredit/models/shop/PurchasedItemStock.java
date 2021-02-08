package com.tvscredit.tvscredit.models.shop;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PurchasedItemStock {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private PurchasedItemBill purchasedItemBill;

    @ManyToOne
    private Shop shop;

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
}
