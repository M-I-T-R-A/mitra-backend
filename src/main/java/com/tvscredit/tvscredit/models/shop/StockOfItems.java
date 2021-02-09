package com.tvscredit.tvscredit.models.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tvscredit.tvscredit.models.enums.Unit;

import javax.persistence.Embeddable;

@Embeddable
public class StockOfItems {

    private String Name;

    private Double pricePerUnit;

    private Unit unit;

    private Double quantity;

    @JsonIgnore
    private Double totalValue;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
