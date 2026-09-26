# Tree introduction

Trees model hierarchical data: folders in a file system, an organisation chart, a document object model, and a family of recursive subproblems are all natural examples.

## Vocabulary

- The **root** is the only node without a parent.
- A **parent** directly connects to its **children**; nodes with the same parent are **siblings**.
- A **leaf** has no children.
- A node and all of its descendants form a **subtree**.
- A node's **depth** is the number of edges from the root to that node.
- The **height** of a tree is the number of edges on its longest root-to-leaf path.

## Common tree shapes

- A **binary tree** gives every node at most two children.
- A **full binary tree** gives every node either zero or two children.
- A **complete binary tree** fills every level except possibly the last, whose nodes occupy the leftmost positions. Arrays represent complete trees efficiently; heaps use this property.
- A **balanced tree** keeps its height proportional to `log n`, preventing operations from degrading into linear work.
- A **multi-way tree** permits more than two children per node, as in a directory tree or a trie.

For a binary tree of height `h` measured in edges, the maximum number of nodes is `2^(h + 1) - 1`. A tree with `n` nodes cannot be shorter than `⌈log₂(n + 1)⌉ - 1` edges.
