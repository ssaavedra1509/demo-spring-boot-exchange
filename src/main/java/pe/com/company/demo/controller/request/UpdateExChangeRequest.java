package pe.com.company.demo.controller.request;

import lombok.Data;

@Data
public class UpdateExChangeRequest {

    private String currencyIsoSource;
    private String currencyIsoTarget;
    private Double exchangeRate;
}
