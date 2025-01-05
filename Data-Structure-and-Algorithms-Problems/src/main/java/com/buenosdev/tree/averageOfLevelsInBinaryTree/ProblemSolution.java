package com.buenosdev.tree.averageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ProblemSolution {

    /*
    * https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
    * */

    public List<Double> averageOfLevels(TreeNode root) {
        var result = new ArrayList<Double>();
        if (root == null) return result;
        var queue = new LinkedList<TreeNode>();

        queue.add(root);
        while (!queue.isEmpty()) {
            var level = queue.size();
            var sum = 0.0;
            for (int i = 0; i < level; i++) {
                var elementQueue = queue.pop();
                if (elementQueue.left != null) queue.add(elementQueue.left);
                if (elementQueue.right != null) queue.add(elementQueue.right);
                sum += elementQueue.val;
            }
            result.add((sum / level));
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