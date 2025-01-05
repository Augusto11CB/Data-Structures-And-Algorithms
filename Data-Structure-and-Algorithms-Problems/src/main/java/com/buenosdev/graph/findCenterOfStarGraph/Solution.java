package com.buenosdev.graph.findCenterOfStarGraph;


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findCenter(int[][] edges) {
        var map = new HashMap<Integer, Integer>();

        for (int[] ar : edges) {
            var u = ar[0];
            var v = ar[1];
            map.put(u, map.getOrDefault(u, 0) + 1);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        var result = -1;
        var maxSoFar = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxSoFar) {
                maxSoFar = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}