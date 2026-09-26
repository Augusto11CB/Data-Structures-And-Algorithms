# Trie node representations

Every trie node needs a collection of outgoing edges and a terminal marker. The right collection depends on the alphabet and memory constraints.

| Children representation | Lookup | Memory per node | Best fit |
| --- | --- | --- | --- |
| Fixed array | `O(1)` | `O(A)` | Small, fixed alphabet of size `A` |
| Map or hash table | `O(1)` average | Proportional to existing children | Sparse or variable alphabets |
| Sorted map | `O(log d)` | Proportional to existing children | Ordered child iteration, where `d` is the node degree |

## Fixed array

For words limited to `a` through `z`, an array of 26 child references gives predictable constant-time transitions. It is fast but wasteful when most nodes have only one or two children.

## Map-based children

A map stores only characters that actually occur after a prefix. This is generally more space-efficient for sparse tries and supports Unicode or a changing alphabet without a fixed index conversion.

## Compressed tries

When many nodes have exactly one child, a radix tree (compressed trie) can merge consecutive edges into a string segment. It reduces node overhead while preserving prefix-oriented lookup.
