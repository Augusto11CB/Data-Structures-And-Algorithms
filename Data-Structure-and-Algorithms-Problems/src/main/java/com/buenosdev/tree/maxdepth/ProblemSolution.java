package com.buenosdev.tree.maxdepth;

class ProblemSolution {

    // (Tree) Maximum Depth (or Height) of Binary Tree

    /*
    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     **/

    /*
     * */

    public int maxDepth(TreeNode root) {
        var leftDepth = 0;
        var rightDepth = 0;
        if (root != null) {
            leftDepth = maxDepth(root.left);
            rightDepth = maxDepth(root.right);
            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
        return 0;
    }

    // Method to compute the maximum depth of a binary tree
    public int maxDepthV2(TreeNode root) {
        // Base case: if node is null, return 0
        if (root == null) return 0;

        // Recursively calculate left subtree depth
        int leftDepth = maxDepthV2(root.left);

        // Recursively calculate right subtree depth
        int rightDepth = maxDepthV2(root.right);

        // Return the maximum of left and right subtree depth plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

       /*
        Time Complexity: O(n)
        - where n is the number of nodes in the tree, since we visit each node once.

        Space Complexity: O(h)
        - where h is the height of the tree. This is because of the depth of the recursion stack, which is determined by the tree height.
        */

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}