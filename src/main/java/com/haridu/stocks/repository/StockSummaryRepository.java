package com.haridu.stocks.repository;

import com.haridu.stocks.StockSummary;
import com.haridu.stocks.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface StockSummaryRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT MAX(stock.price) AS highestPrice, MIN(stock.price) AS lowestPrice, SUM(stock.volume) AS totalVolume "
            + "FROM Stock stock WHERE stock.symbol = ?1 AND stock.date = ?2")
    StockSummary stockSummaryByDay(String company, Date date);
}

