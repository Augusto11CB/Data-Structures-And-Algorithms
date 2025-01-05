/*
package com.buenosdev;

import com.buenosdev.entity.composition.Payment;

public class ShoppingCart {
    private Payment purchasePayment;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {

    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        int totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getPrice();
        }
        paymentStrategy.pay(totalAmount);
    }
}

*/
