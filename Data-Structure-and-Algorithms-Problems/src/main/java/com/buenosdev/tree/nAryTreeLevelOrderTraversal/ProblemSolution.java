package com.buenosdev.tree.nAryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ProblemSolution {

    /*
    https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
     **/

    /*
     * */

    public List<List<Integer>> levelOrder(Node root) {
        var result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        var queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var level = queue.size();
            var partialResult = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                var elementFromQueue = queue.pop();
                if (!elementFromQueue.children.isEmpty()) {
                    queue.addAll(elementFromQueue.children);
                }
                partialResult.add(elementFromQueue.val);
            }

            result.add(partialResult);
        }

        return result;
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


}

