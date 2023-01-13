package com.buenosdev.trie.indexpairsofstring;

import java.util.HashMap;
import java.util.Map;

class TrieNodeHash {
    Map<Character, TrieNodeHash> children;
    boolean isEndOfWord; // Flag to represent the end of a word

    public TrieNodeHash() {
        this.isEndOfWord = false;
        this.children = new HashMap<>();
    }
}

public class TrieHash {
    TrieNodeHash root;

    public TrieHash() {
        root = new TrieNodeHash();
    }


    private boolean delete(String word) {
        TrieNodeHash node = root;
        for (Character currentChar : word.toCharArray()) {
            if (!node.children.containsKey(currentChar))
                return true;
            node = node.children.get(currentChar);
        }

        if (node.isEndOfWord) {
            node.isEndOfWord = false;
            return true;
        }
        return false;
    }


    public void insert(String word) {
        TrieNodeHash node = root;
        for (Character currentChar : word.toCharArray()) {
            if (!node.children.containsKey(currentChar)) {
                node.children.put(currentChar, new TrieNodeHash());
            }
            node = node.children.get(currentChar);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNodeHash node = root;
        for (Character currentChar : word.toCharArray()) {
            if (!node.children.containsKey(currentChar))
                return false;
            node = node.children.get(currentChar);
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNodeHash node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        var trie = new TrieHash();
        trie.insert("ap");
        trie.insert("au");

        System.out.println(trie.search("ap"));
        System.out.println(trie.search("au"));

        System.out.println("result: " + trie.delete("ap"));

        System.out.println(trie.search("au"));
        System.out.println(trie.search("ap"));
    }
}
