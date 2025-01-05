package com.buenosdev.tree.minimumDistanceBetweenBstNodes;

// class Solution {
//     public int minDiffInBST(TreeNode root) {
//         return inorderTraversal(root, null);

//     }

//     public int inorderTraversal(TreeNode node, TreeNode prev) {

//         if (node == null) {
//             return Integer.MAX_VALUE;
//         }

//         var resp = inorderTraversal(node.left, prev);

//         if (prev != null)
//             resp = Math.min(node.val - prev.val, resp);

//         var right = inorderTraversal(node.right, node);

//         return Math.min(resp, right);

//     }
// }

public class Solution {
    public int minDiffInBST(TreeNode root) {
        int[] prev = new int[]{-1}; // Use array to maintain state across recursive calls
        return inorderTraversal(root, prev);
    }

    private int inorderTraversal(TreeNode node, int[] prev) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // Recurse on the left subtree
        int currentMinDiff = inorderTraversal(node.left, prev);

        // Calculate the current difference if prev is set

        if (prev[0] != -1) {
            currentMinDiff = Math.min(node.val - prev[0], currentMinDiff);
        }

        // Update prev to the current node's value
        prev[0] = node.val;

        // Recurse on the right subtree
        int rightMinDiff = inorderTraversal(node.right, prev);

        // Return the minimum difference found
        return Math.min(currentMinDiff, rightMinDiff);
    }


    private class TreeNode {
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