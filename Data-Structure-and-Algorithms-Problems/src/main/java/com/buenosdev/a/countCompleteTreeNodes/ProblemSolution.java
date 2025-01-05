package com.buenosdev.a.countCompleteTreeNodes;


import java.util.LinkedList;

class ProblemSolution {
    public int countNodesWRONG(TreeNode root) {
        if (root == null) return 0;
        var result = 0;

        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            var node = queue.pop();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            result++;
        }
        return result;
    }

    // The height of a tree is defined as the number of edges on the longest path from the root to a leaf. For example, a tree with a single node (the root) has a height of 0.
    // For a complete binary tree, if the height is h, the number of nodes is given by (2^(h+1)) -1
    // This formula arises because a complete binary tree of height h has h+1 levels, and the number of nodes at each level doubles as you move down the tree.
    // For a tree where height is 2 (meaning there are 3 levels: 0, 1, and 2):
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeightLeft(root);
        int rightHeight = getHeightRight(root);

        // If left and right are equal, it means that the tree is complete, and hence go for 2^(left + 1) - 1.
        // left + 1: This adjustment accounts for the fact that the height is zero-based, while the levels are one-based. Therefore, left + 1 correctly represents the total number of levels.
        if (leftHeight == rightHeight) return (int) Math.pow(2, leftHeight + 1) - 1;

        // Else recursively calculate the number of nodes in left and right and add 1 for the root.
        else return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int getHeightLeft(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int getHeightRight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
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