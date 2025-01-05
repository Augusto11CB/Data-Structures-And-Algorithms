package com.buenosdev.tree.binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class ProblemSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) return result;

        var queue = new LinkedList<TreeNode>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            var level = queue.size();
            var subList = new ArrayList<Integer>();
            for (int i = 0; i < level; i++) {
                var node = queue.poll();
                subList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(subList);
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

/*
private void inOrderHelper(Node<T> node) {
    if (node != null) {
        inOrderHelper(node.left);
        System.out.print(node.data + " ");
        inOrderHelper(node.right);
    }
}

public void inOrder() {
    inOrderHelper(root);
    System.out.println();
}
* */