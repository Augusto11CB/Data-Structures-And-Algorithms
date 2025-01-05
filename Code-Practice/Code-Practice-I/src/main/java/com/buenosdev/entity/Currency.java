package com.buenosdev.entity;

public enum Currency {

    BRL,
    USD,
    EUR;


    public static boolean isValidCurrency(final String currency) {
        try {
            Currency.valueOf(currency);
        } catch (final IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

}

