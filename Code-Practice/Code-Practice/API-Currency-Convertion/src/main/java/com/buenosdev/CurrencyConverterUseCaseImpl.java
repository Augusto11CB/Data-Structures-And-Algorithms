package com.buenosdev;

import com.buenosdev.exception.ExternalServiceUnavailableException;
import com.buenosdev.gateway.ExchangeRateGateway;

import java.math.BigDecimal;

public class CurrencyConverterUseCaseImpl implements CurrencyConverterUseCase {

    private final ExchangeRateGateway exchangeRateGateway;

    public CurrencyConverterUseCaseImpl(ExchangeRateGateway exchangeRateGateway) {
        this.exchangeRateGateway = exchangeRateGateway;
    }

    public BigDecimal convert(BigDecimal amount, String originalCurrency, String targetCurrency) {
        try {
            BigDecimal exchangeRate = exchangeRateGateway.getExchangeRate(originalCurrency, targetCurrency);
            return amount.multiply(exchangeRate);
        } catch (ExternalServiceUnavailableException e) {
            // Log the exception and return a fallback value or error response
            System.err.println("Error: " + e.getMessage());
            // Here you could return a default value or throw a custom exception
            throw new RuntimeException("Currency conversion failed due to external service unavailability");
        }
    }
}



