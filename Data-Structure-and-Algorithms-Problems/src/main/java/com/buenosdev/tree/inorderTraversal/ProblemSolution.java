package com.buenosdev.tree.inorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class ProblemSolution {

    public List<Integer> inorderTraversalIterativeWay(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        var node = root;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.offer(node);
                node = node.left;
            } else {
                node = stack.poll();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new LinkedList<>() {{add(root.val);}};
        }

        List<Integer> list = new ArrayList<Integer>();
        if (root.left != null) {
            list = inorderTraversal(root.left);
        }
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        list.add(root.val);

        return list;
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