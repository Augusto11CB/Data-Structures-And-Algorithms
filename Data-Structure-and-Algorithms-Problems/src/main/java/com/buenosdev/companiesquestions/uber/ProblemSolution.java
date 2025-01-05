package com.buenosdev.companiesquestions.uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

class ProblemSolution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // a -> ([b, weightB], [c, weightC], ...)
        var adj = new HashMap<String, ArrayList<Pair>>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double valueWeight = values[i];

            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, valueWeight));
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(new Pair(a, 1.0 / valueWeight));

        }

        var resp = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            var start = queries.get(i).get(0);
            var target = queries.get(i).get(1);
            resp[i] = bfs(adj, start, target);
        }

        return resp;
    }

    private double bfs(HashMap<String, ArrayList<Pair>> adj, String start, String target) {
        if (!adj.containsKey(start) || !adj.containsKey(target)) return -1.0;


        var visited = new HashSet<>();
        var queue = new LinkedList<Pair>();
        queue.add(new Pair(start, 1.0));
        visited.add(start);

        while (!queue.isEmpty()) {
            var pairFromQueue = queue.pop();
            var current = pairFromQueue.val;
            var weight = pairFromQueue.weight;

            if (current.equals(target)) {
                return weight;
            }

            var adjacentsOfCurrent = adj.get(current);
            for (Pair adjOfCur : adjacentsOfCurrent) {
                var next = adjOfCur.val;
                var w = adjOfCur.weight;
                if (!visited.contains(next)) {
                    queue.add(new Pair(next, weight * w));
                    visited.add(next);
                }
            }

        }

        return -1.0;
    }

    private class Pair {
        String val;
        Double weight;

        Pair(String val, Double weight) {
            this.val = val;
            this.weight = weight;
        }
    }


    /*

    Building the adj:
    - There are n equations, where n = equations.size().
    - For each equation, we perform a constant amount of work: adding two entries to the adjacency list.
    - Therefore, the time complexity for graph construction is O(n)

    BFS Search Phase:
    - For each query, we perform a BFS to find the path and compute the result:
        - In the worst case, BFS visits each node and edge of the graph. If there are V nodes and E edges:
            - Each node is dequeued and processed exactly once. This gives us: O(V)
            - or each node, we traverse its adjacency list to visit its neighbors. Since an edge connects two nodes, each edge is examined exactly twice in an undirected graph (once from each end).
            This contributes O(E) operations.
            - Thus, the combined effort of visiting each node and exploring all edges results in a total time complexity of O(V+E);

    q = number of queries

    O(n) + O(q * (V+E))


    */
}