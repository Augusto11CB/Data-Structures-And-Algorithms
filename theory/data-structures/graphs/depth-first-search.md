# Depth-first search

Depth-first search (DFS) follows a branch as far as possible before backtracking. It can be implemented recursively or with an explicit stack.

## When to use it

- Test reachability and enumerate connected components.
- Detect cycles.
- Search paths and backtracking state spaces.
- Produce a topological ordering of a DAG.

## Recursive pseudocode

```text
DFS(graph, vertex, visited):
    visited.add(vertex)
    visit(vertex)

    for neighbour in graph.neighbours(vertex):
        if neighbour not in visited:
            DFS(graph, neighbour, visited)
```

## Iterative pseudocode

```text
DFS(graph, start):
    visited = {start}
    stack = [start]

    while stack is not empty:
        vertex = stack.pop()
        visit(vertex)

        for neighbour in graph.neighbours(vertex):
            if neighbour not in visited:
                visited.add(neighbour)
                stack.push(neighbour)
```

With an adjacency list, DFS runs in `O(V + E)` time. Its auxiliary space is `O(V)` in the worst case: the recursive call stack or explicit stack can contain every vertex on a long path.
