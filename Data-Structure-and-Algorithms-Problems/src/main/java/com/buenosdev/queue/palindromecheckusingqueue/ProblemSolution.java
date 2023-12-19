package com.buenosdev.queue.palindromecheckusingqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class ProblemSolution {

    // (Queue) Problem 4: Palindrome Check using Queue

    /*
    Given a string, determine if that string is a palindrome using a queue data structure.
    A palindrome is a word, number, phrase, or other sequences of characters that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.
     **/

    /*
    Examples:

    Input: "madam"
    Output: True
    Explanation: The word "madam" reads the same forwards and backwards.

    Input: "openai"
    Output: False
    Explanation: The word "openai" does not read the same forwards and backwards.

    Input: "A man a plan a canal Panama"
    Output: True
    Explanation: The phrase "A man a plan a canal Panama" reads the same forwards and backwards when we ignore spaces and capitalization.
     * */

    public static void main(String[] args) {
        System.out.println(checkPalindrome("no x in nixon"));
        System.out.println(checkPalindrome("hello"));
        System.out.println(checkPalindrome("radar"));
        System.out.println(checkPalindrome("duck"));
        System.out.println(checkPalindrome("car"));
        System.out.println(checkPalindrome("olo"));
    }

    public static boolean checkPalindrome(String s) {
        Queue<Character> queue = new LinkedList<>();
        String stringMod = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        var sArray = stringMod.toCharArray();

        for (int i = sArray.length - 1; i >= 0; i--) {
            queue.add(sArray[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.remove());
        }

        var reversedString = sb.toString();
        return reversedString.equalsIgnoreCase(stringMod);

        /*
        Time Complexity: O(n)

        Space Complexity: O(n)
        */

    }

    public static boolean checkPalindromeV2(String s) {
        Deque<Character> deque = new LinkedList<>();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }

        // before entering the while deque = radar | deque.size  = 5
        // front=r rear=r | deque = ada | deque.size = 3
        // front=a rear=a | deque = d | deque.size = 1 -> in the next iteration size == 1, so it will not enter in the while.

        while (deque.size() > 1) {
            // Remove and compare characters from both ends
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;

        /*
        Time Complexity: O(n)

        Space Complexity: O(n)
        */
    }
}


