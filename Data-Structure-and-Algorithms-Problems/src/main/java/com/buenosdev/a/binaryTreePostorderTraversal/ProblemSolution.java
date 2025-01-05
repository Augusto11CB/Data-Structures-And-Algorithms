package com.buenosdev.a.binaryTreePostorderTraversal;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class ProblemSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        var result = new LinkedList<Integer>();
        if (root == null) {
            return result;
        }
        var stack = new ArrayDeque<TreeNode>(); // stack

        var node = root;

        while (node != null) {
            result.addFirst(node.val); // Reverse the process of preorder
            if (node.left != null) stack.push(node.left);
            node = node.right;
            if (node == null && !stack.isEmpty()) node = stack.pop();
        }

        return result;
    }

    // It is almost the preorderTraversal, but pay attention in the ans.addFirst(,,,)
    // without it we are doing the postOrder;
    public List<Integer> postorderTraversalIterativeV2(TreeNode root) {
        var a = new Integer[]{1,2,3};
        List<Integer> list = Arrays.asList(a);
        var ans = new LinkedList<Integer>();
        ans.addAll(list);
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
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