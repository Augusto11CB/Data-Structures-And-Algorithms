package com.buenosdev.trie.extracharactersinstring;

import com.buenosdev.trie.Trie;
import com.buenosdev.trie.TrieNode;

public class ProblemSolutionFailed {


    // (Trie) Problem 2: Extra Characters in a String

    /*
    https://leetcode.com/problems/extra-characters-in-a-string/description/
     **/

    /*
     * */


    public int minExtraChar(String s, String[] dictionary) {
        var result = 0;
        var trie = new Trie();

        for (String word : dictionary) {
            trie.insert(word);
        }

        for (int i = 0; i < s.length(); i++) {
            var trieNode = trie.root;
            for (int j = i; j < s.length(); j++) {
                var charUnderVerification = s.charAt(j);
                var indexCharUnderVerification = charUnderVerification - 'a';

                if (!trieNodeHasFollowingCharEqualsCharUnderVerification(trieNode, indexCharUnderVerification)) {
                    result = result + 1;
                    break;
                }
                trieNode = trieNode.children[indexCharUnderVerification];
                if (trieNode.isEndOfWord) {
                    i = j;
                    break;
                }
            }
        }

        return result;
    }

    private boolean trieNodeHasFollowingCharEqualsCharUnderVerification(TrieNode trieNode, int indexCurrentChar) {
        var child = trieNode.children[indexCurrentChar];
        return child != null;
    }

       /*
        Time Complexity: O(N * L + T^2 * L)

        Space Complexity: O(h)
        */


    public static void main(String[] args) {
        var solution = new ProblemSolutionFailed();

        // Test case 1
        System.out.println(solution.minExtraChar("amazingracecar", new String[]{"race", "car"})); // Output: 7
        // Test case 2
        System.out.println(solution.minExtraChar("bookkeeperreading", new String[]{"keep", "read"})); // Output: 9
        // Test case 3
        System.out.println(solution.minExtraChar("thedogbarksatnight", new String[]{"dog", "bark", "night"})); // Output: 6

        System.out.println(solution.minExtraChar("dwmodizxvvbosxxw", new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"})); // Output: 6
    }
}
