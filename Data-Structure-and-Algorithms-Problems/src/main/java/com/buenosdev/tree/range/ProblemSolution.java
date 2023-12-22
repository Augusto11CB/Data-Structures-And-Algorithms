package com.buenosdev.tree.range;

class ProblemSolution {

    // (Tree) Problem 4: Range Sum of BST

    /*
    https://leetcode.com/problems/range-sum-of-bst/
     **/

    /*
     * */

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null) {
            return 0;
        }

        // Since it's a BST, if the current node's value is greater than high, there's no need to explore its right subtree
        if (root.val > R) return rangeSumBST(root.left, L, R);
        // if the current node's value is less than low, ignore its left subtree.
        if (root.val < L) return rangeSumBST(root.right, L, R);

        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;

    }


       /*
        Time Complexity: O(n)
        - In the worst case, we might have to traverse all the nodes in the BST.

        Space Complexity: O(h)
        - where h is the height of the tree. This is because of the depth of the recursion stack, which is determined by the tree height.
        */

    public static void main(String[] args) {
        // Test using the examples provided
        TreeNode example1 = new TreeNode(10);
        example1.left = new TreeNode(5);
        example1.left.left = new TreeNode(3);
        example1.left.right = new TreeNode(7);
        example1.right = new TreeNode(15);
        example1.right.right = new TreeNode(18);

        ProblemSolution solution = new ProblemSolution();
        System.out.println(solution.rangeSumBST(example1, 7, 15));  // Expected output: 32
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
