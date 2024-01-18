# Graph Traversal - Breadth First Search (BFS)

### Graph Traversal

* All the nodes in the graph are visited during graph traversal, following a specific strategy or order.
* Each node is typically marked as visited during the traversal process.
* The marking of nodes as visited is done to avoid multiple visits to the same node.
* This marking also prevents infinite loops in cyclic graphs.



### Breadth First Search (BFS)

> Breadth-First Search (BFS) is a graph traversal algorithm that explores a graph's vertices (nodes) level by level. It starts from a selected source node and moves outward to visit all the nodes at the same distance from the source before moving on to nodes at the following distance level.
>
> \- DesignGurus, 2023a



#### Where BFS is Useful?

BFS is useful for finding the **shortest path** in unweighted graphs and for **systematically exploring graphs**. Also, it can be useful for detecting cycles.



#### BFS Pseudo Code

1. **Initialisation**: The algorithm starts from a chosen node (source node), and a queue is created to hold the nodes to be visited. The source node is marked as visited and enqueued into the queue.
   * The queue follows the First-In-First-Out (FIFO) principle and is responsible to keep track of the nodes to be visited.
2. **Traversal**: While the queue is not empty, a node is dequeued from the front of the queue (current node) and processed. All the unvisited neighbours of the current node are enqueued into the queue and marked as visited.
   * The BFS property of breadth graph exploration is guaranteed by using a queue FIFO instead of a stack.
3. **Termination**: The BFS algorithm continues until the queue becomes empty, meaning all nodes reachable from the source node have been visited.



#### DFS Java Code

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int V; // Number of nodes
    private ArrayList<ArrayList<Integer>> adjList;

    public Graph(int nodes) {
        V = nodes;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void BFS(int startNode) {
        boolean[] visited = new boolean[V]; // To keep track of visited nodes
        Queue<Integer> q = new LinkedList<>();

        visited[startNode] = true;
        q.add(startNode);

        while (!q.isEmpty()) {
            int currentNoded = q.poll();
            System.out.print(currentNoded + " ");

            // Explore adjacent nodes
            for (int neighbor : adjList.get(currentNoded)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}
```

```java
class Solution {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Create a graph with 6 nodes

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        System.out.println("Breadth-First Traversal starting from Node 0:");
        graph.BFS(0);
    }
}
```



#### BFS Time Complexity

* Awesome Explanation :link: [Turin Machines - Time Complexity of Depth First Search (DFS) Algorithm](https://www.youtube.com/watch?v=bP3MWJHeohc).
* The time complexity of the  BFS algorithm is O(V + E)
  * V: Number of nodes.
  * E: Number of edges.
* **O(V)**: BFS visits every node once and only once. Each visit takes constant time, so the total time spent on visiting all nodes is proportional to the number of nodes, hence O(V).
* **O(E)** : Additionally, for each node, it is explored all its neighbours once, which takes time O(E) in total (sum of the sizes of all adjacency lists).
  * Since each edge is also traversed once and only once, the total time spent on traversing all edges is proportional to the number of edges, hence O(E).
  * "It is the _**for loop**_ in both the recursion version or the stack version of the BFS algorithm".



#### BFS Space Complexity

* The space required to store the graph using an adjacency list representation is O(V + E) , as we need to store each node and its corresponding edges.
* The space required for the queue in BFS is O (V) in the worst case, as all the nodes can be in the queue at once.



### References

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Graph. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33)>. Acesso em: 16 jan. 2024a.
