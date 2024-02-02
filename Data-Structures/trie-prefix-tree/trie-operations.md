# Trie Operations

### Trie Operations

* delete
* insert
* search
* startWith

### Trie

```java
public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode("");
    }

    private boolean delete(TrieNode current, String word, int index) {
        // Base case: If the word's end is reached
        if (index == word.length()) {
            // If the word exists, unmark it and check if the node can be deleted
            if (current.isEndOfWord) {
                current.isEndOfWord = false;
                // Check if all children are null
                for (TrieNode child : current.children) {
                    if (child != null) false; // Return false if any child exists
                }
                return true; // Return true if all children are null
            }
            return false;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children[ch - 'a'];
        
        if (node == null) false; // Word not found
        

        boolean shouldDeleteChild = delete(node, word, index + 1);

        // If true is returned, delete the child reference of the current TrieNode
        if (shouldDeleteChild) {
            current.children[ch - 'a'] = null;
            // Check if all children are null
            for (TrieNode child : current.children) {
                if (child != null) return false; // Return false if any child exists
            }
            return !current.isEndOfWord;// Return true if all children are null
        }

        return false;
    }

    // Function to delete a word from the Trie
    public void deleteWord(String word) {
        delete(root, word, 0);
    }


    // Function to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Convert character to index
            if (node.children[index] == null)
                node.children[index] = new TrieNode(String.valueOf(word.charAt(i))); // Create a new node if it doesn't exist
            node = node.children[index];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }


    // Function to search a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) return false; // Word not found
            node = node.children[index];
        }
        return node.isEndOfWord; // Return true if word exists, false otherwise
    }


    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("augusto");
        trie.insert("teste");
        var result = trie.search("teste");
        System.out.println(result);
    }
}
```

### Trie (Map)

```java

import java.util.HashMap;
import java.util.Map;

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

```
