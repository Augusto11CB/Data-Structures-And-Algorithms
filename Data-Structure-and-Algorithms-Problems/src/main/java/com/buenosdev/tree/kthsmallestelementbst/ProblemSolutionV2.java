package com.buenosdev.tree.kthsmallestelementbst;

public class ProblemSolutionV2 {

    // `count` keeps track of the number of nodes we've traversed in-order.
    private int count = 0;

    // `result` will hold our final answer.
    private int result = 0;


    // This method is the public API that finds the kth smallest element in a BST.
    public int kthSmallest(TreeNode root, int k) {
        // Start the in-order traversal.
        traverse(root, k);

        // Once traversal is done, the `result` will hold our answer.
        return result;
    }

    // A recursive function to do an in-order traversal of the BST.
    // We stop traversing once we've visited `k` nodes.
    private void traverse(TreeNode node, int k) {
        // If the current node is null or we've already traversed k nodes, return.
        if (node == null || count >= k)
            return;

        // First, traverse the left subtree.
        traverse(node.left, k);

        // Increment the counter for the current node.
        count++;

        // If we've traversed exactly k nodes, this is our result.
        if (count == k)
            result = node.val;

        // Finally, traverse the right subtree.
        traverse(node.right, k);
    }

    public static void main(String[] args) {
        // Constructing the tree for testing.
        TreeNode example1 = new TreeNode(8);
        example1.left = new TreeNode(3);
        example1.left.left = new TreeNode(1);
        example1.left.right = new TreeNode(6);
        example1.left.right.left = new TreeNode(4);
        example1.left.right.right = new TreeNode(7);
        example1.right = new TreeNode(10);
        example1.right.right = new TreeNode(14);
        example1.right.right.left = new TreeNode(13);

        ProblemSolutionV2 solution = new ProblemSolutionV2();

        // Test the kthSmallest method.
        System.out.println(solution.kthSmallest(example1, 4));  // Expected output: 6
    }
}
