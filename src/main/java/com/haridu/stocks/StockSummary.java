package com.haridu.stocks;

import com.fasterxml.jackson.annotation.JsonGetter;

public interface StockSummary {
    @JsonGetter("highest_price")
    double getHighestPrice();

    @JsonGetter("lowest_price")
    double getLowestPrice();

    @JsonGetter("total_volume")
    int getTotalVolume();
}
