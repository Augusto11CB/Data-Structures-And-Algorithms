package com.buenosdev.tree.minimumdifferencebts;

class ProblemSolution {

    // (Tree) Problem 3: Minimum Difference Between BST Nodes

    /*
    https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
     **/

    /*
     * */

    public int minDiffInBSTNotWork(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int diffLeft = minDiffInBSTNotWork(root.left);

        int bestDiff = Integer.MAX_VALUE;

        if (root.left != null) {
            bestDiff = Math.min(Math.abs(root.val - root.left.val), diffLeft);
        }

        if (root.right != null) {
            bestDiff = Math.min(Math.abs(root.val - root.right.val), bestDiff);
        }

        return Math.min(minDiffInBSTNotWork(root.right), bestDiff);
    }

    int prev = Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        // inOrder(root);
        // TODO
        return ans;
    }


       /*
        Time Complexity: O(n)
        - where n is the number of nodes in the tree, since we visit each node once.

        Space Complexity: O(h)
        - where h is the height of the tree. This is because of the depth of the recursion stack, which is determined by the tree height.
        */

    public static void main(String[] args) {

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
