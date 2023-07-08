package com.buenosdev;

import java.util.Collections;
import java.util.List;

public class RichestCustomerWealth {
    public static void main(String[] args) {

    }

    public int maximumWealth(int[][] accounts) {
        int biggestAmount = 0;
        for (int i = 0; i < accounts.length; i++) {
            int clientWealthSum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                clientWealthSum = clientWealthSum + accounts[i][j];
            }
            if (clientWealthSum > biggestAmount) {
                biggestAmount = clientWealthSum;
            }
        }
        return biggestAmount;
    }

    public int maximumWealthV2(int[][] accounts) {
        int biggestAmount = 0;
        for (int[] client : accounts) {
            int clientWealthSum = 0;

            for (int bankAccountMoney : client) {
                clientWealthSum = clientWealthSum + bankAccountMoney;
            }
            biggestAmount = Math.max(clientWealthSum, biggestAmount);
        }
        return biggestAmount;
    }
}