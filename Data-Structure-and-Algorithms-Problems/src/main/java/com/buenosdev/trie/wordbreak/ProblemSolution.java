package com.buenosdev.trie.wordbreak;

import com.buenosdev.trie.TrieNodeHash;

import java.util.*;

class ProblemSolution {


    // (Trie) Problem A: Work Break

    /*
    https://leetcode.com/problems/word-break/description/
     **/

/*
    The question should be reframed as; Is there a combination of words in wordDict that can be used to recreate the original string s. Notice that I mentioned the word combination, this does not mean that you will need all the words in wordDict to recreate s (Using some words from wordDict as long as they perfectly recreate the string s; is a valid solution or word break). Also note that you can use the words in wordDict more than once.

    Take this example for reference:

    Input: "bb", ["a","b","bbb","bbbb"]
    Expected: true

    Here, word "b" from wordDict can be used to perfectly to recreate the string s = "b" + "b" , which is why the expected output is True. Note that we did not use all the words in the dictionary and still found a valid word break.

    Now, let's take another example:
    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false

    Here, no combination of words exist in wordDict that can perfectly recreate the input string s.
    "cats" + "dog" will require "an" in wordDict in order to recreate s
    "cats" + "and" will require "og" in wordDict in order to recreate s
    "cat" + "sand" will require "og" in wordDict in order to recreate s
    ... and so on.

    The intuition is that you will have consider every combination of words in the wordDict, moreover these words can be used more than once when computing the combinations.

*/

    public boolean wordBreak(String s, List<String> wordDict) {
        var hashSet = new HashSet<String>();
        var cache = new HashMap<Integer, Integer>();
        var trie = new TrieNodeHash();

        hashSet.addAll(wordDict);

        for (String stg : wordDict) {
            trie.insert(stg);
        }
        cache.put(s.length(), 0);

        var result = dfs(hashSet, cache, s, 0, trie);

        return result == 0;

    }

    private int dfs(HashSet<String> hashSet, HashMap<Integer, Integer> cache, String s, int i, TrieNodeHash trie) {
        if (cache.containsKey(i)) return cache.get(i);

        var result = 1 + dfs(hashSet, cache, s, i + 1, trie);

        var curr = trie;

        for (int j = i; j < s.length(); j++) {

            if (!curr.children.containsKey(s.charAt(j))) break;

            curr = curr.children.get(s.charAt(j));

            if (curr.isEndOfWord) {
                result = Math.min(result, dfs(hashSet, cache, s, j + 1, trie));
            }
        }
        cache.put(i, result);

        return result;
    }
}