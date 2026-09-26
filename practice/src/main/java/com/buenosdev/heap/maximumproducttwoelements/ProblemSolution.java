package com.buenosdev.heap.maximumproducttwoelements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ProblemSolution {

    // (Heap) Problem A: Maximum Product of Two Elements in an Array

    /*
    https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
    **/

    /*
     * */

    public int maxProduct(int[] nums) {
        var myHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i : nums) {
            myHeap.add(i);
        }

        var largestNum = myHeap.remove();
        var secondLargestNum = myHeap.remove();

        return (largestNum - 1) * (secondLargestNum - 1);

    }

       /*
        Time Complexity: O(nlog(n))
        - (1) Converting the given gifts list to a heap is O(n*log(n)):
            - one insertion is O(log(n)).

        Space Complexity: O(n)
        */

    public int maxProductV2(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.maxProduct(new int[]{3, 4, 5, 2}));
        System.out.println(sol.maxProduct(new int[]{1, 5, 4, 5}));
        System.out.println(sol.maxProduct(new int[]{3, 7}));
    }
}