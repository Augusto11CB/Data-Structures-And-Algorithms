package com.buenosdev.tree.levelOrderSuccessor;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

class Solution {
    /*
     * Given a binary tree and a node, find the level order successor of the given node in the tree. The level order successor is the node that appears right after the given node in the level order traversal.
     * */

    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var nodeFromQ = queue.poll();
            if (nodeFromQ.left != null) {
                queue.offer(nodeFromQ.left);
            }

            if (nodeFromQ.right != null) {
                queue.offer(nodeFromQ.right);
            }

            // As soon as we find the given node, we will return the next node from the queue as the level order successor.
            if (nodeFromQ.val == key) {
                break;
            }
        }

        return queue.poll();
    }

}
