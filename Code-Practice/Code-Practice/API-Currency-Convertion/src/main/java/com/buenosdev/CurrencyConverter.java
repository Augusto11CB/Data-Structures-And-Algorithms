/*
package com.buenosdev;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {
    public BigDecimal getExchangeRate(String fromCurrency, String toCurrency) {
        // Example: Return a hard-coded exchange rate for demonstration
        return new BigDecimal("5.25"); // 1 USD = 5.25 BRL
    }

    public BigDecimal convert(BigDecimal amount, BigDecimal exchangeRate) {
        return amount.multiply(exchangeRate).setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        BigDecimal exchangeRate = converter.getExchangeRate("USD", "BRL");
        BigDecimal amountInUSD = new BigDecimal("100.00");
        BigDecimal amountInBRL = converter.convert(amountInUSD, exchangeRate);

        System.out.println("Exchange Rate: " + exchangeRate);
        System.out.println("Amount in USD: " + amountInUSD);
        System.out.println("Amount in BRL: " + amountInBRL);
    }
}
*/
