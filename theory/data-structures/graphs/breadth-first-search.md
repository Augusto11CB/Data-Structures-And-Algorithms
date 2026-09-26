# Breadth-first search

Breadth-first search (BFS) visits vertices in layers: it visits all vertices one edge away from the source before vertices two edges away, and so on. A queue enforces that order.

## When to use it

- Find a shortest path by number of edges in an unweighted graph.
- Find all vertices within a given number of steps.
- Traverse a graph level by level.
- Test reachability or explore connected components.

## Pseudocode

```text
BFS(graph, start):
    visited = {start}
    queue = [start]

    while queue is not empty:
        vertex = queue.dequeue()
        visit(vertex)

        for neighbour in graph.neighbours(vertex):
            if neighbour not in visited:
                visited.add(neighbour)
                queue.enqueue(neighbour)
```

Mark a vertex visited when it is enqueued, not when it is removed from the queue. That prevents it from entering the queue more than once in a cyclic graph.

With an adjacency list, BFS runs in `O(V + E)` time and uses `O(V)` auxiliary space for the queue and visited set. To reconstruct a shortest path, store each discovered vertex's parent.
