package com.buenosdev.companiesquestions.uber.areSentencesSimilar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class ProblemSolution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;

        var set = new HashSet<String>();

        for (List<String> i : similarPairs) {
            var one = i.get(0);
            var two = i.get(1);
            set.add(one + "." + two);
            set.add(two + "." + one);
        }


        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i] != sentence2[i]) {
                var wordOne = sentence1[i];
                var wordTwo = sentence2[i];
                if (!set.contains(wordTwo + "." + wordOne) && !set.contains(wordOne + "." + wordTwo))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ProblemSolution problemSolution = new ProblemSolution();

        // Test case 1
        String[] sentence1_1 = {"I", "am", "happy", "with", "leetcode"};
        String[] sentence2_1 = {"I", "am", "joyful", "with", "leetcode"};
        List<List<String>> similarPairs1 = Arrays.asList(
                Arrays.asList("happy", "joyful")
        );
        System.out.println(problemSolution.areSentencesSimilar(sentence1_1, sentence2_1, similarPairs1)); // Expected: true

        // Test case 2
        String[] sentence1_2 = {"I", "love", "leetcode"};
        String[] sentence2_2 = {"I", "enjoy", "leetcode"};
        List<List<String>> similarPairs2 = Arrays.asList(
                Arrays.asList("love", "like"),
                Arrays.asList("enjoy", "like")
        );
        System.out.println(problemSolution.areSentencesSimilar(sentence1_2, sentence2_2, similarPairs2)); // Expected: true

        // Test case 3
        String[] sentence1_3 = {"I", "love", "leetcode"};
        String[] sentence2_3 = {"I", "like", "coding"};
        List<List<String>> similarPairs3 = Arrays.asList(
                Arrays.asList("love", "like")
        );
        System.out.println(problemSolution.areSentencesSimilar(sentence1_3, sentence2_3, similarPairs3)); // Expected: false

        // Test case 4
        String[] sentence1_4 = {"I", "love", "leetcode"};
        String[] sentence2_4 = {"I", "love", "coding"};
        List<List<String>> similarPairs4 = new ArrayList<>();
        System.out.println(problemSolution.areSentencesSimilar(sentence1_4, sentence2_4, similarPairs4)); // Expected: false

        // Test case 5
        String[] sentence1_5 = {"I", "love", "leetcode"};
        String[] sentence2_5 = {"I", "love", "leetcode"};
        List<List<String>> similarPairs5 = Arrays.asList(
                Arrays.asList("happy", "joyful")
        );
        System.out.println(problemSolution.areSentencesSimilar(sentence1_5, sentence2_5, similarPairs5)); // Expected: true
    }
}