package com.haridu.stocks.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.repository.StockRepository;
import com.haridu.stocks.service.StockService;
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
    StockService stockService;

    @PostMapping("/load")
    public @ResponseBody String load(){

        Iterable<Stock> result = stockService.saveJsonToDatabase();

        if (result != null) {
            return "Success";
        }
        return "Failure";
    }
}
