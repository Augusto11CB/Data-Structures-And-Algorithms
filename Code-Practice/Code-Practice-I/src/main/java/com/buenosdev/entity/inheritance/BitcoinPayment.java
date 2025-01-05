package com.buenosdev.entity.inheritance;

import com.buenosdev.entity.PaymentType;

import java.math.BigDecimal;

public class BitcoinPayment extends Payment {
    private String walletAddress;

    public BitcoinPayment(BigDecimal amount, String walletAddress) {
        super(amount);
        this.walletAddress = walletAddress;
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.BITCOIN;
    }

    // Getters for Bitcoin details
}