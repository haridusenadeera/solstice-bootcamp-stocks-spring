package com.haridu.stocks.repository;

import com.haridu.stocks.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}
