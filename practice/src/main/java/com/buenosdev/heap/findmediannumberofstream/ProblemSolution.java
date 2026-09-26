package com.buenosdev.heap.findmediannumberofstream;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProblemSolution {

    // (Heap) Problem 4: Minimum Cost to Connect Sticks

    /*
     https://leetcode.com/problems/find-median-from-data-stream/description/
     **/

    /*
     * */


    // Assume ‘x’ is the median of a list.
    // This means that half of the numbers in the list will be smaller than (or equal to) ‘x’
    // The other half will be greater than (or equal to) ‘x’.

    // We can split the list into two parts: one for the smaller numbers (smallNumList) one for the bigger numbers (largeNumList).
    // The middle number will either be the biggest number in the smallNumList or the smallest number in the largeNumList.
    // If there are an even number of elements, the middle number will be the average of these two numbers.
    private Queue<Integer> maxHeapSmallNumList;
    private Queue<Integer> minHeapLargeNumList;

    public ProblemSolution() {
        maxHeapSmallNumList = new PriorityQueue<Integer>((a, b) -> b - a);
        minHeapLargeNumList = new PriorityQueue<Integer>();
    }

    public void insertNum(int num) {
        if (maxHeapSmallNumList.isEmpty() || num <= maxHeapSmallNumList.peek()) {
            maxHeapSmallNumList.add(num);
        } else {
            minHeapLargeNumList.add(num);
        }

        rebalanceHeaps();
    }

    private void rebalanceHeaps() {
        if (maxHeapSmallNumList.size() > minHeapLargeNumList.size() + 1) {
            minHeapLargeNumList.add(maxHeapSmallNumList.remove());
        } else if (minHeapLargeNumList.size() > maxHeapSmallNumList.size()) {
            maxHeapSmallNumList.add(minHeapLargeNumList.remove());
        }
    }

    public void insertNumOld(int num) {
        if (maxHeapSmallNumList.isEmpty()) {
            maxHeapSmallNumList.add(num);
        } else if (num <= maxHeapSmallNumList.peek()) {
            maxHeapSmallNumList.add(num);
            if (maxHeapSmallNumList.size() > minHeapLargeNumList.size() + 1) {
                minHeapLargeNumList.add(maxHeapSmallNumList.remove());
            }
        } else {
            minHeapLargeNumList.add(num);
            if (minHeapLargeNumList.size() > maxHeapSmallNumList.size()) {
                maxHeapSmallNumList.add(minHeapLargeNumList.remove());
            }
        }
    }

    public double findMedian() {
        if ((maxHeapSmallNumList.size() + minHeapLargeNumList.size()) % 2 != 0) {
            return maxHeapSmallNumList.peek();
        } else {
            var fromMax = maxHeapSmallNumList.peek();
            var fromMin = minHeapLargeNumList.peek();

            return (fromMax + fromMin) / 2.0;
        }
    }

       /*
        Time Complexity:
        - insertNum(): O(logN)
        - findMedian(): O(1)

        Space Complexity: O(n)

        */


    public static void main(String[] args) {
        ProblemSolution medianOfAStream = new ProblemSolution();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
