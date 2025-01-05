package com.buenosdev.payment;

import com.buenosdev.entity.PaymentStatus;
import com.buenosdev.entity.PaymentType;
import com.buenosdev.entity.composition.Payment;
import com.buenosdev.exception.PaymentValidationException;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public Payment pay(Payment payment) {

//        if (!(payment instanceof CreditCardPayment) || !isValidateCreditCardPayment((CreditCardPayment) payment)) {
//            processInvalidPayment(payment);
//        }

        if (!isValidateCreditCardPayment(payment)) {
            processInvalidPayment(payment);
        }
        return processPayment(payment);
    }

    private Payment processPayment(Payment payment) {
        payment.setStatus(PaymentStatus.PENDING);

        return payment;
    }

    private void processInvalidPayment(Payment payment) {
        throw new PaymentValidationException("Invalid Payment Input.");
    }

    private boolean isValidateCreditCardPayment(Payment payment) {


        if (payment == null) return false;

        else if (payment.getType() != getPaymentTypeStrategy()) return false;

        else if (payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) return false;

        // else if(!Currency.isValidCurrency(payment.getCurrency())) return false;

        return true;

    }

    @Override
    public PaymentType getPaymentTypeStrategy() {
        return PaymentType.CREDIT_CARD;
    }
}
