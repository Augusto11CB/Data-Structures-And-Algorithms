package com.buenosdev.a.letterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ProblemSolution {
    public List<String> letterCombinations(String digits) {
        var ans = new ArrayList<String>();
        // If the input digits are null or empty, return an empty result list
        if (digits == null || digits.isBlank()) return ans;

        // Create a map that links each digit to its corresponding letters
        var mapOfDigtsAndNum = getMapOfDigitAndNumbers();
        var sb = new StringBuilder();

        // Start the recursive process to build combinations
        recursion(mapOfDigtsAndNum, sb, digits, ans);

        return ans;
    }

    public void recursion(Map<Character, List<Character>> map, StringBuilder currentCombination, String digits, List<String> result) {
        // Base case: if there are no more digits left, add the current combination to the result
        if (digits == null || digits.isBlank()) {
            result.add(currentCombination.toString());
            return;
        }

        // Get the current digit and the list of characters it maps to
        var currentDigit = digits.charAt(0);
        var listOfDigitsForCurrentDig = map.get(currentDigit);

        // Iterate through each character that the current digit can represent
        for (Character c : listOfDigitsForCurrentDig) {
            currentCombination.append(c);  // Append the character to the current combination

            // Prepare the substring for the next recursion
            // If it was '235', after the execution of digits.substring(1), it is '35'
            var remainingDigits = digits.substring(1);

            recursion(map, currentCombination, remainingDigits, result);  // Recurse with the next digit

            // Backtrack by removing the last character
            currentCombination.deleteCharAt(currentCombination.length() - 1);
        }
    }

    private static Map<Character, List<Character>> getMapOfDigitAndNumbers() {
        Map<Character, List<Character>> map = new HashMap<>();

        // Manually map each digit to its corresponding list of characters
        List<Character> two = new ArrayList<>(List.of('a', 'b', 'c'));
        List<Character> three = new ArrayList<>(List.of('d', 'e', 'f'));
        List<Character> four = new ArrayList<>(List.of('g', 'h', 'i'));
        List<Character> five = new ArrayList<>(List.of('j', 'k', 'l'));
        List<Character> six = new ArrayList<>(List.of('m', 'n', 'o'));
        List<Character> seven = new ArrayList<>(List.of('p', 'q', 'r', 's'));
        List<Character> eight = new ArrayList<>(List.of('t', 'u', 'v'));
        List<Character> nine = new ArrayList<>(List.of('w', 'x', 'y', 'z'));

        map.put('2', two);
        map.put('3', three);
        map.put('4', four);
        map.put('5', five);
        map.put('6', six);
        map.put('7', seven);
        map.put('8', eight);
        map.put('9', nine);

        return map;
    }

    public List<String> letterCombinationsQueue(String digits) {
        // List to hold the resulting combinations
        LinkedList<String> combinations = new LinkedList<>();

        // If the input string is empty, return the empty list
        if (digits.isEmpty()) return combinations;

        // Mapping of digits to corresponding letters on a telephone keypad
        String[] digitToLetters = new String[]{
                "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        // Start with an empty string as the initial combination
        combinations.add("");

        // Iterate over each digit in the input string
        for (int i = 0; i < digits.length(); i++) {
            // Get the numeric value of the current digit
            int digit = Character.getNumericValue(digits.charAt(i));

            // Process all combinations of the current length
            while (combinations.peek().length() == i) {
                // Remove the first combination from the list
                String combination = combinations.remove();

                // For each letter corresponding to the current digit
                for (char letter : digitToLetters[digit].toCharArray()) {
                    // Append the letter to the current combination and add it back to the list
                    combinations.add(combination + letter);
                }
            }
        }

        // Return the list of combinations
        return combinations;
    }


    public static void main(String[] args) {
        ProblemSolution solution = new ProblemSolution();

        // Test with an example input
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);

        // Print the output
        System.out.println("Letter combinations for digits '" + digits + "': " + combinations);
    }
}
