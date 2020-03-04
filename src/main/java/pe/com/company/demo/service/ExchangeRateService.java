package pe.com.company.demo.service;


import pe.com.company.demo.controller.request.ExchangeRateRequest;
import pe.com.company.demo.controller.request.UpdateExChangeRequest;
import pe.com.company.demo.controller.response.ExchangeRateResponse;
import pe.com.company.demo.entity.ExchangeRate;

import java.util.List;

public interface ExchangeRateService {

    ExchangeRateResponse converter(ExchangeRateRequest exchangeRateRequest);

    void updateChange(UpdateExChangeRequest updateExChangeRequest);

    List<ExchangeRate> findAll();
}
