package com.buenosdev.tree.minimumDepthOfBinaryTree;

import java.util.LinkedList;

class ProblemSolution {

    /*
     * https://leetcode.com/problems/minimum-depth-of-binary-tree/
     * */
    public int minDepthTwo(TreeNode root) {
        if (root == null) return 0;
        var queue = new LinkedList<TreeNode>();
        var result = Integer.MAX_VALUE;
        queue.add(root);
        var auxLevel = 1;
        while (!queue.isEmpty()) {
            var level = queue.size();
            for (int i = 0; i < level; i++) {
                var elementQueue = queue.pop();
                if (elementQueue.left != null) queue.add(elementQueue.left);
                if (elementQueue.right != null) queue.add(elementQueue.right);
                if (elementQueue.left == null && elementQueue.right == null) {
                    return auxLevel;
                }
            }
            auxLevel += 1;
        }
        return result;
    }

    public int minDepth(TreeNode root) {
        // Base case...
        // If the subtree is empty i.e. root is NULL, return depth as 0...
        if (root == null) return 0;
        // Initialize the depth of two subtrees...
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // If the both subtrees are empty...
        if (root.left == null && root.right == null)
            return 1;
        // If the left subtree is empty, return the depth of right subtree after adding 1 to it...
        if (root.left == null)
            return 1 + rightDepth;
        // If the right subtree is empty, return the depth of left subtree after adding 1 to it...
        if (root.right == null)
            return 1 + leftDepth;
        // When the two child function return its depth...
        // Pick the minimum out of these two subtrees and return this value after adding 1 to it...
        return Math.min(leftDepth, rightDepth) + 1;    // Adding 1 is the current node which is the parent of the two subtrees...
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