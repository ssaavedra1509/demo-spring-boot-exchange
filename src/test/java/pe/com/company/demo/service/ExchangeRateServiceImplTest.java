package pe.com.company.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import pe.com.company.demo.controller.request.ExchangeRateRequest;
import pe.com.company.demo.controller.response.ExchangeRateResponse;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateServiceImplTest {

    public static final Double AMOUNT_EXPECTED = 3655.0;
    private ExchangeRateRequest exchangeRateRequest;
    private ExchangeRateResponse exchangeRateResponse;
    private ExchangeRateServiceImpl exchangeRateServiceImpl;

    @Before
    public void setUp(){
        exchangeRateServiceImpl = ExchangeRateServiceImpl.builder().build();
    }

    @Test
    public void convertSuccessTest(){
        givenExchangeRateRequest();
        whenConverterSuccess();
        thenConverterSuccess();

    }

    private void givenExchangeRateRequest(){
        exchangeRateRequest = ExchangeRateRequest.builder()
                .amount(850.0)
                .currencyIsoSource("EUR")
                .currencyIsoTarget("PEN")
                .build();
    }

    private void whenConverterSuccess(){
        exchangeRateResponse = exchangeRateServiceImpl.converter(exchangeRateRequest);
    }

    private void thenConverterSuccess(){
        Assert.assertEquals(exchangeRateResponse.getAmountWithExchangeRate(), AMOUNT_EXPECTED);
    }
}
