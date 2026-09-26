package com.buenosdev.trie.indexpairsofstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int[][] indexPairs(String text, String[] words) {
        Node root = new Node();
        for (String word : words) {
            add(root, word);
        }

        char[] arr = text.toCharArray();
        int textLenght = arr.length;

        List<int[]> ll = new ArrayList<>();
        for (int i = 0; i < textLenght; i++) {
            for (int j = i + 1; j <= textLenght; j++) {
                String sub = text.substring(i, j);
                if (search(root, sub)) {
                    ll.add(new int[]{i, j - 1});
                }
            }
        }

        int[][] ans = new int[ll.size()][2];
        for (int i = 0; i < ll.size(); i++) {
            ans[i] = ll.get(i);
        }

        return ans;
    }

    public static void add(Node root, String word) {
        Node cur = root;
        cur.pass++;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (!cur.nexts.containsKey(c))
                cur.nexts.put(c, new Node());
            cur = cur.nexts.get(c);
            cur.pass++;
        }

        cur.end++;
    }

    public static boolean search(Node root, String word) {
        Node cur = root;
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if (!cur.nexts.containsKey(c)) return false;
            cur = cur.nexts.get(c);
        }

        return cur.end > 0;
    }

    static class Node {
        int pass = 0;
        int end = 0;
        Map<Character, Node> nexts = new HashMap<>();
    }

}