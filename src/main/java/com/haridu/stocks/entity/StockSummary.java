package com.haridu.stocks.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockSummary {

    @JsonProperty("highest_price")
    private double highestPrice;

    @JsonProperty("lowest_price")
    private double lowestPrice;

    @JsonProperty("total_volume")
    private int totalVolume;

    public double getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(double highestPrice) {
        this.highestPrice = highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(int totalVolume) {
        this.totalVolume = totalVolume;
    }
}
