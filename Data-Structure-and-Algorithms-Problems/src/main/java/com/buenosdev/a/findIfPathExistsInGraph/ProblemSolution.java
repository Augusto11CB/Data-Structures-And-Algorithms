package com.buenosdev.a.findIfPathExistsInGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class ProblemSolution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        var graph = new HashMap<Integer, ArrayList<Integer>>();
        var visited = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        var deque = new ArrayDeque<Integer>();
        deque.push(source);
        visited.add(source);

        while (!deque.isEmpty()) {
            var node = deque.pop();
            var adj = graph.get(node);
            for (int i : adj) {
                if (!visited.contains(i)) {
                    visited.add(node);
                    deque.push(i);
                }
            }
        }

        return visited.contains(destination);
    }


}