package com.haridu.quote.repository;

import com.haridu.quote.entity.DailySummary;
import com.haridu.quote.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.sql.Date;

@RepositoryRestResource
public interface QuoteRepository extends JpaRepository<Quote, Long> {
    Iterable<Quote> findAllBySymbol(long symbol);

    @Query("SELECT MAX(quote.price) AS highestPrice, MIN(quote.price) AS lowestPrice, SUM(quote.volume) AS totalVolume "
            + "FROM Quote quote WHERE quote.symbol = ?1 AND quote.date = ?2")
    DailySummary dailySummary(long id, Date date);
}
