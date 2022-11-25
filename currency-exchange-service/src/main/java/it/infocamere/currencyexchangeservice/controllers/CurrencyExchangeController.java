package it.infocamere.currencyexchangeservice.controllers;

import it.infocamere.currencyexchangeservice.mongo.model.ExchangeValue;
import it.infocamere.currencyexchangeservice.mongo.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    ExchangeRepository exchangeRepo;

    @GetMapping("/currency-exchange/save/from/{from}/to/{to}/conversion/{conversion}")
    public ExchangeValue saveRetrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable String conversion)  //from map to USD and to map to INR
    {
        ExchangeValue exchangeValue= new ExchangeValue(from, to, BigDecimal.valueOf(Long.parseLong(conversion)));
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        exchangeRepo.save(exchangeValue);

        return exchangeValue;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)  //from map to USD and to map to INR
    {
        ExchangeValue exchangeValue= exchangeRepo.findByFromAndTo(from,to);
        return exchangeValue;
    }
}
