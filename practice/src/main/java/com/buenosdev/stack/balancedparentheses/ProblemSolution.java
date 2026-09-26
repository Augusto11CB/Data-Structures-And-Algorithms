package com.buenosdev.stack.balancedparentheses;

import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 1:  Balanced Parentheses

    /*
    The "Balanced Parentheses" problem requires you to determine if a given string of parentheses is balanced. A string
    of parentheses is considered balanced if every opening parenthesis has a corresponding closing parenthesis in the correct order.
     * */

    /*
    Example 1:

    Input: String s = "{[()]}";
    Expected Output: true
    Explanation: The parentheses in this string are perfectly balanced. Every opening parenthesis '{', '[', '(' has a corresponding closing parenthesis '}', ']', ')' in the correct order. The stack will eventually be empty after the complete traversal of the string, indicating the string is balanced.

    Example 2:
    Input: string s = "{[}]";
    Expected Output: false
    Explanation: The brackets are not balanced in this string. Although it contains the same number of opening and closing brackets for each type, they are not correctly ordered. The ']' closes '[' before '{' can be closed by '}', and similarly, '}' closes '{' before '[' can be closed by ']'. Hence, the string is not balanced, and the function should return false.

    Example 3:
    Input: String s = "(]";
    Expected Output: false
    Explanation: The parentheses in this string are not balanced. Here, ')' does not have a matching opening parenthesis '(', and similarly, ']' does not have a matching opening bracket '['. So the function should return false.
     * */
    public static void main(String[] args) {
        ProblemSolution bp = new ProblemSolution();

        // Test cases to verify the solution
        String test1 = "{[()]}";
        String test2 = "{[}]";
        String test3 = "(]";
        String test4 = "()[]{}";

        System.out.println("Test 1: " + bp.isValid(test1));
        System.out.println("Test 2: " + bp.isValid(test2));
        System.out.println("Test 3: " + bp.isValid(test3));
        System.out.println("Test 4: " + bp.isValid(test4));
    }

    public boolean isValid(String s) {
        var charArray = s.toCharArray();
        var stackOfChars = new Stack<Character>();

        if (charArray.length > 0) {
            stackOfChars.push(charArray[0]);
        }

        for (int i = 1; i < charArray.length; i++) {
            var c = charArray[i];
            if (stackOfChars.empty()) {
                stackOfChars.push(c);
                continue;
            }
            var auxChar = stackOfChars.peek();

            if (auxChar == '(' && c == ')') {
                stackOfChars.pop();
            } else if (c == '}' && auxChar == '{') {
                stackOfChars.pop();
            } else if (c == ']' && auxChar == '[') {
                stackOfChars.pop();
            } else {
                stackOfChars.push(c);
            }

        }

        return stackOfChars.empty();
    }

    public boolean isValidV2(String s) {
        var stack = new Stack<Character>();

        // Iterating through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is an opening parenthesis, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty and we have a closing parenthesis, the string is not balanced
                // Input Example: ')]}'
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top character from the stack
                char top = stack.pop();
                // If the character is a closing parenthesis, check whether
                // it corresponds to the most recent opening parenthesis
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening parentheses had a corresponding closing match
        return stack.isEmpty();
    }
}
/*
Time Complexity:
 - O(n): The time complexity of this algorithm is O(n), where n is the length of the string. This is because we're
  processing each character in the string exactly once.

Space Complexity:
 - O(n): in the worst-case scenario when all the characters in the string are opening parentheses, so we push each character
  onto the Stack.
*/