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

}