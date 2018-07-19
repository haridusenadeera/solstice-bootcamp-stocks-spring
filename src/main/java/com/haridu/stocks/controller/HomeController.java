package com.haridu.stocks.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    StockRepository stockRepository;

    @PostMapping("/load")
    public @ResponseBody List<Stock> load(){

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
        
        stockRepository.saveAll(stockData);

        return stockData;
    }
}
