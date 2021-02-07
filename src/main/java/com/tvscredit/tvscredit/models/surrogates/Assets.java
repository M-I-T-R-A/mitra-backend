package com.tvscredit.tvscredit.models.surrogates;

import javax.persistence.Embeddable;

@Embeddable
public class Assets {
    private String name;
    private Double value;
    private Double rateOfReturn;
    private String Liquidity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(Double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public String getLiquidity() {
        return Liquidity;
    }

    public void setLiquidity(String liquidity) {
        Liquidity = liquidity;
    }
}
