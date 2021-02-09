package com.tvscredit.tvscredit.models.shop;

import javax.persistence.Embeddable;

@Embeddable
public class SoldItemsDetail extends StockOfItems{

    private Double amountPaid;

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
