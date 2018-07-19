package com.haridu.stocks.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haridu.stocks.StockSummary;
import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.repository.StockRepository;
import com.haridu.stocks.repository.StockSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockSummaryRepository stockSummaryRepository;

    public Iterable<Stock> saveJsonToDatabase() {

        ObjectMapper mapper = new ObjectMapper();
        List<Stock> stockData = null;
        File file = null;
        try {
            file = new ClassPathResource("week2-stocks.json").getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            stockData = mapper.readValue(file, new TypeReference<List<Stock>>(){});
            System.out.println("Reading from input stream completed");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterable<Stock> result = stockRepository.saveAll(stockData);

        return result;
    }

    public Iterable<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    public StockSummary summaryForDay(String company, String date ){
        return stockSummaryRepository.stockSummaryByDay(company, Date.valueOf(date));
    }
}
