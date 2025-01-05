package com.buenosdev.divideandconquer.longestnicesubstring;

import java.util.*;

class Solution {

    public String solve(String s) {
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        String ans = "";
        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (j + 1 < 2) j++;
            else {
                boolean flag = true;
                for (Character xx : map.keySet()) {
                    if (xx >= 'a' && xx <= 'z' && !map.containsKey(Character.toUpperCase(xx))) {
                        flag = false;
                        break;
                    }
                    if (xx >= 'A' && xx <= 'Z' && !map.containsKey(Character.toLowerCase(xx))) {
                        flag = false;
                        break;
                    }

                }
                if (flag) ans = s.substring(0, j + 1);
                j++;
            }
        }
        return ans;
    }

    public String longestNiceSubstring(String s) {
        String str = s;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(i);
            if (ans.length() >= s.length()) break;
            String word = solve(s);
            if (ans.length() < word.length()) ans = word;
            s = str;
        }
        return ans;
    }
}