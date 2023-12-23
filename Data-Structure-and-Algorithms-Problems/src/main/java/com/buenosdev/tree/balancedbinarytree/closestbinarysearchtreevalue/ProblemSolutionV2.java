package com.buenosdev.tree.balancedbinarytree.closestbinarysearchtreevalue;

public class ProblemSolutionV2 {

    // Iteratively traverse the tree, comparing the target with the current node's value.
        // If the target is closer to the current node than the closest value found so far, update the closest value.
    // Depending on whether the target is greater or smaller than the current node's value, move to the RIGHT or LEFT child.

    public int closestValue(TreeNode root, double target) {

        // Initialize the closest value to the root's value.
        // This acts as a running minimum difference tracker.
        int closestVal = root.val;

        // Traverse the tree starting from the root.
        while (root != null) {

            // Check if the current node's value is closer to the target than the previous closest value.
            // If so, update closestVal.
            if (Math.abs(target - root.val) < Math.abs(target - closestVal)) {
                closestVal = root.val;
            }

            // Decide the direction to traverse.
            // If the target is less than the current node's value, we move left; otherwise, move right.
            // This decision is made based on the properties of a BST.
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        // Once we've traversed all possible paths, return the closest value.
        return closestVal;
    }

    public static void main(String[] args) {
        // Constructing a sample BST for testing.
        TreeNode example1 = new TreeNode(5);
        example1.left = new TreeNode(3);
        example1.left.left = new TreeNode(1);
        example1.left.right = new TreeNode(4);
        example1.right = new TreeNode(8);
        example1.right.left = new TreeNode(6);
        example1.right.right = new TreeNode(9);

        ProblemSolutionV2 solution = new ProblemSolutionV2();

        // Test the closestValue function with the target value 6.4.
        System.out.println(solution.closestValue(example1, 6.4)); // Expected output: 6
    }
}
