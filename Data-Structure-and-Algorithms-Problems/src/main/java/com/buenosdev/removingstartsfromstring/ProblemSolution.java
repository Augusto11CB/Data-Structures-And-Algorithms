package com.buenosdev.removingstartsfromstring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 9: Removing Stars From a String

    /*
    Given a string s, where * represents a star. We can remove a star along with its closest non-star character to its left in a single operation.
        The task is to perform as many such operations as possible until all stars have been removed and return the resultant string.
    **/

    /*
    Example 1
    Input: "abc*de*f"
    Expected Output: "abdf"
    Description: We remove c along with * to get "abde*f", then remove e along with * to get "abdf"

    Example 2
    Input: "a*b*c*d"
    Expected Output: "d"
    Description: We remove a along with * to get "b*c*d", then remove b with * to get "c*d", then remove c with * to get "d".

    Example 3
    Input: "abcd"
    Expected Output: "abcd"
    Description: As there is no *, the string remains the same.
     * */


    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();
        System.out.println(solution.removeStars("abc*de*f"));  // Output: "abdf"
        System.out.println(solution.removeStars("a*b*c*d"));  // Output: "d"
        System.out.println(solution.removeStars("abcd"));  // Output: "abcd"
    }

    public String removeStars(String str) {
        var tmpStack = new Stack<Character>();
        for (Character character : str.toCharArray()) {
            if (character == '*' && !tmpStack.empty()) {
                tmpStack.pop();
            } else if (character != '*') {
                tmpStack.add(character);
            }
        }

        var sb = new StringBuilder();
        while (!tmpStack.empty()) {
            sb.insert(0, tmpStack.pop());
        }

        return sb.toString();

        /*
        Time Complexity: O(n)
        - This is because it is performed a single pass over the string.

        Space Complexity: O(n)
        -  In the worst case, if there are no stars, the stack will contain all the characters of the string.
        */
    }


}
