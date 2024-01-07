package com.buenosdev.heap.kthlargest;

import java.util.PriorityQueue;

class ProblemSolution {


    // (Heap) Problem D: 703. Kth Largest Element in a Stream

    /*
    https://leetcode.com/problems/kth-largest-element-in-a-stream/
    **/

    /*

    - Data Structure used: MinHeap
    - Why? The logic is as follows: The exercise asks us to return the Kth largest element.
        - If we maintain a minHeap with the largest K elements, it is going to be 'easy', because when we peek at the root element of the minHeap, it is going to be the Kth largest element.
        - However, while adding, we must ensure that the minHeap only contains K elements. To achieve this, the insertion logic must consider the following:
            - If the heap's root < newElement, then we remove the root and add the newElement (because it is bigger than the Kth (also the smallest number) of the heap).
                - Why do this? Because this way we maintain in the heap only the K largest elements.
    * */

    final PriorityQueue<Integer> minHeap;
    final int k;


    public ProblemSolution(int k, int[] nums) {
        // If we maintain a minHeap with the largest K elements, it is going to be 'easy', because when we peek at the root element of the minHeap, it is going to be the Kth largest element.
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            this.add(n);
        }
    }

    public int add(int val) {
        // If the heap's root < newElement, then we remove the root and add the newElement,
        // because it is bigger than the Kth (also the smallest number) of the heap.
        if (minHeap.size() < k) minHeap.offer(val);
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 8, 2};
        int[] stream = new int[]{3, 5, 10, 9, 4};
        var sol = new ProblemSolution(3, nums);
        for (int num : stream) System.out.print(sol.add(num) + " ");
    }
}