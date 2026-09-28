package com.buenosdev.workspace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class ProblemSolution {

    public static void main(String[] args) {

        var count = 0;
        var largeCount = 0L;

        var myInteger = Integer.valueOf(5);
        var myLong = Long.valueOf(5L);

        var minArray = new int[5];
        Arrays.fill(minArray, 0);

        var maxMatrix = new long[10][10];

        var minArrayList = new ArrayList<Integer>();

    }

    public boolean isAnagram(String s, String t) {
        // sort and compare
        if (s.length() != t.length())
            return false;

        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            var curChar = (Character.valueOf(s.charAt(i)));

            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            var curChar = Character.valueOf(t.charAt(i));

            if (!map.containsKey(curChar)) return false;
            var newVal = map.get(curChar) - 1;

            if (newVal <= 0) map.remove(curChar);
            else map.put(curChar, newVal);
        }

        return map.isEmpty();
    }
}
