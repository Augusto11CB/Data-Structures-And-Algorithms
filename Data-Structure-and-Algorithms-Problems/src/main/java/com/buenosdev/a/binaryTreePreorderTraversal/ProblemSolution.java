package com.buenosdev.a.binaryTreePreorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ProblemSolution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.left != null) {
            list.addAll(preorderTraversal(root.left));
        }
        if (root.right != null)
            list.addAll(preorderTraversal(root.right));

        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }
        return list;
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        var result = new ArrayList<Integer>();
        if (root == null)
            return result;

        var stack = new ArrayDeque<TreeNode>();
        var node = root;

        while (node != null) {
            result.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            node = node.left;
            if (node == null && !stack.isEmpty())
                node = stack.pop();
        }

        return result;

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