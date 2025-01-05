package com.buenosdev.tree.maxdepth;

class ProblemSolutionReviewA {

    // (Tree) Problem 1: Maximum Depth (or Height) of Binary Tree

    /*
    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     **/

    /*
     * */

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;


        if (root.left == null && root.right == null) return 1;

        if (root.left == null) return maxDepth(root.right) + 1;
        if (root.right == null) return maxDepth(root.left) + 1;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

