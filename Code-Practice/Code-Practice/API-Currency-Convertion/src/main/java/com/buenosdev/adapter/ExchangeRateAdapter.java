package com.buenosdev.adapter;

import com.buenosdev.exception.ExternalServiceUnavailableException;
import com.buenosdev.gateway.ExchangeRateGateway;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class ExchangeRateAdapter implements ExchangeRateGateway {
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 1000; // 1 second

    // exponentialBackoffMultiplier=2
    // enableExponentialBackoff=true

    @Override
    public BigDecimal getExchangeRate(String originalCurrency, String targetCurrency) throws ExternalServiceUnavailableException {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try {
                // Call to the actual ExchangeCurrencyAPI
                return callExchangeCurrencyAPI(originalCurrency, targetCurrency);
            } catch (ExternalServiceUnavailableException e) {
                attempt++;
                if (attempt >= MAX_RETRIES) {
                    throw new ExternalServiceUnavailableException("Failed to get exchange rate after " + MAX_RETRIES + " attempts", e);
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new ExternalServiceUnavailableException("Retry interrupted", ie);
                }
            }
        }
        throw new ExternalServiceUnavailableException("Failed to get exchange rate");
    }

    private BigDecimal callExchangeCurrencyAPI(String originalCurrency, String targetCurrency) throws ExternalServiceUnavailableException {
        // Simulate the call to the external API
        // Replace this with actual API call logic
        // If the API is unavailable, throw ExternalServiceUnavailableException
        throw new ExternalServiceUnavailableException("Simulated API unavailability");
    }
}
