package com.buenosdev.stack.removealladjacentduplicates;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class ProblemSolution {

    // (Stack) Problem 8: Remove All Adjacent Duplicates In String

    /*
    Give a string s and convert it into a valid string.
    A string is considered valid if it does not have any two adjacent duplicate characters. The task is to remove the minimum number of characters from s such that it becomes valid. The removal of characters should be done in a way that no further removals are required.
    **/

    /*
    Example 1
    Input: "abbaca"
    Expected Output: "ca"
    Description: We remove 'b' from "abbaca" to get "aaca", then remove 'a' from "aaca" to get "ca"

    Example 2
    Input: "azxxzy"
    Expected Output: "ay"
    Description: We remove 'x' from "azxxzy" to get "azzy", then remove 'z' from "azzy" to get "ay"

    Example 3
    Input: "abba"
    Expected Output: ""
    Description: We remove 'b' from "abba" to get "aa", then remove 'a' from "aa" to get an empty string
     * */


    public static void main(String args[]) {

    }

    public String removeDuplicates(String str) {
        var tmpStack = new Stack<Character>();

        for (Character character : str.toCharArray()) {
            if (tmpStack.empty()) {
                tmpStack.add(character);
            } else {
                var topStack = tmpStack.peek();
                if (character == topStack) {
                    tmpStack.pop();
                } else {
                    tmpStack.add(character);
                }
            }
        }

        var sb = new StringBuilder();
        while (!tmpStack.empty()) {
            sb.insert(0, tmpStack.pop());
        }

        Deque<Character> dq = new ArrayDeque<>();

        return sb.toString();

        /*
        Time Complexity: O(n)

        Space Complexity: O(n)
        - In the worst case, if there are no adjacent duplicates, the stack will contain all the characters of the string
        */
    }


}
