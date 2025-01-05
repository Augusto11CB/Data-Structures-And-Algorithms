package com.buenosdev.tree.nAryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

class ProblemSolutionReviewA {

    /*
    https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
     **/

    /*
     * DFS
     * */

    public List<List<Integer>> levelOrder(Node root) {
        var result = new ArrayList<List<Integer>>();
        // TODO

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

