package pe.com.company.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.company.demo.entity.ExchangeRate;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByCurrencyIsoSourceAndCurrencyIsoTarget(String currencyIsoSource, String currencyIsoTarget);

}
