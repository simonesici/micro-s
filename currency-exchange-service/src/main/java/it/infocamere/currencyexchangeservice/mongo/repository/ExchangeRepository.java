package it.infocamere.currencyexchangeservice.mongo.repository;

import it.infocamere.currencyexchangeservice.mongo.model.ExchangeValue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ExchangeRepository extends MongoRepository<ExchangeValue, String> {

    @Query(value = "{ 'from' :'?0', 'to' : '?1'}")
    ExchangeValue findByFromAndTo(String from,String to);

    long count();

}
