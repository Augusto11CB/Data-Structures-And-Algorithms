package com.buenosdev.greedy.removeduplicateletters;

import java.util.*;

public class ProblemSolution {

    // (Greedy Algorithm) Problem 4: Remove Duplicate Letters

    /*
    https://leetcode.com/problems/remove-duplicate-letters/description/
     **/

    /*
     * */
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

        sol.removeDuplicateLetters("cbacdcbc");
    }


}