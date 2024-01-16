# Graph Traversal - Depth First Search (DFS)

### Graph Traversal

* All the nodes in the graph are visited during graph traversal, following a specific strategy or order.
* Each node is typically marked as visited during the traversal process.
* The marking of nodes as visited is done to avoid multiple visits to the same node.
* This marking also prevents infinite loops in cyclic graphs.



### Depth-First Search (DFS)

> Depth-First Search (DFS) is a graph traversal algorithm that explores all the nodes in a graph by systematically visiting as far as possible along each branch before backtracking.
>
> \- Design Guru, 2023a



#### DFS Pseudo Code

1. **Initialization**: The algorithm starts from a chosen node (source node), and a data structure ((e.g., an array, a hash set or a stack) is created to keep track of visited nodes.
2. **Visit the Current Node**: The current node is processed.
3. **Recursive Approach**: For each unvisited neighbour of the current node, the DFS function is recursively called with the neighbour as the new current node, which is then marked as visited.
4. **Stack-Based Approach**: The starting node is pushed onto a stack. While the stack is not empty, a node is popped from the stack (current node) and processed. Each unvisited neighbour of the current node is pushed onto the stack and marked as visited.
5. **Backtracking**: If there are no more unvisited neighbours for the current node, the algorithm backtracks by returning from the recursive function or popping nodes from the stack until a node with unvisited neighbours is found.
6. **Termination**: The DFS algorithm terminates when all nodes reachable from the source node have been visited, indicating that all connected components of the graph have been explored.



#### DFS Java Code

```java
import java.util.ArrayList;
import java.util.Stack;

class Graph {
    private int vertices;
    // Using ArrayList instead of HashMap
    private ArrayList<ArrayList<Integer>> adjList;
    // private Map<Integer, List<Integer>> adjacencyList;

    public Graph(int V) {
        vertices = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For an undirected graph
    }
    
    

    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> s = new Stack<>();

        s.push(start);
        visited[start] = true;

        while (!s.isEmpty()) {
            int curr = s.pop();
            System.out.print(curr + " ");

            for (int neighbor : adjList.get(curr)) {
                if (!visited[neighbor]) {
                    s.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.print("DFS Traversal starting from vertex 0: ");
        g.DFS(0);
    }
}

```



#### DFS Time Complexity

* Awesome Explanation :link: [Turin Machines - Time Complexity of Depth First Search (DFS) Algorithm](https://www.youtube.com/watch?v=bP3MWJHeohc).
* The time complexity of the Depth-First Search (DFS) algorithm is O(V + E)
  * V: Number of nodes.
  * E: Number of edges.
* **O(V)**: DFS visits every vertex once and only once. Each visit takes constant time, so the total time spent on visiting all vertices is proportional to the number of vertices, hence O(V).
* **O(E)**: For each vertex, DFS explores its adjacent vertices by traversing the corresponding edges. Since each edge is also traversed once and only once, the total time spent on traversing all edges is proportional to the number of edges, hence O(E).
  * "It is the _**for loop**_ in both the recursion verson or the stack version of the DFS algorithm".



#### DFS Space Complexity

* It’s worth noting that the space complexity of DFS is also important. In the case of a recursive implementation of DFS, the space complexity is O(V) due to the maximum depth of the recursion stack.
* In the worst case, the maximum depth of the recursion stack (or the maximum number of nodes stored in the stack) is the height of the deepest branch of the graph. For a graph with a single connected component, this height can be  (when **all nodes are connected in a straight line**).



### References

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Graph. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33)>. Acesso em: 16 jan. 2024a.
