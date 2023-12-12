package com.buenosdev.decimalbinaryconversion;

import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 3: Decimal to Binary Conversion

    /*
     Given a positive integer n, write a function that returns its binary equivalent as a string. The function should
     not use any in-built binary conversion function.
     * */

    /*
    Example 1:
    Input: 2
    Output: "10"
    Explanation: The binary equivalent of 2 is 10.

    Example 2:
    Input: 7
    Output: "111"
    Explanation: The binary equivalent of 7 is 111.

    Example 3:
    Input: 18
    Output: "10010"
    Explanation: The binary equivalent of 18 is 10010.
     * */

    public static void main(String[] args) {
        // Test cases to convert decimal numbers to binary
        System.out.println(decimalToBinary(2));   // Output: 10
        System.out.println(decimalToBinary(7));   // Output: 111
        System.out.println(decimalToBinary(18));  // Output: 10010
    }

    public static String decimalToBinary(int num) {
        var sb = new StringBuilder();
        var stack = new Stack<Integer>();
        var q = num;

        while (q > 0) {
            var reminder = q % 2;
            stack.push(reminder);
            q = Math.floorDiv(q, 2);
            //stack.push(q % 2);
            // q /= 2
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
/*
Time Complexity:
 - O(log(n)): It is O(log(n)) due to the division by 2 at each step.

Space Complexity:
 - O(log(n)): because in each step we will be pushing an element on the stack, and there are a total of O(log(n)) steps.
*/