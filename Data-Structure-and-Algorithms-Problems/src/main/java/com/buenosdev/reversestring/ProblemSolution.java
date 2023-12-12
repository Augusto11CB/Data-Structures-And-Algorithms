package com.buenosdev.reversestring;

import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 2: Reverse a String

    /*
    Given a string, write a function that uses a stack to reverse the string. The function should return the reversed string.
     * */

    /*
    Example 1:
    Input: "Hello, World!"
    Output: "!dlroW ,olleH"

    Example 2:
    Input: "OpenAI"
    Output: "IANepO"

    Example 3:
    Input: "Stacks are fun!"
    Output: "!nuf era skcatS"
     * */
    public String reverseString(String s) {
        var stack = new Stack<Character>();

        var array = s.toCharArray();

        for (char c : array) {
            stack.push(c);
        }

        var builder = new StringBuilder();

        while (!stack.empty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }
}
/*
Time Complexity:
 - O(n)

Space Complexity:
 - O(n)
*/