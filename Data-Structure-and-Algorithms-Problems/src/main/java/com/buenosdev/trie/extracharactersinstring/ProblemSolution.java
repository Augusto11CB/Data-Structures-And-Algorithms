package com.buenosdev.trie.extracharactersinstring;

import com.buenosdev.trie.Trie;
import com.buenosdev.trie.TrieNode;
import com.buenosdev.trie.TrieNodeHash;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ProblemSolution {

    // TODO - Refazer exercício

    // (Trie) Problem 2: Extra Characters in a String

    /*
    https://leetcode.com/problems/extra-characters-in-a-string/description/
     **/

    /*
     * */

    public int minExtraChar(String s, String[] dictionary) {
        var hashSet = new HashSet<String>();
        var cache = new HashMap<Integer, Integer>();
        var trie = new TrieNodeHash();

        hashSet.addAll(Arrays.asList(dictionary));

        for (String stg : dictionary) {
            trie.insert(stg);
        }

        cache.put(s.length(), 0);
        return dfs(hashSet, cache, s, 0, trie);

    }

    private int dfs(HashSet<String> hashSet, Map<Integer, Integer> cache, String s, int i, TrieNodeHash trie) {
        if (cache.containsKey(i)) return cache.get(i);

        var result = 1 + dfs(hashSet, cache, s, i + 1, trie);

        var curr = trie;

        for (int j = i; j < s.length(); j++) {
            var currentChar = s.charAt(j);
            if (!curr.children.containsKey(s.charAt(j))) break;

            curr = curr.children.get(s.charAt(j));

            if (curr.isEndOfWord) {
                result = Math.min(result, dfs(hashSet, cache, s, j + 1, trie));

            }
        }
        cache.put(i, result);

        return result;
    }

    public int minExtraChar2(String s, @NotNull String[] dictionary) {
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
        var solution = new ProblemSolution();

        // Test case 1
        System.out.println(solution.minExtraChar("amazingracecar", new String[]{"race", "car"})); // Output: 7
        // Test case 2
        System.out.println(solution.minExtraChar("bookkeeperreading", new String[]{"keep", "read"})); // Output: 9
        // Test case 3
        System.out.println(solution.minExtraChar("thedogbarksatnight", new String[]{"dog", "bark", "night"})); // Output: 6

        System.out.println(solution.minExtraChar("dwmodizxvvbosxxw", new String[]{"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"})); // Output: 6
    }
}
