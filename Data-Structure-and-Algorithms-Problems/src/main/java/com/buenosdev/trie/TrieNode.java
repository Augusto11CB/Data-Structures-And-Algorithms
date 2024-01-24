package com.buenosdev.trie;

public class TrieNode {
    public TrieNode[] children = new TrieNode[26]; // Children nodes
    public boolean isEndOfWord; // Flag to represent the end of a word

    String letter;

    public TrieNode(String letter) {
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;

        this.letter = letter;
    }
}