package com.buenosdev.a.binaryTreePaths;

import java.util.*;

class ProblemSolution {
    public List<String> binaryTreePathsIterative(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, String.valueOf(root.val)));

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            String path = pair.path;

            if (node.left == null && node.right == null) {
                result.add(path);
            }

            if (node.right != null) {
                stack.push(new Pair(node.right, path + "->" + node.right.val));
            }

            if (node.left != null) {
                stack.push(new Pair(node.left, path + "->" + node.left.val));
            }
        }

        return result;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        var result = new ArrayList<String>();
        if (root == null)
            return result;

        dfs(root, result, new StringBuilder());

        return result;

    }

    private void dfs(TreeNode node, List<String> result, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            result.add(sb.toString());
            return;
        }

        sb.append(node.val).append("->");
        if (node.left != null) {
            dfs(node.left, result, new StringBuilder().append(sb.toString()));
        }

        if (node.right != null) {
            dfs(node.right, result, new StringBuilder().append(sb.toString()));
        }

    }

    private class Pair {
        TreeNode node;
        String path;

        Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
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