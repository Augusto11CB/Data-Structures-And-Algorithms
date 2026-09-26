# Binary search trees

A binary search tree (BST) is a binary tree with an ordering invariant. For every node `x`:

- every value in `x`'s left subtree compares less than `x`; and
- every value in `x`'s right subtree compares greater than `x`.

If duplicates are allowed, define the policy explicitly—for example, store a count in the node or consistently place equal values on one side.

## Operations

Search, insertion, and deletion follow one root-to-leaf path, so their cost depends on the tree height `h`.

| Operation | Balanced BST | Degenerate BST |
| --- | --- | --- |
| Search | `O(log n)` | `O(n)` |
| Insert | `O(log n)` | `O(n)` |
| Delete | `O(log n)` | `O(n)` |

A BST can degenerate into a linked list when values arrive in sorted order. Self-balancing trees such as AVL and red-black trees maintain logarithmic height at the cost of more complex updates.

## Deleting a node

Deletion has three cases:

1. A leaf can be removed directly.
2. A node with one child is replaced by that child.
3. A node with two children is replaced by its in-order successor (the smallest value in its right subtree) or predecessor, then that replacement node is removed.

The in-order traversal of a BST yields keys in sorted order, which is a useful invariant for validating an implementation.
