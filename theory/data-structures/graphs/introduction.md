# Graph introduction

A graph is a set of vertices connected by edges. It is useful whenever the important part of a problem is the relationship between entities: social connections, routes between cities, prerequisites, and computer networks are common examples.

## Types of graphs

- **Undirected:** an edge connects both vertices in both directions, such as a friendship.
- **Directed:** an edge has a direction, such as a course prerequisite or a link on the web.
- **Weighted:** each edge has a cost, distance, capacity, or other value.
- **Cyclic:** at least one path starts and ends at the same vertex without repeating an edge.
- **Acyclic:** contains no cycles. A directed acyclic graph (DAG) is especially useful for dependencies and topological ordering.

## Terminology

- Two vertices are **adjacent** when an edge directly connects them.
- A vertex's **degree** is its number of incident edges. In directed graphs, distinguish **in-degree** and **out-degree**.
- A **path** is a sequence of adjacent vertices.
- A **connected component** is a maximal set of vertices reachable from one another in an undirected graph.

## Common algorithms

- Breadth-first search (BFS) explores by distance from a starting vertex.
- Depth-first search (DFS) explores one branch deeply before backtracking.
- Dijkstra's algorithm finds shortest paths with non-negative edge weights.
- Topological sort orders the vertices of a DAG.
- Minimum-spanning-tree algorithms such as Prim's and Kruskal's select low-cost connections.

## References

- Jeremy Kubica, *Data Structures the Fun Way*, 2nd ed., No Starch Press, 2022.
