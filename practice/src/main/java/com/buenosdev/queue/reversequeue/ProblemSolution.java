package com.buenosdev.queue.reversequeue;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class ProblemSolution {

    // (Queue) Problem 1: Reverse a Queue

    /*
    Given a queue, return it after reversing its elements.
    **/

    /*
    Input: Queue = [1, 2, 3, 4, 5]
    Output: [5, 4, 3, 2, 1]
    Explanation: The input queue elements are reversed.

    Input: Queue = [10, 20, 30, 40, 50]
    Output: [50, 40, 30, 20, 10]
    Explanation: The input queue elements are reversed.

    Input: Queue = [5, 7, 9]
    Output: [9, 7, 5]
    Explanation: The input queue elements are reversed.
     * */

    public static void main(String[] args) {
        // Initialize the queue and add some elements to it.
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Call the method to reverse the order of elements in the queue.
        Queue<Integer> result = reverseQueue(queue);

        // Print the reversed queue to the console.
        System.out.println("result: " + result);
        System.out.println("queue: " + queue);
    }

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        var tmpStack = new Stack<Integer>();

        for (Integer i : q) {
            tmpStack.add(i);
        }

        var response = new LinkedList<Integer>();

        while (!tmpStack.empty()) {
            response.add(tmpStack.pop());
        }

        return response;


        /*
        Time Complexity: O(n)

        Space Complexity: O(n)
        */
    }


}
