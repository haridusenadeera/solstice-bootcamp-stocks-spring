package com.haridu.quote.service;

import com.haridu.quote.entity.Symbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SymbolService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<Symbol> getIdforSymbol(String symbol){
        String url = "//symbol/symbols/search/findBySymbol?symbol=" + symbol;
        ResponseEntity<Symbol> response = restTemplate.getForEntity(url, Symbol.class);
        return response;
    }
}
