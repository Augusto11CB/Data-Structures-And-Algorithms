package com.buenosdev.graph.findifpathexist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

class ProblemSolution {

    // (Graph) Problem 1: Find if Path Exists in Graph

    /*
    https://leetcode.com/problems/find-if-path-exists-in-graph/description/
    **/


    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        var graph = new HashMap<Integer, ArrayList<Integer>>();
        var visited = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // a 2D integer array
        // representação interessante.
        // o array de edges representa as conexão e não a lista/matrix de adjacencia
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

        }

        dfsIterativeWay(visited, graph, source);

        return visited.contains(destination);
    }

    private void dfsIterativeWay(HashSet<Integer> visited, HashMap<Integer, ArrayList<Integer>> graph, int node) {
        var s = new Stack<Integer>();

        visited.add(node);
        s.add(node);

        while (!s.empty()) {
            var current = s.pop();
            var adjList = graph.get(current);

            for (Integer neighbour : adjList) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    s.add(neighbour);
                }
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        var graph = new HashMap<Integer, ArrayList<Integer>>();
        var visited = new HashSet<Integer>();

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList());

        //construct graph, add bidirectional vertex
        // Example 1: edges = [[0,1],[1,2],[2,0]]
        // Example 2: edges = [[0,1],[0,2],[3,5],[5,4],[4,3]]
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfsRecursionWay(visited, graph, source);

        return visited.contains(destination);
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
        var sol = new ProblemSolution();
        System.out.println(sol.validPath(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}, 0, 3)); // true
        System.out.println(sol.validPath(4, new int[][]{{0, 1}, {2, 3}}, 0, 3));     // false
        System.out.println(sol.validPath(5, new int[][]{{0, 1}, {3, 4}}, 0, 4));     // false


        System.out.println(sol.validPath2(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}, 0, 3)); // true
        System.out.println(sol.validPath2(4, new int[][]{{0, 1}, {2, 3}}, 0, 3));     // false
        System.out.println(sol.validPath2(5, new int[][]{{0, 1}, {3, 4}}, 0, 4));     // false
    }
}