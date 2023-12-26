package com.buenosdev.tree.closestbinarysearchtreevalue;

class ProblemSolution {

    // (Tree) Problem 6: Closest Binary Search Tree Value

    /*
    Given a binary search tree (BST) and a target number, you need to find a node value in the BST that is closest to the given target. A BST is a tree where for every node, the values in the left subtree are smaller than the node, and the values in the right subtree are greater.
    **/

    /*
    Input:

    Tree:
           20
         /    \
        10     30
    Target: 25

    Expected Output: 20

    Justification: 20 and 30 are the closest numbers to 25. However, 20 is closer than 30.
     * */

    private double diff = Integer.MAX_VALUE;
    private int value = -1;

    public int closestValue(TreeNode root, double target) {
        closestValueRecursion(root, target);

        return value;
    }

    public void closestValueRecursion(TreeNode root, double target) {

        if (root == null) return;

        var currentDiff = Math.abs(root.val - target);

        // Check if the current node's value is closer to the target than the previous closest value.
        if (currentDiff < diff) {
            diff = currentDiff;
            value = root.val;
        }

        // Decide the direction to traverse.
        // If the target is less than the current node's value, we move left; otherwise, move right.
        // This decision is made based on the properties of a BST.
        if (root.val > target) {
            closestValueRecursion(root.left, target);

        } else {
            closestValueRecursion(root.right, target);
        }
    }

       /*
        Time Complexity: O(n)
        - In the worst case, we might have to traverse all the nodes in the BST.

        Space Complexity: O(h)
        - where h is the height of the tree. This is because of the depth of the recursion stack, which is determined by the tree height.
        */

    public static void main(String[] args) {
        // Constructing a sample BST for testing.
        TreeNode example1 = new TreeNode(5);
        example1.left = new TreeNode(3);
        example1.left.left = new TreeNode(1);
        example1.left.right = new TreeNode(4);
        example1.right = new TreeNode(8);
        example1.right.left = new TreeNode(6);
        example1.right.right = new TreeNode(9);

        ProblemSolution solution = new ProblemSolution();

        // Test the closestValue function with the target value 6.4.
        System.out.println(solution.closestValue(example1, 6.4)); // Expected output: 6
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
