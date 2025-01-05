package com.buenosdev.a.groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class ProblemSolution {
    public List<List<String>> groupAnagrams(String[] strs) {

        var hashMap = new HashMap<String, List<String>>();

        // Since we need to sort m such strings, the total time complexity for this part is O(m * n log n).
        for (String str : strs) {

            var array = str.toCharArray();

            Arrays.sort(array);

            var key = new String(array);

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<String>());
            }
            hashMap.get(key).add(str);
        }

        return new ArrayList<>(hashMap.values());

    }
}