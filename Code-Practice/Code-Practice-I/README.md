# Exercise 1: Strategy Pattern
**Task:** Implement a payment system using the Strategy pattern. The system should support multiple payment methods such as credit card, PayPal, and Bitcoin. Each payment method should be implemented as a separate strategy.

**Requirements:**
- Define an interface `PaymentStrategy` with a method `pay(amount)`.
- Implement concrete strategies for `CreditCardPayment`, `PayPalPayment`, and `BitcoinPayment`.
- Create a `ShoppingCart` class that uses a `PaymentStrategy` to process payments.