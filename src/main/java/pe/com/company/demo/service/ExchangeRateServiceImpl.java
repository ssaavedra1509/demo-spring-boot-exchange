package pe.com.company.demo.service;


import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.company.demo.controller.request.ExchangeRateRequest;
import pe.com.company.demo.controller.request.UpdateExChangeRequest;
import pe.com.company.demo.controller.response.ExchangeRateResponse;
import pe.com.company.demo.entity.ExchangeRate;
import pe.com.company.demo.repository.ExchangeRateRepository;

import java.util.List;

@Service
@Builder
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public ExchangeRateServiceImpl(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public ExchangeRateResponse converter(ExchangeRateRequest exchangeRateRequest) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByCurrencyIsoSourceAndCurrencyIsoTarget(exchangeRateRequest.getCurrencyIsoSource(),
                exchangeRateRequest.getCurrencyIsoTarget());

        Double amountWithChange = "PEN".equals(exchangeRateRequest.getCurrencyIsoSource())?
                exchangeRateRequest.getAmount() / exchangeRate.getChange():
                exchangeRateRequest.getAmount() * exchangeRate.getChange();

        return ExchangeRateResponse.builder()
                .amount(exchangeRateRequest.getAmount())
                .amountWithExchangeRate(amountWithChange)
                .currencyIsoSource(exchangeRateRequest.getCurrencyIsoSource())
                .currencyIsoTarget(exchangeRateRequest.getCurrencyIsoTarget())
                .exchangeRate(exchangeRate.getChange())
                .build();

    }

    @Override
    public void updateChange(UpdateExChangeRequest updateExChangeRequest) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByCurrencyIsoSourceAndCurrencyIsoTarget(updateExChangeRequest.getCurrencyIsoSource(),
                updateExChangeRequest.getCurrencyIsoTarget());

        exchangeRate.setChange(updateExChangeRequest.getExchangeRate());
        exchangeRateRepository.save(exchangeRate);
    }

    @Override
    public List<ExchangeRate> findAll() {
        return exchangeRateRepository.findAll();
    }
}