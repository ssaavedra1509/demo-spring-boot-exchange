package pe.com.company.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.company.demo.controller.request.ExchangeRateRequest;
import pe.com.company.demo.controller.request.UpdateExChangeRequest;
import pe.com.company.demo.controller.response.ExchangeRateResponse;
import pe.com.company.demo.entity.ExchangeRate;
import pe.com.company.demo.service.ExchangeRateService;

import java.util.List;

@RestController
@RequestMapping("/api/exchange")
public class ExChangeRateController {

    private final ExchangeRateService exchangeRateService;

    @Autowired
    public ExChangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @PostMapping("/converter")
    public ExchangeRateResponse converter(@RequestBody ExchangeRateRequest exchangeRateRequest){
        return exchangeRateService.converter(exchangeRateRequest);
    }

    @PutMapping
    public void updateChange(@RequestBody UpdateExChangeRequest updateExChangeRequest){
        exchangeRateService.updateChange(updateExChangeRequest);
    }

    @GetMapping
    public List<ExchangeRate> findAll(){
        return exchangeRateService.findAll();
    }
}