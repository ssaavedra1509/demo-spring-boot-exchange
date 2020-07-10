package pe.com.company.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import pe.com.company.demo.controller.request.ExchangeRateRequest;
import pe.com.company.demo.controller.response.ExchangeRateResponse;
import pe.com.company.demo.entity.ExchangeRate;
import pe.com.company.demo.repository.ExchangeRateRepository;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeRateServiceImplTests {

    public static final Double AMOUNT_EXPECTED_EUR_TO_PEN = 3655.0;
    public static final Double AMOUNT_EXPECTED_PEN_TO_USD = 155.3134328358209;
    private ExchangeRateRequest exchangeRateRequest;
    private ExchangeRateResponse exchangeRateResponse;
    private ExchangeRateServiceImpl exchangeRateServiceImpl;

    @Mock
    private ExchangeRateRepository exchangeRateRepository;

    @Before
    public void setUp(){
        exchangeRateServiceImpl = ExchangeRateServiceImpl.builder()
                .exchangeRateRepository(exchangeRateRepository)
                .build();
    }

    @Test
    public void convertSuccessEurToPenTest(){
        givenExchangeRateRequest("EUR", "PEN", 850.0);
        givenExchangeRateRepository("EUR", "PEN", 4.3);
        whenConverterSuccess();
        thenConverterSuccess(AMOUNT_EXPECTED_EUR_TO_PEN);

    }

    @Test
    public void convertSuccessPenToUsdTest(){
        givenExchangeRateRequest("PEN", "USD", 520.30);
        givenExchangeRateRepository("PEN", "USD", 3.35);
        whenConverterSuccess();
        thenConverterSuccess(AMOUNT_EXPECTED_PEN_TO_USD);

    }

    private void givenExchangeRateRequest(String isoSource, String isoTarget, Double amount){
        exchangeRateRequest = ExchangeRateRequest.builder()
                .amount(amount)
                .currencyIsoSource(isoSource)
                .currencyIsoTarget(isoTarget)
                .build();
    }

    private void givenExchangeRateRepository(String isoSource, String isoTarget, Double rate){
        Mockito.when(exchangeRateRepository
        .findByCurrencyIsoSourceAndCurrencyIsoTarget(isoSource, isoTarget))
        .thenReturn(ExchangeRate.builder()
                .id((long) 4)
                 .currencyIsoSource(isoSource)
                .currencyIsoTarget(isoTarget)
                .change(rate)
                .build());
    }

    private void whenConverterSuccess(){
        exchangeRateResponse = exchangeRateServiceImpl.converter(exchangeRateRequest);
    }

    private void thenConverterSuccess(Double amountExpected){
        Assert.assertEquals(exchangeRateResponse.getAmountWithExchangeRate(), amountExpected);
    }
}