package com.buenosdev.entity.inheritance;

import com.buenosdev.entity.PaymentType;

import java.math.BigDecimal;

// CreditCardPayment.java
public class CreditCardPayment extends Payment {
    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    public CreditCardPayment(BigDecimal amount, String name, String cardNumber, String cvv, String dateOfExpiry) {
        super(amount);
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CREDIT_CARD;
    }

    // Getters for credit card details
}
