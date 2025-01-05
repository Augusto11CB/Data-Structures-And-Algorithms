package com.buenosdev.gateway;

import com.buenosdev.exception.ExternalServiceUnavailableException;

import java.math.BigDecimal;

public interface ExchangeRateGateway {
    BigDecimal getExchangeRate(String originalCurrency, String targetCurrency) throws ExternalServiceUnavailableException;
}
