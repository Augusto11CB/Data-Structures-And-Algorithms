package com.buenosdev.payment;

import com.buenosdev.entity.composition.Payment;
import com.buenosdev.entity.PaymentType;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public Payment pay(Payment payment) {
        return null;
    }

    @Override
    public PaymentType getPaymentTypeStrategy() {
        return null;
    }
}
