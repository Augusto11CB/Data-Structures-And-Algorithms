# Graph

According to Kubica (2022), a graph is a set of nodes and a set of edges, and each edge connects a pair of nodes.



What a graph can represent? (KUBICA, 2022):

* Social networks (nodes are people and edges are their connections).
* Transportation networks (nodes are cities and edges represent paths).
* Computer networks (nodes are computers and edges represent the connections between them).



Well-known graph algorithms (KUBICA, 2022):

* Dijkstra’s algorithm for shortest paths.&#x20;
* Prim’s algorithm for minimum-cost spanning trees.
* Kahn’s algorithm for topological sort.



### Graph Types

Graph Types (KUBICA, 2022 e Design Gurus, 2023):

* Undirected graph (represent two-way relationships).

<figure><img src="../../.gitbook/assets/image (15).png" alt=""><figcaption><p>Font: KUBICA, 2022</p></figcaption></figure>

* Directed graph or digraph (represent one-way relationships)_._

<figure><img src="../../.gitbook/assets/image (16).png" alt=""><figcaption><p>Font: KUBICA, 2022</p></figcaption></figure>

* Edge weights graph (capture the link between nodes but also **the cost of that link**).

<figure><img src="../../.gitbook/assets/image (17).png" alt=""><figcaption><p>Font: KUBICA, 2022</p></figcaption></figure>

* Cyclic graph (there is a closed path (sequence of nodes) that starts and ends at the same node).
* Acyclic graph (the **directed** edges arranged such that the graph contains no cycles).

<figure><img src="../../.gitbook/assets/image (18).png" alt=""><figcaption><p>Font: KUBICA, 2022</p></figcaption></figure>



### Common Graph Terminologies

* Digraph: A digraph, short for directed graph.
* Loop in graph: refers to an edge that connects a node to itself.
* Adjacent Nodes: Two nodes are adjacent if an edge is connected directly.
* Degree of a Node: The degree of a node is the number of edges connected to it.
  * The in-degree (number of incoming edges).
  * The out-degree (number of outgoing edges).



### References

KUBICA, Jeremy. Data Structures the Fun Way_._ 2nd ed_._ San Francisco: No Starch Press, 2022.

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Heap. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33)>. Acesso em: 6 jan. 2024a.
