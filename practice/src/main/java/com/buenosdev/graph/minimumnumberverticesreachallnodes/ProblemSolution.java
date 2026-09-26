package com.buenosdev.graph.minimumnumberverticesreachallnodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class ProblemSolution {

    // (Graph) Problem 3: Minimum Number of Vertices to Reach All Nodes

    /*
    https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
     **/

    private static int ROOTs = 0;
    private static int NON_ROOTs = 1;

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        var hash = new HashMap<Integer, HashSet<Integer>>();
        hash.put(ROOTs, new HashSet<>());
        hash.put(NON_ROOTs, new HashSet<>());

        // [[0,1],[0,2],[2,5],[3,4],[4,2]]
        for (int i = 0; i < edges.size(); i++) {
            var ar = edges.get(i);
            var from = ar.get(0);
            var to = ar.get(1);

            if (hash.get(ROOTs).contains(to)) {
                // remover o TO de ROOTS, pois ele não é mais um ROOT.
                hash.get(0).remove(to);
                // adicionar o TO no NON_ROOTS.
                hash.get(1).add(to);
            }

            if (!hash.get(NON_ROOTs).contains(from)) {
                hash.get(ROOTs).add(from);
            }

            hash.get(1).add(to);
        }

        var result = new ArrayList<Integer>();
        result.addAll(hash.get(ROOTs));
        return result;

    }

       /*
        Time Complexity:

        Space Complexity:

        */

    public List<Integer> findSmallestSetOfVerticesTwo(int n, List<List<Integer>> edges) {
        // To solve, think about the "in-degree" concept.
        // "in-degree" means the number of incoming edges to a node.
        // (directed graph), if a node doesn't have incoming edges, then it cannot be reached from any other node.
        // For this exercise, those type of node must be the "starting points"
        boolean[] hasIncomingEdge = new boolean[n];

        for (int i = 0; i < edges.size(); i++) {
            var ar = edges.get(i);
            var to = ar.get(1);
            hasIncomingEdge[to] = true;
        }

        var result = new ArrayList<Integer>();
        // Verify which node has in-degree=0 and insert it in the result.
        for (int i = 0; i < n; i++) {
            if (!hasIncomingEdge[i]) result.add(i);
        }
        return result;
    }

       /*
        Time Complexity: O(n + e)
            - We check for every edge e: O(e)
                - Worse case: every node is connected to every other node: e = n2
            - Verify which node has in-degree=ZERO: O(n)

        Space Complexity: O(n)

       */

    public static void main(String[] args) {
        var solution = new ProblemSolution();

        // Test cases
//        List<List<Integer>> edges1 = List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2));
//        System.out.println(solution.findSmallestSetOfVertices(6, edges1));  // Expected: [0, 3]
//
//        List<List<Integer>> edges2 = List.of(List.of(0, 1), List.of(3, 1), List.of(1, 2));
//        System.out.println(solution.findSmallestSetOfVertices(4, edges2));  // Expected: [0, 3]

        List<List<Integer>> edges3 = List.of(List.of(2, 0), List.of(3, 2));
        System.out.println(solution.findSmallestSetOfVerticesTwo(4, edges3));  // Expected: [1, 3]

    }

}

