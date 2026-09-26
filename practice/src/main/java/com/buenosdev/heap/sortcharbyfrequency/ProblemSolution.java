package com.buenosdev.heap.sortcharbyfrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ProblemSolution {

    // (Heap) Problem 2: Sort Characters By Frequency

    /*
    https://leetcode.com/problems/unique-number-of-occurrences/
    **/

    /*
     * */

    public String frequencySort(String s) {
        var result = new StringBuilder();
        var myHashMap = new HashMap<Character, Integer>();
//      var myHeap = new PriorityQueue<Character>((a, b) -> myHashMap.get(b) - myHashMap.get(a));
        var myHeap = new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());


        // count the frequency of each character in the string.
        for (Character c : s.toCharArray()) {
            myHashMap.put(c, myHashMap.getOrDefault(c, 0) + 1);
        }

        // build a max heap (priority queue) where each element is a character, and the heap is sorted based on the frequency of characters.
        for (Map.Entry<Character, Integer> entry : myHashMap.entrySet()) {
            myHeap.add(entry);
        }

        // construct the result string by repeatedly removing the top element of the heap.
        while (!myHeap.isEmpty()) {
            var entry = myHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }

       /*
        Time Complexity: O(n + m)
        - where n is the length of the arr and m is the length of the occurrencesMapper.

        Space Complexity: O(n)

        */


    public String frequencySortV2(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> counts[b] - counts[a]);
        for (int i = 0; i < 128; i++) {
            if (counts[i] != 0) {
                pq.add((char) i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < counts[c]; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        ProblemSolution sol = new ProblemSolution();
        System.out.println(sol.frequencySort("programming")); // Expected: gggrrmmiapo
        System.out.println(sol.frequencySort("aab"));         // Expected: aab or baa
        System.out.println(sol.frequencySort("apple"));       // Expected: pplea
    }
}