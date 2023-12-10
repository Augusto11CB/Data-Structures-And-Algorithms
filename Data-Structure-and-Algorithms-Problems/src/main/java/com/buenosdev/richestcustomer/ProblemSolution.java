package com.buenosdev.richestcustomer;

class ProblemSolution {

    // (Matrix) Problem 1: Richest Customer Wealth

    /*
    The task revolves around determining the richest individual from a set of bank customers. Imagine every customer has
    multiple bank accounts, with each account holding a certain amount of money. The total wealth of a customer is calculated
    by summing all the money across their multiple accounts.

    Given a 2D-array, where each sub-array represents different accounts of a customer and contains integers representing
    the money in each account, find the maximum wealth among all customers.
    * */

    /*
    Example 1:
    Input: [[5,2,3],[0,6,7]]
    Expected Output: 13
    Justification: The total wealth of the first customer is 10 and of the second customer is 13. So, the output is 13
    as it's the maximum among all customers.
    * */

    public static int maximumWealth(int[][] accounts) {
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
}
/*
Time Complexity:
 - O(n*m): The algorithm traverses through all the customers and their respective accounts once.

Space Complexity:
 - O(1)
*/