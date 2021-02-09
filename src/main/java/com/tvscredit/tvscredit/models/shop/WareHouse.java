package com.tvscredit.tvscredit.models.shop;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.Set;

@Embeddable
public class WareHouse {

    private Integer numberOfWareHouses;

    @ElementCollection
    private List<Double> areaOfWareHouses;

    @JsonIgnore
    @ElementCollection
    private Set<StockOfItems> itemsSet;

    @JsonIgnore
    private Double totalValueOfItems;

    public Integer getNumberOfWareHouses() {
        return numberOfWareHouses;
    }

    public void setNumberOfWareHouses(Integer numberOfWareHouses) {
        this.numberOfWareHouses = numberOfWareHouses;
    }

    public List<Double> getAreaOfWareHouses() {
        return areaOfWareHouses;
    }

    public void setAreaOfWareHouses(List<Double> areaOfWareHouses) {
        this.areaOfWareHouses = areaOfWareHouses;
    }

    public Set<StockOfItems> getItemsSet() {
        return itemsSet;
    }

    public void setItemsSet(Set<StockOfItems> itemsSet) {
        this.itemsSet = itemsSet;
    }

    public Double getTotalValueOfItems() {
        return totalValueOfItems;
    }

    public void setTotalValueOfItems(Double totalValueOfItems) {
        this.totalValueOfItems = totalValueOfItems;
    }

    public StockOfItems isItemPresent(StockOfItems stockOfItems){
        for (StockOfItems item:itemsSet){
            if(stockOfItems.getName() == item.getName()){
                return item;
            }
        }
        return null;
    }
}
