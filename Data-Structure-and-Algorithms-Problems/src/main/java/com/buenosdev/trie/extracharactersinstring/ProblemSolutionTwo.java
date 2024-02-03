package com.buenosdev.trie.extracharactersinstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class ProblemSolutionTwo {

    public int minExtraChar(String s, String[] dictionary) {
        var hashSet = new HashSet<String>();
        var cache = new HashMap<Integer, Integer>();

        hashSet.addAll(Arrays.asList(dictionary));

        cache.put(s.length(), 0);
        return dfs(hashSet, cache, s, 0);

    }

    private int dfs(HashSet<String> hashSet, Map<Integer, Integer> cache, String s, int i) {
        if (cache.containsKey(i))
            return cache.get(i);

        var result = 1 + dfs(hashSet, cache, s, i + 1);

        for (int j = i; j < s.length(); j++) {
            var sub = s.substring(i, j + 1);
            if (hashSet.contains(sub)) {
                result = Math.min(result, dfs(hashSet, cache, s, j + 1));
                cache.put(i, result);
            }
        }

        return result;
    }
}