package com.buenosdev.entity.inheritance;

import com.buenosdev.entity.PaymentType;

import java.math.BigDecimal;

public class PayPalPayment extends Payment {
    private String emailId;
    private String password;

    public PayPalPayment(BigDecimal amount, String emailId, String password) {
        super(amount);
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAYPAL;
    }

    // Getters for PayPal details
}