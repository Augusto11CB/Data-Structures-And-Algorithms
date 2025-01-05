package com.buenosdev.a.redundantConnection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class ProblemSolution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] i : edges) {
            if (!union(i[0], i[1])) return i;
        }
        return new int[1];
    }

    private int find(int n) {
        var p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean union(int n1, int n2) {
        var p1 = find(n1);
        var p2 = find(n2);

        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public int[] findRedundantConnectionFAILED(int[][] edges) {
        var graph = new HashMap<Integer, ArrayList<Integer>>();
        var visited = new HashSet<Integer>();

        for (int i = 0; i < edges.length; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            graph.get(edge[0]).add(edge[1]);
        }

        var deque = new ArrayDeque<Integer>();
        deque.push(edges[0][1]);
        visited.add(edges[0][1]);

        while (!deque.isEmpty()) {
            var node = deque.pop();
            var adj = graph.get(node);
            for (int i : adj) {
                if (!visited.contains(i)) {
                    visited.add(node);
                    deque.push(i);
                }
                if (visited.contains(i)) {
                    return new int[]{node, i};
                }
            }
        }
        return new int[]{0, 0};

    }
}