package com.buenosdev.queue.maxofallsubarraysofsizeK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ProblemSolution {

    // (Queue) Problem 6: Max of All Subarrays of Size 'k'

    /*
    https://leetcode.com/problems/sliding-window-maximum/description/
    **/

    /*
    Given an integer array and an integer 'k', design an algorithm to find the maximum for each and every contiguous subarray of size k.

    Examples:

    Input: array = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
    Output: [3, 3, 4, 5, 5, 5, 6]
    Description: Here, subarray 1,2,3 has maximum 3, 2,3,1 has maximum 3, 3,1,4 has maximum 4, 1,4,5 has maximum 5, 4,5,2 has maximum 5, 5,2,3 has maximum 5, and 2,3,6 has maximum 6.

    Input: array = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13], k = 4
    Output: [10, 10, 10, 15, 15, 90, 90]
    Description: Here, the maximum of each subarray of size 4 are 10, 10, 10, 15, 15, 90, 90 respectively.

    Input: array = [1,2,3,4,5], k = 3
    Output: [3, 4, 5]
    Description: Here, the maximum of each subarray of size 3 are 3, 4, 5 respectively.
    * */

    public List<Integer> printMax(int[] arr, int k) {
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            var maxValue = arr[i];
            var j = i;
            var auxK = 1;
            while (j < arr.length && auxK <= k) {
                if (arr[j] > maxValue) {
                    maxValue = arr[j];
                }
                auxK++;
                j++;
            }
            if (i <= arr.length - k) {
                result.add(maxValue);
            } else {
                break;
            }
        }

        return result;
    }

    public int[] printMaxV2(int[] arr, int k) {

        Deque<Integer> deque = new LinkedList<>(); // Guarda os indexes

        int[] result = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {

            // remove smaller numbers in k range as they are useless
            // While the deque is not empty and the last element in the deque is less than or equal to the current element, remove the last element from the deque. This step ensures that the deque contains elements in decreasing order.
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            // remove numbers out of range k
            // Remove the indices from the front of the deque if they are out of the current window (i.e., if the index is less than the current index - 'k').
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.removeFirst();
            }

            // Add the current element's index to the rear of the deque.
            deque.addLast(i);

            if (i - k + 1 >= 0) {
                result[i - k + 1] = arr[deque.peek()];
            }

        }

        return result;
    }


}


