package com.buenosdev.tree.binarytree.sumNumbers;

import com.buenosdev.trie.TrieNodeHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

class ProblemSolution {
    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    // postOrder traversal
    private int dfs(TreeNode node, int sum) {
        // If the node is null (base case), return 0
        if (node == null) return 0;

        // Calculate the sum until this node by shifting the previous sum one place to the left (multiplying by 10) and adding the value of the current node
        var sumUntilHere = (10 * sum) + node.val;

        // If the node is a leaf (it has no children), return the sum until this node
        if (node.left == null && node.right == null) {
            return sumUntilHere;
        }

        // If the node is not a leaf, recursively call the dfs function for its left and right children, and return the sum of these two calls
        return dfs(node.left, sumUntilHere) + dfs(node.right, sumUntilHere);
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
