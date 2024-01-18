package com.buenosdev.graph.provinces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

class ProblemSolution {

    // (Graph) Problem 2: Number of Provinces

    /*
    https://leetcode.com/problems/number-of-provinces/description/
    **/


    public int findCircleNum(int[][] isConnected) {
        var visited = new HashSet<Integer>();
        var graph = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < isConnected.length; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    // Adding connected nodes to the adjacency list
                    graph.get(i).add(j);
                }
            }
        }

        var provinces = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
            if (!visited.contains(entry.getKey())) {
                dfsIterativeWay(visited, graph, entry.getKey());
                provinces++;
            }
        }

        return provinces;
    }


    private void dfsIterativeWay(HashSet<Integer> visited, HashMap<Integer, ArrayList<Integer>> graph, int node) {
        var stack = new Stack<Integer>();

        visited.add(node);
        stack.add(node);

        while (!stack.empty()) {
            var current = stack.pop();
            var adjList = graph.get(current);

            for (Integer neighbour : adjList) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    stack.add(neighbour);
                }
            }
        }
    }


    private void dfsRecursionWay(HashSet<Integer> visited, HashMap<Integer, ArrayList<Integer>> graph, int node) {
        visited.add(node);
        var neighbours = graph.get(node);
        if (!neighbours.isEmpty()) {
            for (int i : neighbours) {
                if (!visited.contains(i)) {
                    dfsRecursionWay(visited, graph, i);
                }
            }
        }
    }


    public static void main(String[] args) {
        var solution = new ProblemSolution();
        int[][] test1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] test2 = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}};
        int[][] test3 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] test4 = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};

        System.out.println(solution.findCircleNum(test1));  // Expected output: 2
        System.out.println(solution.findCircleNum(test2));  // Expected output: 2
        System.out.println(solution.findCircleNum(test3));  // Expected output: 3
        System.out.println(solution.findCircleNum(test4));  // Expected output: 1
    }
}

