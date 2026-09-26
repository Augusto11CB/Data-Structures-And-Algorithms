# Graph problem-solving patterns

## Choose a starting set in a DAG

If a directed acyclic graph must be reached from the fewest possible starting vertices, every vertex with in-degree zero must be selected: no other vertex can reach it. Those vertices are also sufficient because every other vertex has an incoming path from one of them.

This pattern appears in [Minimum Number of Vertices to Reach All Nodes](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/).

## Shortest path in an unweighted graph

Use BFS. The first time BFS reaches a vertex, it has found a path with the fewest edges. Keep a parent map if the path itself is required.

## Reachability and connected components

Run BFS or DFS from an unvisited vertex. Every visited vertex belongs to the same component. Repeat from another unvisited vertex to count all components.

## Detecting cycles

- In an undirected graph, DFS can detect an edge to an already visited vertex that is not the current vertex's parent.
- In a directed graph, track vertices currently on the DFS recursion path; encountering one again is a back edge and therefore a cycle.

## Before choosing an algorithm

Ask four questions:

1. Is the graph directed or undirected?
2. Are edges weighted? If so, can weights be negative?
3. Do you need the shortest distance, an actual path, reachability, an ordering, or a cycle check?
4. Is the graph sparse enough that an adjacency list is the appropriate representation?
