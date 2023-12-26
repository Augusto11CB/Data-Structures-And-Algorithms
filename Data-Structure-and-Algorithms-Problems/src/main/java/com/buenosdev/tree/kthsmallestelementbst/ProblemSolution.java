package com.buenosdev.tree.kthsmallestelementbst;

class ProblemSolution {

    // (Tree) Problem 5: Kth Smallest Element in a BST

    /*
    https://leetcode.com/problems/kth-smallest-element-in-a-bst/
     **/

    /*
     * */

    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {

        // Let's use in-order traversal because we can use the in-order traversal property of visiting nodes in ascending order.
        if (root == null) {
            return 0;
        }

        var leftResult = kthSmallest(root.left, k);

        // If counter is equal to or greater than K, we do not need to search for the Kth element in the current node, nor in the right sub-tree.
        if (counter >= k) {
            return leftResult;
        }

        // Contabilize the current knot
        counter = counter + 1;

        // If after increasing the counter by 1 to consider the current node, the counter is still less than K, then search for the Kth element in the right subtree;
        if (counter < k) {
            return kthSmallest(root.right, k);
        } else {
            return root.val;
        }
    }


       /*
        Time Complexity: O(n)
        - In the worst case, we might have to traverse all the nodes in the BST.

        Space Complexity: O(h)
        - where h is the height of the tree. This is because of the depth of the recursion stack, which is determined by the tree height.
        */

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

        ProblemSolution solution = new ProblemSolution();

        // Test the kthSmallest method.
        System.out.println(solution.kthSmallest(example1, 4));  // Expected output: 6
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
