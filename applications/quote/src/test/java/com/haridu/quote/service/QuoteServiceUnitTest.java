//package com.haridu.quote.service;
//
//import com.haridu.quote.entity.Quote;
//import com.haridu.quote.repository.QuoteRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.instanceOf;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest()
//public class QuoteServiceUnitTest {
//
//    @Mock
//    QuoteRepository quoteRepository;
//
//    @InjectMocks
//    QuoteService quoteService;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testSaveJsonToDatabase() {
//        Quote quote1 = new Quote();
//        quote1.setPrice(120.99);
//        quote1.setVolume(1000);
//
//        Quote quote2 = new Quote();
//        quote2.setPrice(300.22);
//        quote2.setVolume(5000);
//
//        List<Quote> quoteList = new ArrayList<>();
//        quoteList.add(quote1);
//        quoteList.add(quote2);
//
//        assertThat(quoteService.saveJsonToDatabase(), instanceOf(Iterable.class));
//    }
//}
