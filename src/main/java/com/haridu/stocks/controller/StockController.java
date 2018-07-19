package com.haridu.stocks.controller;

import com.haridu.stocks.StockSummary;
import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.repository.StockRepository;
import com.haridu.stocks.repository.StockSummaryRepository;
import com.haridu.stocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/load")
    public @ResponseBody String load(){
        Iterable<Stock> result = stockService.saveJsonToDatabase();

        if (result != null) {
            return "Success";
        }
        return "Failure";
    }

    @GetMapping
    public @ResponseBody Iterable<Stock> getAll() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{company}/{date}")
    public @ResponseBody StockSummary stockSummary(
            @PathVariable(value = "company") String company,
            @PathVariable(value = "date") String date) {

        return stockService.summaryForDay(company, date);
    }

}
