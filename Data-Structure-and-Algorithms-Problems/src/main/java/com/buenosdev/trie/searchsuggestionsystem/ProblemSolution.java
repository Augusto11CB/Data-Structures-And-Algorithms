package com.buenosdev.trie.searchsuggestionsystem;

import com.buenosdev.trie.Trie;
import com.buenosdev.trie.TrieNode;

import java.util.ArrayList;
import java.util.List;

public class ProblemSolution {


    // (Trie) Problem 3: Search Suggestions System

    /*
    https://leetcode.com/problems/search-suggestions-system/description/
     **/

    /*
     * */


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var result = new ArrayList<List<String>>();
        var trie = new Trie();

        for (String word : products) {
            trie.insert(word);
        }

        var prefix = new StringBuilder();
        // for each 'typed' word of the searchWord parameter:
        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            // return 3 suggestion that start with the typed word so far.
            result.add(findTopThreeMatches(prefix.toString(), trie.root));
        }

        return result;
    }

    private List<String> findTopThreeMatches(String prefixTerm, TrieNode root) {
        var result = new ArrayList<String>();
        TrieNode node = root;

        // let's reach the prefix in the trie before check anything before.
        for (char c : prefixTerm.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return result;
            } else {
                node = node.children[c - 'a'];
            }
        }

        // if (node.isEndOfWord) result.add(prefixTerm);
        var sb = new StringBuilder();
        dfs(root, result, sb);

        return result;
    }

    void dfs(TrieNode node, List<String> listOfFoundProducts, StringBuilder word) {
        if (listOfFoundProducts.size() == 3) return; // Limit to 3 suggestions
        if (node.isEndOfWord) {
            listOfFoundProducts.add(word.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            var childNode = node.children[ch - 'a'];
            if (childNode == null) continue;
            word.append(ch);
            dfs(childNode, listOfFoundProducts, word);
            word.deleteCharAt(word.length() - 1);
        }
    }



       /*
        Time Complexity:
        - Building the Trie: O(N * L), where N is the number of products and L is the average length of the name of the products.
        - Searching for Each Prefix: (O(M x K)), where (M) is the length of the search word and (K) is the time taken for the DFS, which is limited to 3 (constant time).

        Space Complexity:
        - Trie Storage: O(N * L), for storing N words each of average length L.
        - Search Results: (O(M)), as we store up to 3 suggestions for each character in the search word.
        */


    public static void main(String[] args) {
        var solution = new ProblemSolution();

        // Test Example 1
        String[] products1 = {"apple", "apricot", "application"};
        String searchWord1 = "app";
        System.out.println("Example 1: " + solution.suggestedProducts(products1, searchWord1));

        // Test Example 2
        String[] products2 = {"king", "kingdom", "kit"};
        String searchWord2 = "ki";
        System.out.println("Example 2: " + solution.suggestedProducts(products2, searchWord2));

        // Test Example 3
        String[] products3 = {"fantasy", "fast", "festival"};
        String searchWord3 = "farm";
        System.out.println("Example 3: " + solution.suggestedProducts(products3, searchWord3));
    }
}
