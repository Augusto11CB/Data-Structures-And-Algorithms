package com.buenosdev.a.maximumDepthOfNAryTree;

import java.util.*;

class Solution {
    public int maxDepth(Node root) {

        if (root == null)
            return 0;

        var maxDepth = 0;

        for (Node node : root.children) {
            maxDepth = Math.max(maxDepth(node), maxDepth);
        }

        return maxDepth + 1;

    }

    public int maxDepthIterative(Node root) {
        if (root == null)
            return 0;

        var queue = new LinkedList<Node>();

        queue.offer(root);

        var depth = 0;

        while (!queue.isEmpty()) {
            var qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                var node = queue.poll();

                for (Node n : node.children) {
                    queue.offer(n);
                }

            }

            depth += 1;

        }

        return depth;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}