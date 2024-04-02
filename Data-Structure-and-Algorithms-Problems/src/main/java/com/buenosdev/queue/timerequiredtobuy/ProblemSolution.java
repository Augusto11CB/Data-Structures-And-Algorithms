package com.buenosdev.queue.timerequiredtobuy;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;

public class ProblemSolution {


    /*
    https://leetcode.com/problems/time-needed-to-buy-tickets
     **/

    /*
     * */
    public static void main(String[] args) {

        var problemSolution = new ProblemSolution();

    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        var queue = new LinkedList<SimpleEntry<Integer, Integer>>();

        var kcount = 0;
        for (int i = 0; i < tickets.length; i++) {
            queue.add(new SimpleEntry<>(i, tickets[i]));

            if (i == k) {
                kcount = tickets[i];
            }

        }

        var count = 0;
        while (kcount > 0) {
            var firstElemQueue = queue.poll();
            count = count + 1;

            firstElemQueue.setValue(firstElemQueue.getValue() - 1);

            if (firstElemQueue.getKey() == k) {
                kcount = kcount - 1;
            }

            if (firstElemQueue.getValue() != 0) {
                queue.add(firstElemQueue);
            }


        }

        return count;

    }

    public int timeRequiredToBuy2(int[] tickets, int k) {
        int result = 0;

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                result = result + Math.min(tickets[k], tickets[i]);
            } else {
                // For any value that comes after index K and is greater than the value in tickets[k], we will use tickets[k] instead of tickets[i]. This is because we can buy all tickets for K without needing to wait for i (where i > k) to buy the same amount as K.
                result = result + Math.min(tickets[k] - 1, tickets[i]);
            }
        }

        return result;
    }
}