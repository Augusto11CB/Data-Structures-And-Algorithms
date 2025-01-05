package com.buenosdev.payment;

import com.buenosdev.entity.composition.Payment;
import com.buenosdev.entity.PaymentType;

public interface PaymentStrategy {

    Payment pay(Payment payment);

    PaymentType getPaymentTypeStrategy();
}
