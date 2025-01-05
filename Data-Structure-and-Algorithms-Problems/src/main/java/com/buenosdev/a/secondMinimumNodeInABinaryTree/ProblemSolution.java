package com.buenosdev.a.secondMinimumNodeInABinaryTree;

class ProblemSolution {

    // because of the property root.val = min(root.left.val, root.right.val)
    // root.val always will be the min element in this binary tree;
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode node) {
         // each node in this tree has exactly two or zero sub-node
        if (node.left == null)
            return -1;

        int l;
        if (node.left != null && node.val == node.left.val) {
            // node.val is either node.left.val or node.right.val.
            // In this case, node.val is equal to node.left.val. What does that mean?
            // It means that in the children of its left child node, there is an element greater than node.left.val (probably the second minimum element).
            // Why is this statement correct? Because the parent node will have the minimum value between its two children.
            l = dfs(node.left);
        } else {
            //   // If the current node's value is different from its left child's value, then the left child's value is the minimum value in its subtree.
            l = node.left.val;
        }

        int r;
        if (node.right != null && node.val == node.right.val) {
            // same logic/discussion in the 'if' for the node.left.val
            r = dfs(node.right);
        } else {
            // If the current node's value is different from its right child's value, then the right child's value is the minimum value in its subtree.
            r = node.right.val;
        }

        // Return the minimum value found among the non-root nodes of the tree.
        // If one of the children does not contain a second minimum value (-1), return the maximum value found in its subtree.
        // Otherwise, return the minimum value found in both subtrees.

        return r == -1 || l == -1 ? Math.max(l, r) : Math.min(l, r);
    }

    public int findSecondMinimumValueFAILED(TreeNode root) {

        if (root == null || root.left == null)
            return -1;

        var dfL = dfsLeft(root.left);
        var dfR = dfsRight(root.right);

        return Math.min(dfL, dfR);

    }

    public int dfsRight(TreeNode node) {
        if (node.left == null && node.right == null)
            return -1;

        if (dfsRight(node.right) == -1) {
            return node.left.val;
        }

        return -1;

    }

    public int dfsLeft(TreeNode node) {
        if (node.left == null && node.right == null)
            return -1;

        if (dfsLeft(node.left) == -1) {
            return node.right.val;
        }

        return -1;
    }

    public class TreeNode {
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