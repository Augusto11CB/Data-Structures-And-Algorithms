package com.buenosdev.hash.majorityelement;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class ProblemSolution {
    public int majorityElement(int[] nums) {
        var hashControl = new HashMap<Integer, Integer>();

        for (int i : nums) {
            hashControl.put(i, hashControl.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        queue.addAll(hashControl.entrySet());

        return Objects.requireNonNull(queue.poll()).getKey();
    }
}
