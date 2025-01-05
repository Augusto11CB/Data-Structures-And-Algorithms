package com.buenosdev.tree.binaryTreeLevelReverseOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ProblemSolution {

    /*
     * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
     * */

    // DFS
    public List<List<Integer>> levelOrderBottomT(TreeNode root) {
        var result = new LinkedList<List<Integer>>();

        if (root == null) return result;

        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var level = queue.size();
            var subList = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                var node = queue.pop();
                subList.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(0, subList);
        }
        return result;
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