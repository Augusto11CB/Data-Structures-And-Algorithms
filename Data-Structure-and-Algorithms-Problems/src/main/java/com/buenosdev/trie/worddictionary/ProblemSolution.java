package com.buenosdev.trie.worddictionary;

import com.buenosdev.trie.TrieNodeHash;

import java.util.Map;

class ProblemSolution {

    // (Trie) Problem 3: Design Add and Search Words Data Structure

    /*
    https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
     **/
    private final TrieNodeHash trieNode;

    public ProblemSolution() {
        trieNode = new TrieNodeHash();
    }

    public void addWord(String word) {
        TrieNodeHash node = trieNode;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNodeHash());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNodeHash node = trieNode;
        return searchInNode(word, node);
    }

    private boolean dfs(String s, TrieNodeHash trie) {
        if (s == null && trie != null && trie.isEndOfWord) return true;
        if (s == null || trie == null) return false;


        var curr = trie;

        var firstChar = s.charAt(0);

        if (firstChar != '.' && !curr.children.containsKey(firstChar)) return false;

        var newS = extracted(s);

        if (firstChar == '.') {
            for (Map.Entry<Character, TrieNodeHash> entry : curr.children.entrySet()) {
                if (entry.getValue() != null) {
                    return dfs(newS, entry.getValue());
                }
            }
            return false;
        }

        return dfs(newS, curr.children.get(firstChar));
    }

    private boolean searchInNode(String word, TrieNodeHash node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                // If it's a wildcard, recursively search for all possible characters.
                for (TrieNodeHash child : node.children.values()) {
                    if (child != null && searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            } else {
                // If the character doesn't exist, return false.
                if (!node.children.containsKey(ch)) return false;
                node = node.children.get(ch);  // Move to the next node.
            }
        }
        return node.isEndOfWord;  // Return if we're at the end of a valid word.
    }

    private static String extracted(String s) {
        if (s.length() == 1) return null;
        return s.substring(1);
    }


       /*
        Time Complexity:
            - insertion: O(n)
                - N is the length of the word. This is because each insertion operation runs in linear time with respect to the length of the word.
            - search: O(n*m)
                - where n is the length of the word and m is the total number of nodes in the Trie.
                - This happens when the search word contains dots ('.').
                - OBS: For words without dots, the search is O(n).

        Space Complexity: O(x * n)
            - x total number of Trie node
            - n is the average number of characters in the words.
       */

    public static void main(String[] args) {
        var obj = new ProblemSolution();
        obj.addWord("apple");
        obj.addWord("banana");
        System.out.println(obj.search("apple"));  // true
        System.out.println(obj.search("....."));  // true
        System.out.println(obj.search("canana"));  // true
    }
}