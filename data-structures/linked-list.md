# Linked List

* A **linked list** is a linear data structure where elements are stored in nodes, and each node points to the next one in the sequence, forming a chain-like structure.
* **Dynamic Size**: Easily grows and shrinks in size.
* **Efficient Insertions/Deletions**: Quick at the beginning and middle of the list.



### Types of Linked List

1. Singly Linked List
   * **Definition**: Each node points to the next node.
   * **Use Case**: A music playlist where each song plays after the previous one.
2. Doubly Linked List
   * **Definition**: Each node has pointers to both the next and the previous nodes.
   * **Use Case**: A web browser's history, enabling forward and backward navigation.
3. Circular Linked List
   * **Definition**: The last node in the list points back to the first node.
   * **Use Case**: A multiplayer board game where play returns to the first player after the last.



### Singly Linked List - Operations

#### Insert

* **At the Beginning - O(1)**: Add a new node before the current head of the list.
* **At the End - O(n)**: Traverse the list to the last node and add the new node after it.
* **After a Given Node - O(n)**: Traverse the list to the desired node and insert the new node after it.

#### Delete

* **From the Beginning - O(1)**: Set the second node as the new head.
* **From the End - O(n)**: Traverse the list and remove the reference to the last node.
* **A Given Node - O(n)**: Traverse to the node before the one to delete, then remove the reference to the node-to-delete.

#### Search

* &#x20;**Search - O(n):** Traverse the list from the head, comparing each node's data with the search value until a match is found or the end of the list is reached.



### Singly Linked List - Implementation

```java
// Class to represent a Node in the linked list
class Node {
    int data; // Data of the node
    Node next; // Reference to the next node in the list
    // Constructor to initialize the node with data and set the next reference to null
    Node(int d) { data = d; next = null; }
}

// Class to represent a Singly Linked List and perform various operations
class Solution {
    Node head; // head of the list, initially null

    // Inserts a new Node at the front of the list.
    void insert(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        newNode.next = head; // Set the next reference of the new node to the current head
        head = newNode; // Update the head of the list to the new node
    }

    // Inserts a new node after the given prev_node.
    void insertAfter(Node prev_node, int data) {
        // Check if the given prev_node is null
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data); // Create a new node with the given data
        newNode.next = prev_node.next; // Set the next reference of the new node to the next node of prev_node
        prev_node.next = newNode; // Update the next reference of prev_node to the new node
    }

    // Deletes the first occurrence of the specified key in the list
    void delete(int key) {
        Node temp = head, prev = null; // Initialize temp to head and prev to null
        // Check if head node itself holds the key to be deleted
        if (temp != null && temp.data == key) {
            head = temp.next; // Update the head to the next node
            return;
        }
        // Search for the key to be deleted
        while (temp != null && temp.data != key) {
            prev = temp; // Update prev to the current node
            temp = temp.next; // Move to the next node
        }
        // If key was not present in the list
        if (temp == null) return;
        // Unlink the node from the list
        prev.next = temp.next;
    }

    // Searches for the key in the linked list and returns true if found, otherwise false
    boolean search(int key) {
        Node current = head; // Initialize current to head
        while (current != null) {
            if (current.data == key) // If the key is found, return true
                return true;
            current = current.next; // Move to the next node
        }
        return false; // Key not found, return false
    }
    
    // Main method to test the linked list operations
    public static void main(String[] args) {
        Solution list = new Solution(); // Create an empty list

        // Insert nodes into the list
        list.insert(1);
        list.insert(2);
        list.insert(3);

        // Search for a key in the list
        System.out.println("Search 2: " + list.search(2)); // true

        // Delete a node from the list by key
        list.delete(2);

        // Check if the key is still present in the list
        System.out.println("Search 2: " + list.search(2)); // false
    }
}

```



### Doubly Linked List - Operations

#### **Insertion**

* **Addition at the Beginning**: A new node can be inserted at the beginning of the DLL.
* **Addition at the End**: A new node can be appended to the end of the list.
* **Addition at a Specific Position**: Inserting a node after a specified position is also possible.

#### **Deletion**

* **Removal by Data**: A node containing specific data can be deleted from the list.

#### **Search**

* The search operation involves locating a node with a given data value.
* If the target node is found, the search returns **true**; otherwise, it returns **false**.



### Doubly Linked List - Implementation

```java
class Node {
    int data;
    Node prev;
    Node next;

    Node(int d) {
        data = d;
        prev = next = null;
    }
}

class Solution {
    Node head;

    // Inserts a new Node at front of the list.
    void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    // Inserts a new node after the given prev_node.
    void insertAfter(Node prev_node, int data) {
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prev_node.next;
        prev_node.next = newNode;
        newNode.prev = prev_node;
        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    // Deletes the node with the given data.
    void delete(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    // Searches for the node with the given data.
    boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key)
                return true;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution dll = new Solution();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);

        System.out.println("Search 2: " + dll.search(2)); // true
        dll.delete(2);
        System.out.println("Search 2: " + dll.search(2)); // false
    }
}

```

\


### References <a href="#the-concept-of-a-circular-queue" id="the-concept-of-a-circular-queue"></a>

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to LinkedList. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6510093477fec8050b719fce](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6510093477fec8050b719fce)>. Acesso em: 11 dez. 2023a.
