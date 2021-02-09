package com.tvscredit.tvscredit.dto.shop;

import com.tvscredit.tvscredit.models.shop.PurchasedItemBill;
import com.tvscredit.tvscredit.models.shop.StockOfItems;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PurchasedItemStockDTO {

    private PurchasedItemBill purchasedItemBill;

    private Date dateOfPurchase;

    private List<StockOfItems> stockOfItems;

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

    public List<StockOfItems> getStockOfItems() {
        return stockOfItems;
    }

    public void setStockOfItems(List<StockOfItems> stockOfItems) {
        this.stockOfItems = stockOfItems;
    }

    public void setStockOfItems(Set<StockOfItems> stockOfItems) {
        this.stockOfItems = new ArrayList<>(stockOfItems);
    }
}
