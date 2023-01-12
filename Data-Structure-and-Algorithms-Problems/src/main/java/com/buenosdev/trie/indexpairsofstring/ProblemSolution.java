package com.buenosdev.trie.indexpairsofstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemSolution {


    // (Trie) Problem 1: Index Pairs of a String

    /*
    https://leetcode.ca/all/1065.html
     **/

    /*
     * */

    public List<List<Integer>> indexPairs(String word, List<String> words) {
        List<List<Integer>> result = new ArrayList<>();
        var trie = new Trie();

        for (String s : words) {
            trie.insert(s);
        }

        for (int i = 0; i < word.length(); i++) {
            // For each char in word, we well check if, starting from the root, we can find a matching pattern with the word.
            // initiate a pointer trieNode at the root of the trie.
            var trieNode = trie.root;
            for (int j = i; j < word.length(); j++) {
                var charUnderVerification = word.charAt(j);
                var indexCharUnderVerification = charUnderVerification - 'a';

                // Check if the current character exists as a child of the current trie node pointed by trieNode.
                if (!trieNodeHasFollowingCharEqualsCharUnderVerification(trieNode, indexCharUnderVerification)) break;

                // If the current character exists as a child, move the pointer trieNode to this child node.
                trieNode = trieNode.children[indexCharUnderVerification];
                if (trieNode.isEndOfWord) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }



       /*
        Time Complexity: O(N * L + T^2 * L)
        - Building the Trie: O(N * L), where N is the number of words and L is the average length of these words.
        - Finding Index Pairs: O(T^2 * L), where T is the length of the text string and L is the length of the longest word.

        Space Complexity: O(h)
        - Trie Storage: O(N * L), for storing N words each of average length L.
        */

    private boolean trieNodeHasFollowingCharEqualsCharUnderVerification(TrieNode trieNode, int indexCurrentChar) {
        var child = trieNode.children[indexCurrentChar];
        return child != null;
    }

    public static void main(String[] args) {
        var solution = new ProblemSolution();
        // Test examples
        String text1 = "bluebirdskyscraper";
        List<String> words1 = Arrays.asList("blue", "bird", "sky");
        System.out.println(solution.indexPairs(text1, words1));

        String text2 = "programmingisfun";
        List<String> words2 = Arrays.asList("pro", "is", "fun", "gram");
        System.out.println(solution.indexPairs(text2, words2));

        String text3 = "interstellar";
        List<String> words3 = Arrays.asList("stellar", "star", "inter");
        System.out.println(solution.indexPairs(text3, words3));
    }
}
