# Core graph operations

For an adjacency-list graph, the common operations are adding and removing vertices or edges, listing neighbours, testing adjacency, and counting vertices or edges.

| Operation | Typical cost | Notes |
| --- | --- | --- |
| Add a vertex | `O(1)` average | Create an empty neighbour list. |
| Add an edge | `O(1)` amortized | Add it in both directions for an undirected graph. |
| List neighbours | `O(degree(v))` | Traverse the vertex's neighbour list. |
| Test adjacency | `O(degree(v))` | `O(1)` with a set-based neighbour collection. |
| Remove an edge | `O(degree(v))` | Remove the reverse edge too when undirected. |
| Remove a vertex | `O(V + E)` worst case | Remove all incident edges as well. |

The representation determines the trade-off. A matrix makes adjacency tests constant time but consumes `O(V²)` space; a list is space-efficient for sparse graphs but makes edge lookup depend on the degree of the source vertex.
