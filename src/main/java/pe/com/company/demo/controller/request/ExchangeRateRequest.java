package pe.com.company.demo.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRateRequest {

    private Double amount;
    private String currencyIsoSource;
    private String currencyIsoTarget;
}
