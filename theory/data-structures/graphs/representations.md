# Graph representations

Choose a representation based on which operations the problem needs most often.

| Representation | Space | Check whether `(u, v)` is an edge | Iterate neighbours of `u` | Best fit |
| --- | --- | --- | --- | --- |
| Adjacency matrix | `O(V²)` | `O(1)` | `O(V)` | Dense graphs or frequent edge lookups |
| Adjacency list | `O(V + E)` | `O(degree(u))` | `O(degree(u))` | Sparse graphs and traversal algorithms |

## Adjacency matrix

An adjacency matrix has one row and one column per vertex. The value at row `u`, column `v` indicates whether an edge from `u` to `v` exists; it can instead store a weight.

For an undirected graph, the matrix is symmetric: an edge between `u` and `v` is stored at both `(u, v)` and `(v, u)`.

## Adjacency list

An adjacency list maps each vertex to its outgoing neighbours. It is normally the better default for interview-style and real-world sparse graphs because it only stores edges that exist.

For an undirected graph, add each edge to both lists. For a directed graph, add it only to the source vertex's list.

```text
addDirectedEdge(u, v):
    adjacency[u].append(v)

addUndirectedEdge(u, v):
    adjacency[u].append(v)
    adjacency[v].append(u)
```
