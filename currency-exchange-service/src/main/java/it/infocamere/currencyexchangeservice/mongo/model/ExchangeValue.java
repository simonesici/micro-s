package it.infocamere.currencyexchangeservice.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("ExchangeValue")
public class ExchangeValue {
    @Id
    private String id;

    private String from;

    private String to;

    private BigDecimal conversionMultiple;

    private int port;

    //generating constructor using fields
    public ExchangeValue(String from, String to, BigDecimal conversionMultiple) {
        super();
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
