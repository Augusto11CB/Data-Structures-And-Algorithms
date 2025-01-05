package com.buenosdev.a.symmetricTree;

class ProblemSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode rootL, TreeNode rootR) {
        if (rootL == null && rootR != null) return false;
        if (rootL != null && rootR == null) return false;
        if (rootL == null && rootR == null) return true;

        if (rootR.val != rootL.val) return false;

        return dfs(rootL.left, rootR.right) && dfs(rootL.right, rootR.left);

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