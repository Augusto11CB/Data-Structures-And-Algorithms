package com.buenosdev.tree.mergetwobinarytrees;

import java.util.Stack;

class ProblemSolutionV2 {

    public TreeNode mergeTrees(TreeNode r1, TreeNode r2) {
        var stack = new Stack<TreeNode>();
        stack.push(r1);
        stack.push(r2);
        if (r1 == null) return r2;
        while (!stack.isEmpty()) {
            TreeNode two = stack.pop();
            TreeNode one = stack.pop();
            if (one != null && two != null) {
                one.val += two.val;
                if (one.left == null) one.left = two.left;
                else {
                    stack.push(one.left);
                    stack.push(two.left);
                }

                if (one.right == null) one.right = two.right;
                else {
                    stack.push(one.right);
                    stack.push(two.right);
                }
            }
        }
        return r1;
    }

    /*
    Time Complexity: O(min(n,m))
    - where n and m are the numbers of nodes in the first and second trees respectively.

    Space Complexity:  O(max(n,m))
    -  as we're creating a new tree with that many nodes.
    */

    public static void main(String[] args) {
        // Test the algorithm with given input
        ProblemSolutionV2 solution = new ProblemSolutionV2();

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

