package com.haridu.quote.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.haridu.quote.entity.Quote;
import com.haridu.quote.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    public Iterable<Quote> saveJsonToDatabase() {

        ObjectMapper mapper = new ObjectMapper();
        List<Quote> quoteList = null;
        File file = null;

        try {
            file = new ClassPathResource("week4_stocks.json").getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            quoteList = mapper.readValue(file, new TypeReference<List<Quote>>(){});
            System.out.println("Reading from json input completed successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return quoteRepository.saveAll(quoteList);
    }
}
