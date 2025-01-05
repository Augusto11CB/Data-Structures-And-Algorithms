package com.buenosdev.tree.binarytree.findACorrespondingNodeOfABinaryTreeInACloneOfThatTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {


    public final TreeNode getTargetCopyDFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        var stack = new ArrayDeque<TreeNode>();
        var stackClone = new ArrayDeque<TreeNode>();

        // stack.push(original)
        // stackClone.push(cloned)

        var node = original;
        var nodeClone = cloned;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                stackClone.push(nodeClone);

                node = node.left;
                nodeClone = nodeClone.left;
            }

            node = stack.pop();
            nodeClone = stackClone.pop();

            if (node.equals(target)) {
                return nodeClone;
            }

            node = node.right;
            nodeClone = nodeClone.right;
        }

        return null;

    }

    public final TreeNode getTargetCopyBFS(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        var queue = new LinkedList<TreeNode>();
        var queueClone = new LinkedList<TreeNode>();

        queue.add(original);
        queueClone.add(cloned);

        TreeNode result = null;
        while (!queue.isEmpty()) {
            var queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                var poped = queue.pop();
                var popedClone = queueClone.pop();
                if (poped.equals(target)) {
                    return popedClone;

                } else {
                    if (poped.left != null) {
                        queue.add(poped.left);
                        queueClone.add(popedClone.left);
                    }
                    if (poped.right != null) {
                        queue.add(poped.right);
                        queueClone.add(popedClone.right);
                    }
                }
            }
        }
        return result;
    }

    public final TreeNode getTargetCopyBFSII(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Deque<TreeNode> queueO = new ArrayDeque();
        queueO.offer(original);

        Deque<TreeNode> queueC = new ArrayDeque();
        queueC.offer(cloned);

        while (!queueO.isEmpty()) {
            TreeNode nodeO = queueO.poll();
            TreeNode nodeC = queueC.poll();

            if (nodeO == target) {
                return nodeC;
            }

            if (nodeO.left != null) {
                queueO.offer(nodeO.left);
                queueC.offer(nodeC.left);
            }
            if (nodeO.right != null) {
                queueO.offer(nodeO.right);
                queueC.offer(nodeC.right);
            }
        }
        return null;
    }

    private class TreeNode {
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