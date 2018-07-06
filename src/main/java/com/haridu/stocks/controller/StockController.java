package com.haridu.stocks.controller;

import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.entity.StockSummary;
import com.haridu.stocks.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping
    public @ResponseBody Iterable<Stock> getAll(){
        return stockRepository.findAll();
    }

    @GetMapping("/{company}/{date}")
    public @ResponseBody StockSummary stockSummary(){

        StockSummary stockSummary = new StockSummary();
        stockSummary.setHighestPrice(5000);
        stockSummary.setLowestPrice(20);
        stockSummary.setTotalVolume(123000);

        return stockSummary;
    }

}
