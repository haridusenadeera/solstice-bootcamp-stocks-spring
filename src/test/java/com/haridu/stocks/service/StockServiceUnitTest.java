package com.haridu.stocks.service;

import com.haridu.stocks.entity.Stock;
import com.haridu.stocks.repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StockServiceUnitTest {


    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllStocks() {
        Stock mockStock = new Stock();
        mockStock.setPrice(12.00);
        mockStock.setSymbol("GOOG");
        mockStock.setVolume(1000);

        Stock mockStock2 = new Stock();
        mockStock2.setPrice(344.00);
        mockStock2.setSymbol("AMZN");
        mockStock2.setVolume(30000);

        List<Stock> stockist = new ArrayList<>();
        stockist.add(mockStock);
        stockist.add(mockStock2);

        when(stockRepository.findAll()).thenReturn(stockist);

        // test if the method returns an iterable object
        assertThat(stockService.getAllStocks(), instanceOf(Iterable.class));
    }
}
