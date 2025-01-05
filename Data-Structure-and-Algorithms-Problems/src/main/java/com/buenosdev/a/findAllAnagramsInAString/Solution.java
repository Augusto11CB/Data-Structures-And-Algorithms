package com.buenosdev.a.findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        var result = new ArrayList<Integer>();
        if (p.length() > s.length()) return result; // Check if pattern length is greater than string length

        var mapOfFrequenciesP = new HashMap<Character, Integer>(); // Map to store character frequencies of pattern
        var mapOfFrequenciesS = new HashMap<Character, Integer>(); // Map to store character frequencies of current window in string

        for (Character c : p.toCharArray()) {
            mapOfFrequenciesP.put(c, 1 + mapOfFrequenciesP.getOrDefault(c, 0)); // Count frequencies of characters in pattern
        }

        var windowStart = 0; // Initialize start of the sliding window

        // Using maps of frequency (mapOfFrequenciesP and mapOfFrequenciesS) allows us to represent the characters along with their frequencies in both the pattern
        // string and the current window of the string being traversed. This representation helps us to compare whether
        // the current window contains an anagram of the pattern string without explicitly generating all possible
        // substrings of the same length as the pattern.
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) { // Slide the window through the string
            var currentCharacter = s.charAt(windowEnd); // Get the current character in the window

            mapOfFrequenciesS.put(currentCharacter, 1 + mapOfFrequenciesS.getOrDefault(currentCharacter, 0)); // Count frequencies of characters in the current window

            // When the size of the window matches the length of the pattern string, we compare mapOfFrequenciesS with mapOfFrequenciesP. If they are equal, it implies that the characters in the current window form an anagram of the pattern string. This comparison is efficient because it's a simple map comparison rather than comparing every character individually.
            if (windowEnd >= p.length() - 1) {

                // Where is the "jump of the cat"
                if (mapOfFrequenciesS.equals(mapOfFrequenciesP)) { // Check if character frequencies in window match pattern
                    result.add(windowStart); // Add starting index of anagram to result list
                }


                // As we slide the window, we need to update mapOfFrequenciesS to maintain the frequencies of characters
                // in the current window (the window size is p.length()). We remove the character at the start of the window and decrement its frequency.
                // If the frequency becomes zero, we remove the character from the map to keep it updated.
                var firstCharOfWindow = s.charAt(windowStart); // Get the first character of the window
                if (mapOfFrequenciesS.containsKey(firstCharOfWindow)) { // If the character is in the map
                    mapOfFrequenciesS.put(firstCharOfWindow, mapOfFrequenciesS.getOrDefault(firstCharOfWindow, 0) - 1); // Decrement its frequency

                    if (mapOfFrequenciesS.get(firstCharOfWindow) == 0)
                        mapOfFrequenciesS.remove(firstCharOfWindow); // Remove character if its frequency becomes zero
                }
                windowStart += 1; // Slide the window by one character
            }
        }

        return result; // Return list of starting indices of anagrams found
    }


    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.findAnagrams("abab", "ab"));
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}