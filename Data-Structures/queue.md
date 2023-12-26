# Queue

* A queue in computer science is a type of data structure where the element that enters first is the one that gets accessed first.
* Basic Terminology
  * **Enqueue:** when we add an element at the end.
  * **Dequeue: R**emoving an element from the front of the Queue.
  * **Front:** This is the start of the Queue, where the first element resides.
  * **Rear:** This is the end of the Queue, where the last element is placed.



### Types of Queues

1. **Simple Queue (FIFO)**: In a simple queue, elements are inserted at the rear and removed from the front, adhering to the First-In-First-Out (FIFO) principle.
2. **Deque (Double Ended Queue)**: A deque allows for the addition or removal of elements from both ends of the queue. It provides flexibility in managing elements at either the front or rear.
3. **Circular Queue**: In a circular queue, the last element points to the first, creating a loop. This structure is useful for scenarios where elements need to cycle back to the beginning.
4. **Priority Queue**: A priority queue assigns varying levels of importance to its elements. Some elements are considered more critical and are given priority over others in the queue.
   1. A BST can be used to maintain elements in sorted order.
   2. A HEAP can be used to figure out here an element must be inserted.
5. **Affinity Queue**: In an affinity queue, each element possesses an affinity. Elements with the same affinity are placed together, while those without matching affinities are positioned at the rear of the queue.

<figure><img src="../.gitbook/assets/image (5).png" alt=""><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>

### Simple Queue - Operations

#### **Enqueue Operation**:

* The enqueue operation involves adding an element to the **rear** of the queue.
* Prior to adding a new item, it is essential to verify whether the queue is already at full capacity. If the queue is full, we encounter a situation known as **queue overflow**.

#### **Dequeue Operation**:

* The dequeue operation focuses on removing an element from the **front** of the queue.
* Before removing an item, it is necessary to check whether there are any items available for removal.
* After removing the item, the front pointer is adjusted to indicate the next item in the queue.

#### Queue Time Complexity Operations Summary

<figure><img src="../.gitbook/assets/image (1) (1).png" alt=""><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>

### Simple Queue - Implementation

#### Java Queue Native Implementation

* Java java.util.Queue (Interface)
* [AbstractQueue](https://docs.oracle.com/javase/8/docs/api/java/util/AbstractQueue.html), [ArrayBlockingQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ArrayBlockingQueue.html), [ArrayDeque](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html), [ConcurrentLinkedDeque](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedDeque.html), [ConcurrentLinkedQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedQueue.html), [DelayQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/DelayQueue.html), [LinkedBlockingDeque](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedBlockingDeque.html), [LinkedBlockingQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedBlockingQueue.html), [LinkedList](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html), [LinkedTransferQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedTransferQueue.html), [PriorityBlockingQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/PriorityBlockingQueue.html), [PriorityQueue](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html), [SynchronousQueue](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/SynchronousQueue.html).

#### Queue Implemented using Java

```java
class Queue<T> {
    private Node<T> front, rear;
    private int size;

    // Node class for storing data and the reference to the next node
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        front = rear = null;
        size = 0;
    }

    // Add an element to the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove an element from the queue
    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Check the front element of the queue
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }
}

// Example usage
public class Solution {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}

```

###

### Circular Queue - Operations

* In a Circular Queue, the last element points back to the first element making a circular link.
* The operations on a Circular Queue are similar to those of a Simple Queue – Enqueue, Dequeue, Peek, and IsEmpty.
*   The **enqueue**  operation (Educative.io, 2023a):

    * Check whether the queue is full. A queue is full when the `front` is next to the `rear`. For example, with a queue of size 6, if `front` is 0 and `rear` is 5, or if `front` is 2 and `rear` is 1, it means that the queue is full.



    <figure><img src="../.gitbook/assets/image (2) (1).png" alt="" width="375"><figcaption><p>Font: Educative.io, 2023a</p></figcaption></figure>
* The dequeue operation (Educative.io, 2023a):
  * If it is empty, then it will display `"Queue is empty"`.&#x20;
  * If the queue is not empty, then check if the queue has only one value (i.e., `front` == `rear`).&#x20;
    * If it does have only one value, set both `rear` and `front` to `-1`;
    * if it does not, check if `front` is the last index of the queue and, if so, set `front` to `0`; otherwise, **increment** `front`.



### Circular Queue - Implementation

#### Design Gurus Implementation (Design Gurus, 2023a)

* When `FRONT > 0` use this canculation to verify if the `REAR` is imediatly behind the `FRONT` `(rear == (front - 1) % (size - 1)`, if it is true, them the queue is FULL;

```java
class CircularQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    // Constructor to initialize the queue
    public CircularQueue(int size) {
        this.size = size;
        queue = new int[this.size];
        front = -1;
        rear = -1;
    }

    // Function to insert an element in the queue
    public void enqueue(int element) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.println("Queue is Full");
        } else if (front == -1) { // Insert First Element
            front = 0;
            rear = 0;
            queue[rear] = element;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue[rear] = element;
        } else {
            rear = (rear + 1);
            queue[rear] = element;
        }
    }

    // Function to delete an element from the queue
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }

        int data = queue[front];
        queue[front] = -1;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return data;
    }

    // Function to display the elements of the queue
    public void displayQueue() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Elements in the Circular Queue are: ");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = front; i < size; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }
}

public class Solution {
    // Main method to test the CircularQueue class
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        // Inserting elements in the queue
        q.enqueue(14);
        q.enqueue(22);
        q.enqueue(13);
        q.enqueue(-6);

        // Display elements present in the queue
        q.displayQueue();

        // Deleting elements from the queue
        System.out.println("Deleted value = " + q.dequeue());
        System.out.println("Deleted value = " + q.dequeue());

        q.displayQueue();

        q.enqueue(9);
        q.enqueue(20);
        q.enqueue(5);

        q.displayQueue();

        q.enqueue(20);
    }
}

```



#### :bulb:Programiz Implementation (Programiz, 2023a)

* Circularly increase the `REAR` index by 1 (i.e. if the rear reaches the end, next it would be at the start of the queue)
  * `rear = (rear + 1) % SIZE`

```java
// Circular Queue implementation in Java

public class CQueue {
  int SIZE = 5; // Size of Circular Queue
  int front, rear;
  int items[] = new int[SIZE];

  CQueue() {
    front = -1;
    rear = -1;
  }

  // Check if the queue is full
  boolean isFull() {
    if (front == 0 && rear == SIZE - 1) {
      return true;
    }
    if (front == rear + 1) {
      return true;
    }
    return false;
  }

  // Check if the queue is empty
  boolean isEmpty() {
    if (front == -1)
      return true;
    else
      return false;
  }

  // Adding an element
  void enQueue(int element) {
    if (isFull()) {
      System.out.println("Queue is full");
    } else {
      if (front == -1)
        front = 0;
      rear = (rear + 1) % SIZE;
      items[rear] = element;
      System.out.println("Inserted " + element);
    }
  }

  // Removing an element
  int deQueue() {
    int element;
    if (isEmpty()) {
      System.out.println("Queue is empty");
      return (-1);
    } else {
      element = items[front];
      if (front == rear) {
        front = -1;
        rear = -1;
      } /* Q has only one element, so we reset the queue after deleting it. */
      else {
        front = (front + 1) % SIZE;
      }
      return (element);
    }
  }

  void display() {
    /* Function to display status of Circular Queue */
    int i;
    if (isEmpty()) {
      System.out.println("Empty Queue");
    } else {
      System.out.println("Front -> " + front);
      System.out.println("Items -> ");
      for (i = front; i != rear; i = (i + 1) % SIZE)
        System.out.print(items[i] + " ");
      System.out.println(items[i]);
      System.out.println("Rear -> " + rear);
    }
  }

  public static void main(String[] args) {

    CQueue q = new CQueue();

    // Fails because front = -1
    q.deQueue();

    q.enQueue(1);
    q.enQueue(2);
    q.enQueue(3);
    q.enQueue(4);
    q.enQueue(5);

    // Fails to enqueue because front == 0 && rear == SIZE - 1
    q.enQueue(6);

    q.display();

    int elem = q.deQueue();

    if (elem != -1) {
      System.out.println("Deleted Element is " + elem);
    }
    q.display();

    q.enQueue(7);

    q.display();

    // Fails to enqueue because front == rear + 1
    q.enQueue(8);
  }

}
```



### Deque - Operations

* **Deque (Double Ended Queue)**, also known as a double-ended queue, is a specialized type of queue that allows for the insertion and removal of elements from both the front and the rear.
* Unlike a standard queue that adheres strictly to the First-In-First-Out (FIFO) rule, a deque provides greater flexibility in managing elements by allowing operations at both ends.

### Deque - Implementation

#### Programiz Implementation (Programiz, 2023b)

* insertRear:
  * If `REAR == size - 1`, reinitialise `REAR = 0` (first index).
* insertFront
  * &#x20;If `FRONT < 1`, reinitialise `FRONT = size - 1` (last index).

```java
// Deque implementation in Java

class Deque {
  static final int MAX = 100;
  int arr[];
  int front;
  int rear;
  int size;

  public Deque(int size) {
    arr = new int[MAX];
    front = -1;
    rear = 0;
    this.size = size;
  }

  boolean isFull() {
    return ((front == 0 && rear == size - 1) || front == rear + 1);
  }

  boolean isEmpty() {
    return (front == -1);
  }

  void insertFront(int key) {
    if (isFull()) {
      System.out.println("Overflow");
      return;
    }

    if (front == -1) {
      front = 0;
      rear = 0;
    }
    
    // If front < 1, reinitialize front = size-1 (last index)
    else if (front == 0)
      front = size - 1;

    else
      front = front - 1;

    arr[front] = key;
  }

  void insertRear(int key) {
    if (isFull()) {
      System.out.println(" Overflow ");
      return;
    }

    if (front == -1) {
      front = 0;
      rear = 0;
    }

    // If rear == size - 1, reinitialize rear = 0 (first index)
    else if (rear == size - 1)
      rear = 0;

    else
      rear = rear + 1;

    arr[rear] = key;
  }

  void deleteFront() {
    if (isEmpty()) {
      System.out.println("Queue Underflow\n");
      return;
    }

    // Deque has only one element
    if (front == rear) {
      front = -1;
      rear = -1;
    } else if (front == size - 1)
      front = 0;

    else
      front = front + 1;
  }

  void deleteRear() {
    if (isEmpty()) {
      System.out.println(" Underflow");
      return;
    }

    if (front == rear) {
      front = -1;
      rear = -1;
    } else if (rear == 0)
      rear = size - 1;
    else
      rear = rear - 1;
  }

  int getFront() {
    if (isEmpty()) {
      System.out.println(" Underflow");
      return -1;
    }
    return arr[front];
  }

  int getRear() {
    if (isEmpty() || rear < 0) {
      System.out.println(" Underflow\n");
      return -1;
    }
    return arr[rear];
  }

  public static void main(String[] args) {

    Deque dq = new Deque(4);

    System.out.println("Insert element at rear end : 12 ");
    dq.insertrear(12);

    System.out.println("insert element at rear end : 14 ");
    dq.insertrear(14);

    System.out.println("get rear element : " + dq.getRear());

    dq.deleterear();
    System.out.println("After delete rear element new rear become : " + dq.getRear());

    System.out.println("inserting element at front end");
    dq.insertfront(13);

    System.out.println("get front element: " + dq.getFront());

    dq.deletefront();

    System.out.println("After delete front element new front become : " + +dq.getFront());

  }
}
```



### **Queues in Programming**

In programming and data structures, queues serve diverse purposes (Design Gurus, 2023a):

1. **Breadth-First Search (BFS)**:
   * Queues play a pivotal role in the BFS algorithm, facilitating the systematic traversal of nodes within a tree or graph.
   * The process starts from a designated node (often the tree’s root or any graph node) and systematically explores neighboring nodes at the current depth level. Only after exhaustively examining the current depth level does the algorithm proceed to nodes at subsequent depth levels.
2. **Caching**:
   * Certain caching strategies, specifically those adhering to the FIFO principle, leverage queues.
   * In FIFO caching, the oldest item is evicted when the cache reaches its capacity, making room for the insertion of a new item.
3. :warning: :bulb: **Asynchronous Data Transfer**:
   * Queues find application in scenarios involving **asynchronous** data transfer between two processes.

### References <a href="#the-concept-of-a-circular-queue" id="the-concept-of-a-circular-queue"></a>

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Queue. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6491e0d6cc1ee5e292d494c7](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6491e0d6cc1ee5e292d494c7)>. Acesso em: 11 dez. 2023a.

Educative.io. How to implement a circular queue in C++. Educative.io, \[s.d]. Disponível em: <[https://www.educative.io/answers/how-to-implement-a-circular-queue-in-cpp](https://www.educative.io/answers/how-to-implement-a-circular-queue-in-cpp)>. Acesso em: 11 dez. 2023a.

Programiz. Circular Queue Data Structure. Programiz, \[s.d]. Disponível em: <[https://www.programiz.com/dsa/circular-queue](https://www.programiz.com/dsa/circular-queue)>. Acesso em: 11 dez. 2023a.

