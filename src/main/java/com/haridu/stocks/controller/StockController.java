package com.haridu.stocks.controller;

import com.haridu.stocks.StockSummary;
import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.repository.StockRepository;
import com.haridu.stocks.repository.StockSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockSummaryRepository stockSummaryRepository;

    @GetMapping
    public @ResponseBody Iterable<Stock> getAll(){
        return stockRepository.findAll();
    }

    @GetMapping("/{company}/{date}")
    public @ResponseBody StockSummary stockSummary(@PathVariable(value = "company") String company,
                                                @PathVariable(value = "date") String date){

        StockSummary stockSummary = stockSummaryRepository
                .stockSummaryByDay(company, Date.valueOf(date));

        return stockSummary;
    }

}
