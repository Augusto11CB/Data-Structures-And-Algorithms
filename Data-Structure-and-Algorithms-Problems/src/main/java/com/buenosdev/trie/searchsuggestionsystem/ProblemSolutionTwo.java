package com.buenosdev.trie.searchsuggestionsystem;

import com.buenosdev.trie.TrieNodeHash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProblemSolutionTwo {


    // (Trie) Problem 3: Search Suggestions System

    /*
    https://leetcode.com/problems/search-suggestions-system/description/
     **/

    /*
     * */


    private TrieNodeHash buildTrie(String[] products) {
        TrieNodeHash node = new TrieNodeHash();
        for (String pro : products) {
            this.insert(node, pro);
        }
        return node;
    }

    public void insert(TrieNodeHash root, String word) {
        TrieNodeHash node = root;
        for (Character currentChar : word.toCharArray()) {
            if (!node.children.containsKey(currentChar)) {
                node.children.put(currentChar, new TrieNodeHash());
            }
            node = node.children.get(currentChar);
        }
        node.isEndOfWord = true;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var result = new ArrayList<List<String>>();
        var trieNode = buildTrie(products);

        var prefix = new StringBuilder();
        // for each 'typed' word of the searchWord parameter:
        for (char ch : searchWord.toCharArray()) {
            prefix.append(ch);
            // return 3 suggestion that start with the typed word so far.
            result.add(findTopThreeMatches(prefix.toString(), trieNode));
        }

        return result;
    }

    private List<String> findTopThreeMatches(String prefixTerm, TrieNodeHash root) {
        var result = new ArrayList<String>();
        TrieNodeHash node = root;

        // let's reach the prefix in the trie before check anything before.
        for (char c : prefixTerm.toCharArray()) {
            if (node.children == null || !node.children.containsKey(c)) {
                return result;
            } else {
                node = node.children.get(c);
            }
        }

        dfs(node, result, new StringBuilder(prefixTerm));
//        dfs(node, result, prefixTerm);

        return result;
    }

    void dfs(TrieNodeHash node, List<String> listOfFoundProducts, StringBuilder sb) {
//    void dfs(TrieNodeHash node, List<String> listOfFoundProducts, String word) {
        if (listOfFoundProducts.size() == 3)
            return; // Limit to 3 suggestions
        if (node.isEndOfWord) {
            listOfFoundProducts.add(sb.toString());
//            listOfFoundProducts.add(word);
        }

//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            if (node.children.containsKey(ch)) {
//                sb.append(ch);
//                dfs(node.children.get(ch), listOfFoundProducts, sb);
//                sb.deleteCharAt(sb.length() - 1);
//            }
//        }

        for (Map.Entry<Character, TrieNodeHash> entry : node.children.entrySet()) {
//            dfs(entry.getValue(), listOfFoundProducts, word + entry.getKey());
            sb.append(entry.getValue());
            dfs(entry.getValue(), listOfFoundProducts, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

       /*
        Time Complexity:

        Space Complexity:
        */


    public static void main(String[] args) {
        var solution = new ProblemSolutionTwo();

//        // Test Example 1
//        String[] products1 = {"apple", "apricot", "application"};
//        String searchWord1 = "app";
//        System.out.println("Example 1: " + solution.suggestedProducts(products1, searchWord1));
//
//        // Test Example 2
//        String[] products2 = {"king", "kingdom", "kit"};
//        String searchWord2 = "ki";
//        System.out.println("Example 2: " + solution.suggestedProducts(products2, searchWord2));
//
//        // Test Example 3
//        String[] products3 = {"fantasy", "fast", "festival"};
//        String searchWord3 = "farm";
//        System.out.println("Example 3: " + solution.suggestedProducts(products3, searchWord3));

        // Test Example 4
        String[] products4 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord4 = "mouse";
        System.out.println("Example 4: " + solution.suggestedProducts(products4, searchWord4));
    }
}
