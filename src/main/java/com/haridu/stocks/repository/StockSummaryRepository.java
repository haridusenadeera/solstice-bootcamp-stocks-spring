package com.haridu.stocks.repository;

import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.entity.StockSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockSummaryRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT MAX(stock.price) AS highestPrice, MIN(stock.price) AS lowestPrice, SUM(stock.volume) AS totalVolume "
            + "FROM Stock stock WHERE stock.symbol = ?1 AND stock.date = ?2")
    StockSum stockSummaryByDay(String company, Date date);

//    @Query("SELECT stock from Stock stock where stock.symbol = ?1")
//    List<Stock> find(String symbol);

    public static interface StockSum {
        double getHighestPrice();
        double getLowestPrice();
        int getTotalVolume();
    }
}

