package com.buenosdev.sortingstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 6: Sorting a Stack

    /*
    Given a stack, sort it using only stack operations (push and pop). You can use an additional temporary stack, but
    you may not copy the elements into any other data structure (such as an array). The values in the stack are to be sorted in descending order, with the largest elements on top.
     * */

    /*
    1. Input: [34, 3, 31, 98, 92, 23]
       Output: [3, 23, 31, 34, 92, 98]

    2. Input: [4, 3, 2, 10, 12, 1, 5, 6]
       Output: [1, 2, 3, 4, 5, 6, 10, 12]

    3. Input: [20, 10, -5, -1]
       Output: [-5, -1, 10, 20]

     * */


    public static void main(String args[]) {
        // Create a new stack called 'input'
        Stack<Integer> input = new Stack<Integer>();

        // Add elements to the 'input' stack
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // Display the original input stack
        System.out.println("Input: " + input);

        // Call the sort method to sort the input stack
        Stack<Integer> sortedOutput = sortStack(input);

        // Display the sorted output stack
        System.out.println("Sorted Output: " + sortedOutput);
    }

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> respStack = new Stack<Integer>();
        Stack<Integer> tmpStack = new Stack<Integer>();

        while (!input.empty()) {
            var i = input.pop();
            if (respStack.empty() || respStack.peek() < i) {
                respStack.add(i);
            } else {
                while (!respStack.empty() || !tmpStack.empty()) {
                    if (!respStack.empty() && respStack.peek() > i) {
                        tmpStack.add(respStack.pop());
                    } else {
                        respStack.add(i);
                        while (!tmpStack.empty()) {
                            respStack.add(tmpStack.pop());
                        }
                        break;
                    }
                }
            }
        }
        return respStack;

        /*
        Time Complexity: O(n³)

        Space Complexity: O(n)
        */
    }

    // TODO - Fazer de uma maneira mais performática, pois está levando O(n³)

}
