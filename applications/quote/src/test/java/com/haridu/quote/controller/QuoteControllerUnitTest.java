package com.haridu.quote.controller;

import com.haridu.quote.config.SecurityConfiguration;
import com.haridu.quote.entity.Quote;
import com.haridu.quote.entity.Symbol;
import com.haridu.quote.repository.QuoteRepository;
import com.haridu.quote.service.QuoteService;
import com.haridu.quote.service.SymbolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SecurityConfiguration.class, QuoteController.class})
@WebMvcTest()
public class QuoteControllerUnitTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuoteService quoteService;

    @MockBean
    private QuoteRepository quoteRepository;

    @MockBean
    private SymbolService symbolService;

    @InjectMocks
    private QuoteController quoteController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadDataPath() throws Exception {

        List<Quote> quoteList = new ArrayList<>();

        Quote quote = new Quote();
        quote.setPrice(200.11);

        Quote quote1 = new Quote();
        quote1.setVolume(2000);

        quoteList.add(quote);
        quoteList.add(quote1);

        when(quoteService.saveJsonToDatabase()).thenReturn(quoteList);

        mockMvc
                .perform(post("/quotes/load"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string("Success!"))
                .andReturn();
    }

    @Test
    public void testGetQuote() throws Exception {

//        ResponseEntity<Symbol> symbolResponseEntity = new ResponseEntity<>(HttpStatus.OK);
//        when(symbolService.getIdforSymbol(any())).thenReturn(symbolResponseEntity);
//
//        List<Quote> quoteList = new ArrayList<>();
//        Quote quote = new Quote();
//        quote.setVolume(3000);
//        quoteList.add(quote);
//        when(quoteRepository.findAllBySymbol(any(Long.class))).thenReturn(quoteList);
//
//        mockMvc
//            .perform(get("/quotes/symbol/AAPL"))
//            .andExpect(status().is2xxSuccessful())
//            .andReturn();

    }
}
