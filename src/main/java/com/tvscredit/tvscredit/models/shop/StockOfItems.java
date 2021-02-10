package com.tvscredit.tvscredit.models.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tvscredit.tvscredit.models.enums.Unit;

import javax.persistence.Embeddable;

@Embeddable
public class StockOfItems {

    private String name;

    private Double pricePerUnit;

    private Unit unit;

    private Double quantity;

    private String category;

    @JsonIgnore
    private Double totalValue;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
