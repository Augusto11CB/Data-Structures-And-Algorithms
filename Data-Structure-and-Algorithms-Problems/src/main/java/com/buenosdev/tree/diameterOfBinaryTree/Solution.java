package com.buenosdev.tree.diameterOfBinaryTree;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        var max = new int[]{0};
        findDepthAndAltersArrayMaxWithDiamter(root, max);

        return max[0];


    }

    private int findDepthAndAltersArrayMaxWithDiamter(TreeNode node, int[] max) {

        // if(node.left == null && node.right == null) {
        //     return prev+1;
        // }

        if (node == null) return 0;

        var lL = 0;
        if (node.left != null)
            lL = findDepthAndAltersArrayMaxWithDiamter(node.left, max);

        var rL = 0;

        if (node.right != null)
            rL = findDepthAndAltersArrayMaxWithDiamter(node.right, max);


        var diam = rL + lL;

        max[0] = Math.max(diam, max[0]); // storing the largest diamter

        return Math.max(rL, lL) + 1; // return the height
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