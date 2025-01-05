package com.buenosdev.companiesquestions.uber.topKFrequentWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class ProblemSolution {
    public List<String> topKFrequent(String[] words, int k) {
        // Initialize a HashMap to store the frequency of each word
        var hashMap = new HashMap<String, Integer>();
        // Initialize an ArrayList to store the final result
        var result = new ArrayList<String>();

        // Iterate through each word in the input array
        for (String word : words) {
            // For each word, increment its frequency in the hashMap
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        // Define a PriorityQueue with a custom comparator
        // The comparator sorts words by frequency (descending), then by lexicographical order (ascending)
        var queue = new PriorityQueue<String>((a, b) -> {
            // Calculate the difference in frequencies
            var freq = hashMap.get(b) - hashMap.get(a);
            // If the frequencies are the same, sort lexicographically
            if (freq == 0) {
                return a.compareTo(b);
            }
            // Otherwise, sort by frequency
            return freq;
        });

        // Add all the words from the hashMap to the priority queue
        queue.addAll(hashMap.keySet());

        // Extract the top k elements from the priority queue
        for (int i = 0; i < k; i++) {
            // Poll the highest priority element (highest frequency, or lexicographically smallest if frequencies are equal)
            result.add(queue.poll());
        }

        // Return the list of the top k frequent words
        return result;
    }
}
