package com.buenosdev.a.maximumNumberOfWordsFoundInSentences;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProblemSolution {
    public int mostWordsFound(String[] sentences) {
        var hash = new HashMap<Integer, List<String>>();

        for (int i = 0; i < sentences.length; i++) {
            var s = sentences[i];
            var l = Arrays.stream(s.split(" ")).filter(s1 -> !s1.isEmpty() && !s1.isBlank()).toList();
            hash.put(i, l);
        }

        var max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<String>> entry : hash.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }
        return max;
    }

        public int mostWordsFoundII(String[] sentences) {
            int maxLen = 0;

            for (String currSent : sentences) {
                int currLen = currSent.split(" ").length;
                if (maxLen < currLen)
                    maxLen = currLen;
            }
            return maxLen;
        }

    public static void main(String[] args) {
        var solution = new ProblemSolution();
        solution.mostWordsFound(new String[]{"alice and bob love leetcode","i think so too","this is great thanks very much"});
    }
}