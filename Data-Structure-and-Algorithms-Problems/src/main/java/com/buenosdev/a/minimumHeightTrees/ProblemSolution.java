package com.buenosdev.a.minimumHeightTrees;

import java.util.*;

class ProblemSolution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        var map = new HashMap<Integer, Set<Integer>>();

        for (int i = 0; i < edges.length; i++) {
            var x = edges[i][0];
            var y = edges[i][1];
            var listOfOne = map.getOrDefault(y, new HashSet<>());
            listOfOne.add(x);
            map.put(y, listOfOne);

            var listOfZero = map.getOrDefault(x, new HashSet<>());
            listOfZero.add(y);
            map.put(x, listOfZero);

        }

        var mapSize = new TreeMap<Integer, List<Integer>>();

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {

            var size = entry.getValue().size();
            var node = entry.getKey();

            var list = mapSize.getOrDefault(size, new ArrayList<>());
            list.add(node);

            mapSize.put(size, list);

        }

        return mapSize.lastEntry().getValue();

    }

    public static void main(String[] args) {
        var ps = new ProblemSolution();
        int[][] list = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        ps.findMinHeightTrees(6, list);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}