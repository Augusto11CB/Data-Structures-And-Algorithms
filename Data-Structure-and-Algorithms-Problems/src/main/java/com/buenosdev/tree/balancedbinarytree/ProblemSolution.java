package com.buenosdev.tree.balancedbinarytree;

class ProblemSolution {

    // (Tree) Problem 2: Balanced Binary Tree

    /*
    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
     **/

    /*
     * */

    public boolean isBalanced(TreeNode root) {
        int i = depth(root);

        if (i == -1) return false;
        return true;
    }


    // Method to compute the maximum depth of a binary tree
    public int depth(TreeNode root) {
        // Base case: if node is null, return 0
        if (root == null) return 0;

        int leftDepth = depth(root.left);
        // If the left subtree is unbalanced, we return -1 to indicate it's not balanced
        if (leftDepth == -1)
            return -1;

        int rightDepth = depth(root.right);
        // If the rightt subtree is unbalanced, we return -1 to indicate it's not balanced
        if (rightDepth == -1)
            return -1;

        if (Math.abs(leftDepth - rightDepth) > 1) return -1;

        // Return the maximum of left and right subtree depth plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

       /*
        Time Complexity: O(n)
        - where n is the number of nodes in the tree, since we visit each node once.

        Space Complexity: O(h)
        - where h is the height of the tree. This is because of the depth of the recursion stack, which is determined by the tree height.
        */

    public static void main(String[] args) {
        // Test example 1
        TreeNode example1 = new TreeNode(3);
        example1.left = new TreeNode(9);
        example1.right = new TreeNode(20);
        example1.right.left = new TreeNode(15);
        example1.right.right = new TreeNode(7);

        // Test example 2
        TreeNode example2 = new TreeNode(1);
        example2.left = new TreeNode(2);
        example2.left.left = new TreeNode(3);
        example2.left.left.left = new TreeNode(4);
        example2.right = new TreeNode(5);

        ProblemSolution solution = new ProblemSolution();

        System.out.println(solution.isBalanced(example1)); // Expected output: true
        System.out.println(solution.isBalanced(example2)); // Expected output: false
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}