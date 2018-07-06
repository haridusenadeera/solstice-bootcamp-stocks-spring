package com.haridu.stocks.controller;

import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.entity.StockSummary;
import com.haridu.stocks.repository.StockRepository;
import com.haridu.stocks.repository.StockSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

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
    public @ResponseBody StockSummaryRepository.StockSum stockSummary(@PathVariable(value = "company") String company,
                                                                      @PathVariable(value = "date") String date){

//        StockSummary stockSummary = new StockSummary();
//        stockSummary.setHighestPrice(5000);
//        stockSummary.setLowestPrice(20);
//        stockSummary.setTotalVolume(123000);

        StockSummaryRepository.StockSum stockSummary = stockSummaryRepository
                .stockSummaryByDay(company, Date.valueOf(date));

//        List<Stock> stocks = stockSummaryRepository.find("MSFT");

        return stockSummary;
    }

}
