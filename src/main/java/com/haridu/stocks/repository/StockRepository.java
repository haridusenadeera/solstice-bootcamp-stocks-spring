package com.haridu.stocks.repository;

import com.haridu.stocks.entity.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
