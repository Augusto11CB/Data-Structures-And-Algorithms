package com.buenosdev.a.hasPathSum;

class ProblemSolution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int currentSum) {
        if (root == null && currentSum == targetSum) return true;
        if (root == null && currentSum != targetSum) return false;
        var newCurrentSum = currentSum + root.val;
        if (root.right == null && root.left == null && newCurrentSum == targetSum) return true;
        return dfs(root.right, targetSum, newCurrentSum) || dfs(root.left, targetSum, newCurrentSum);

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