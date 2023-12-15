# Heap

### What’s a heap?

A heap is a tree-like data structure where each node must be ordered with respect to the value of its children. There are two types of heap: max heap and min heap. In a max heap, parent node values are greater than those of their children, whereas the opposite is true in a min heap.



### Why Study Heap ?

A heap is a useful and efficient way to store and look up data that must maintain order. An practical implementation of heap in the real world is priority queue.

Priority queue is a set of data where higher or lower valued data points to the front of the queue and are therefore accessed first.



### Priority queues

Priority queues are frequently implemented as binary heap.

* enqueue and extract-min/max run in time O(log n);
* findmin runs in time O(1)
* :information\_source: Awesome video from WILLIAN FISET explaining Priority Queue/Heaps :link:[Priority Queue Intro](https://www.youtube.com/watch?app=desktop\&v=wptevk0bshY):link:



### Heap Important Features

**Definition:** We define the “height” of a node in a heap to be the number of edges on the longest simple downward path from the node to a leaf. The height of a heap is the height of its root.

**Fact:** A heap of n nodes has a height of blog nc. (Why? Hint: if a heap has height h, what are the minimum and maximum possible number of elements in it? Answer: 2h ≤ n ≤ 2 h+1 − 1)

Definition: The “max-heap property” (of a heap A) is the property we were talking about, where for every node i other than the root, A\[parent\[i]] ≥ A\[i]. The “min-heap property” is defined analogously.

* Its left child has index 2i
* Its right child has index 2i + 1
* Its parent has index bi/2c
* the number of non-leaves nodes are `|_n/2_|`
* The leaves of the heap are the nodes indexed by `|_n/2_|` + 1, . . . , n.
