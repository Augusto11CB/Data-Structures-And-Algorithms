package com.buenosdev.trie;

import java.util.Map;
import java.util.TreeMap;

public class TrieNodeHash {
    public Map<Character, TrieNodeHash> children;
    public boolean isEndOfWord; // Flag to represent the end of a word

    public TrieNodeHash() {
        this.isEndOfWord = false;
        this.children = new TreeMap<>();
    }

    public void insert(String word) {
        TrieNodeHash node = this;
        for (Character currentChar : word.toCharArray()) {
            if (!node.children.containsKey(currentChar)) {
                node.children.put(currentChar, new TrieNodeHash());
            }
            node = node.children.get(currentChar);
        }
        node.isEndOfWord = true;
    }

}