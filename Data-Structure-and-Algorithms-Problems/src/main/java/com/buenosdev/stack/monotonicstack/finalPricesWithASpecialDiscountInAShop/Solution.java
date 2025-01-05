package com.buenosdev.stack.monotonicstack.finalPricesWithASpecialDiscountInAShop;

import java.util.ArrayDeque;

class Solution {
    public int[] finalPrices(int[] prices) {

        var stack = new ArrayDeque<Integer>();

        var result = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                var topStack = prices[stack.peek()];
                result[i] = prices[i] - topStack;
            } else {
                result[i] = prices[i];
            }

            stack.push(i);
        }
        return result;
    }
}