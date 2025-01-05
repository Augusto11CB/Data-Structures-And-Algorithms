package com.buenosdev.entity.inheritance;

import com.buenosdev.entity.PaymentStatus;
import com.buenosdev.entity.PaymentType;

import java.math.BigDecimal;

public abstract class Payment {
    private BigDecimal amount;
    private PaymentStatus status;

    public Payment(BigDecimal amount) {
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public abstract PaymentType getPaymentType();
}
