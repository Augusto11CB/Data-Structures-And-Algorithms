package com.buenosdev.greedy.removeduplicateletters;

import java.util.*;

public class ProblemSolution {

    // (Greedy Algorithm) Problem 4: Remove Duplicate Letters

    /*
    https://leetcode.com/problems/remove-duplicate-letters/description/
     **/

    /*
     * */

    public String removeDuplicateLettersA(String s) {
        var sArray = s.toCharArray();
        var countLastCharIndexOccurrence = new HashMap<Character, Integer>(); // count is going to store the last indice that a character appeared
        var present = new HashSet<Character>(); // present is going to indicate if the character is part of the answer.
        var result = new Stack<Character>();

        // Get the last position that Character appeared
        for (int i = 0; i < sArray.length; i++) {
            countLastCharIndexOccurrence.put(sArray[i], i);
        }

        for (int i = 0; i < sArray.length; i++) {


            if (!present.contains(sArray[i])) {
                // if currentChar is 'smaller' that the last char added in the result AND
                // if the last char added in the result is going to appear later in the sArray
                // Then we are going to remove the last char added in order to add the currentchar in the result to guarantee the smallest in lexicographical order.
                while (!result.empty() && sArray[i] < result.peek() && countLastCharIndexOccurrence.get(result.peek()) > i) {
                    present.remove(result.pop());
                }

                result.add(sArray[i]);
                present.add(sArray[i]);
            }
        }

        var sb = new StringBuilder();
        while (!result.empty()) {
            sb.insert(0, result.pop());
        }
        return sb.toString();
    }

    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashSet<Character> present = new HashSet<>();
        Stack<Character> result = new Stack<>();

        for (Character c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (Character c : s.toCharArray()) {
            var occurrenceCharC = count.get(c);
            // Check if the stack is empty before peeking
            if (!result.empty()) {
                var stackTopElement = result.pop();
                var stackTopElementOccurrences = count.get(stackTopElement);

                while (stackTopElement >= c && stackTopElementOccurrences > 1) {
                    if (!result.empty()) {
                        count.put(stackTopElement, stackTopElementOccurrences - 1);
                        stackTopElement = result.pop();
                        stackTopElementOccurrences = count.get(stackTopElement);
                    } else {
                        break;
                    }
                }
                if (!(stackTopElement >= c && stackTopElementOccurrences > 1)) {
                    result.add(stackTopElement);
                }

            }
            result.add(c);
        }

        var sb = new StringBuilder();
        while (!result.empty()) {
            sb.insert(0, result.pop());
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        var sol = new ProblemSolution();

        sol.removeDuplicateLettersA("cbacdcbc");
    }

}