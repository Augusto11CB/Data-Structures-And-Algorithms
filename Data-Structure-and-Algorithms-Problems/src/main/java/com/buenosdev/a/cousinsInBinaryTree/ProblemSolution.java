package com.buenosdev.a.cousinsInBinaryTree;

class ProblemSolution {
    public boolean isCousins(TreeNode root, int x, int y) {
        var t = new int[2][2];
        isCousins(root, x, y, t, 1);

        if (t[0][0] == t[1][0] && t[0][1] != t[1][1]) return true;
        else return false;
    }

    private int isCousins(TreeNode root, int x, int y, int[][] t, int level) {
        if (root == null) return -1;
        if (root.val == x) return 0;
        if (root.val == y) return 1;

        var leftAns = isCousins(root.left, x, y, t, level + 1);

        if (leftAns >= 0) {
            t[leftAns][0] = level;
            t[leftAns][1] = root.val;
        }

        var rightAns = isCousins(root.right, x, y, t, level + 1);

        if (rightAns >= 0) {
            t[rightAns][0] = level;
            t[rightAns][1] = root.val;
        }

        return -1;

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