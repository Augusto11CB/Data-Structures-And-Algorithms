package com.buenosdev.trie

class TrieNodeKotlin {
    val children: MutableMap<Char, TrieNodeKotlin> = HashMap()
    var isEndOfWord = false
}

class TrieKotlin {
    private val root: TrieNodeKotlin = TrieNodeKotlin()

    fun insert(word: String) {
        var node = root
        for (char in word) {
            if (!node.children.containsKey(char)) {
                node.children[char] = TrieNodeKotlin()
            }
            node = node.children[char]!!
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (char in word) {
            if (!node.children.containsKey(char)) {
                return false
            }
            node = node.children[char]!!
        }
        return node.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (char in prefix) {
            if (!node.children.containsKey(char)) {
                return false
            }
            node = node.children[char]!!
        }
        return true
    }

    private fun delete(current: TrieNodeKotlin, word: String): Boolean {
        var node = root
        for (char in word) {
            if (!node.children.containsKey(char)) {
                return false
            }
            node = node.children[char]!!
        }

        if (node.isEndOfWord) {
            node.isEndOfWord = false
            return true
        }
        return false
    }


}


fun main() {
    val trie = TrieKotlin()
    trie.insert("leetcodeisnice")
    trie.insert("leet")
    val result = trie.search("leet")
    println(result)
}