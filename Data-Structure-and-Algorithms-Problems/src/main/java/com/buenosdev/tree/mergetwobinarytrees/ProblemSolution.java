package com.buenosdev.tree.mergetwobinarytrees;

class ProblemSolution {

    // (Tree) Problem 7: Merge Two Binary Trees

    /*
    https://leetcode.com/problems/merge-two-binary-trees/
    */


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;

        if (root1 == null) return root2;

        if (root2 == null) return root1;

        var resultLeft = mergeTrees(root1.left, root2.left);
        var resultRight = mergeTrees(root1.right, root2.right);

        var newTreeNode = new TreeNode(root1.val + root2.val);

        newTreeNode.left = resultLeft;
        newTreeNode.right = resultRight;

        return newTreeNode;
    }

    /*
    Time Complexity: O(n1 + n2)
    - In the worst case, each node in both trees needs to be visited once

    Space Complexity:   O(max(h1, h2))
    - Space complexity for the recursion stack
    -  In the worst case, where the trees are completely unbalanced and resemble linked lists, the maximum depth of recursion would be the height of the taller tree.

    Final Space Complexity:   O(max(h1, h2) + n1 + n2)
    - New Nodes creted + recursion stack
    - for each recursive call, a new TreeNode object is created to store the merged values. The space complexity for creating these new nodes is proportional to the number of nodes in the merged tree, which is n1 + n2.
    */

    public static void main(String[] args) {
        // Test the algorithm with given input
        ProblemSolution solution = new ProblemSolution();

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.right = new TreeNode(5);

        TreeNode mergedTree = solution.mergeTrees(tree1, tree2);

        // Print the merged tree using inorder traversal
        printInOrder(mergedTree);
    }

    // Utility method to print tree using inorder traversal
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
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