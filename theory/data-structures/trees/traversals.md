# Tree traversals

Traversals define the order in which a tree's nodes are visited. For a tree with `n` nodes, each standard traversal takes `O(n)` time. Recursive traversals use `O(h)` call-stack space, where `h` is the tree height.

## Depth-first traversals

| Traversal | Visit order | Common use |
| --- | --- | --- |
| Pre-order | node, left, right | Copying or serializing a tree |
| In-order | left, node, right | Producing sorted order from a BST |
| Post-order | left, right, node | Deleting a tree or evaluating expression trees |

```text
inOrder(node):
    if node is null:
        return
    inOrder(node.left)
    visit(node)
    inOrder(node.right)
```

## Breadth-first traversal

Level-order traversal visits nodes one level at a time. It uses a queue, making it useful for questions about a tree's width, minimum depth, or values grouped by depth.

```text
levelOrder(root):
    queue = [root]
    while queue is not empty:
        node = queue.dequeue()
        visit(node)
        enqueue each non-null child of node
```

In the worst case, the queue can contain an entire level of the tree, requiring `O(n)` auxiliary space.
