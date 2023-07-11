package com.buenosdev;

// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//Each letter in magazine can only be used once in ransomNote.

import java.util.HashMap;

public class RasomNote {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    // 8914-EE43
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> letterPresenceMagazine = new HashMap<>();
        for (char i : magazine.toCharArray()) {
            letterPresenceMagazine.compute(i, (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (char i : ransomNote.toCharArray()) {
            Integer quantityOfLetterI = letterPresenceMagazine.get(i);
            if (quantityOfLetterI == null || quantityOfLetterI <= 0) return false;
            quantityOfLetterI = quantityOfLetterI - 1;
            letterPresenceMagazine.put(i, quantityOfLetterI);
        }
        return true;
    }
}
