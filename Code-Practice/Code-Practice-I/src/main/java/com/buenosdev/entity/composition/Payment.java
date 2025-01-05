package com.buenosdev.entity.composition;

import com.buenosdev.entity.Currency;
import com.buenosdev.entity.PaymentStatus;
import com.buenosdev.entity.PaymentType;

import java.math.BigDecimal;
import java.util.UUID;

public class Payment {

    private UUID id;

    private final BigDecimal amount;

    private final Currency currency;

    private final PaymentType type;

    private PaymentStatus status;

    private CreditCardDetails creditCardDetails;

    private PayPalDetails payPalDetails;

    private BitcoinDetails bitcoinDetails;

    public Payment(UUID id, BigDecimal amount, Currency currency, PaymentType type, PaymentStatus status, CreditCardDetails creditCardDetails) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.status = status;
        this.creditCardDetails = creditCardDetails;
    }

    public Payment(UUID id, BigDecimal amount, Currency currency, PaymentType type, PaymentStatus status, BitcoinDetails bitcoinDetails) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.status = status;
        this.bitcoinDetails = bitcoinDetails;
    }

    public Payment(UUID id, BigDecimal amount, Currency currency, PaymentType type, PaymentStatus status, PayPalDetails payPalDetails) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.status = status;
        this.payPalDetails = payPalDetails;
    }

    public UUID getId() {
        return this.id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public PaymentType getType() {
        return type;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
