package com.haridu.quote.controller;

import com.haridu.quote.entity.DailySummary;
import com.haridu.quote.entity.Quote;
import com.haridu.quote.entity.Symbol;
import com.haridu.quote.repository.QuoteRepository;
import com.haridu.quote.service.QuoteService;
import com.haridu.quote.service.SymbolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @Autowired
    QuoteRepository quoteRepository;

    @Autowired
    SymbolService symbolService;

    @PostMapping("/load")
    public @ResponseBody String loadData(){
        Iterable<Quote> result = quoteService.saveJsonToDatabase();

        if (result != null) {
            return "Success!";
        }
        return "Failure!";
    }

    @GetMapping("/{symbol}")
    public ResponseEntity getQuote(@PathVariable(name = "symbol") String symbol) {

        ResponseEntity<Symbol> response = symbolService.getIdforSymbol(symbol);
        if(response.getStatusCode().is2xxSuccessful()){
            Iterable<Quote> quotes= quoteRepository.findAllBySymbol(response.getBody().getId());
            return ResponseEntity.ok().body(quotes);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{symbol}/{date}")
    public ResponseEntity getQuoteByDay(@PathVariable (name = "symbol") String symbol,
                                        @PathVariable (name = "date") Date date) {

        ResponseEntity<Symbol> response = symbolService.getIdforSymbol(symbol);

        if(response.getStatusCode().is2xxSuccessful()){

            long symbolId = response.getBody().getId();
            DailySummary dailySummary = quoteRepository.dailySummary(symbolId, date);

            return ResponseEntity.ok(dailySummary);
        }
        return ResponseEntity.badRequest().build();
    }
}
