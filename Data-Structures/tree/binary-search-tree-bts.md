# Binary Search Tree (BTS)

A Binary Search Tree (BST) is a type of binary tree where each node can have a maximum of two children, known as the left and right child. The unique characteristic of a BST is that for any particular node, the values of all nodes in its left subtree are less than or equal to the node's value, while the values of all nodes in its right subtree are greater than the node's value (Design Gurus, 2023a).



#### Properties and Application of BST

* **Quick Searches**: BSTs provide fast searching capabilities with an average time complexity of `O(log n)` for balanced trees. This makes them suitable for applications that require quick data retrieval based on a key, such as database indexing and dictionary implementations.
* **Ordered Data**: BSTs keep data in order. They are useful when you need to keep things sorted or get them in a certain order.
* **BSTs in Databases**: Databases leverage BSTs to create indexes, which speed up data retrieval based on specific fields. This allows databases to efficiently manage large datasets and complex queries.
* **BSTs in File Systems**: File systems use BSTs to organize directory structures. This aligns well with the hierarchical structure of directories, leading to efficient file retrieval.



* A binary tree with height `h` contains at most: <img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/01/25/height_balanced_bst_equation_1.png" alt="" data-size="line">.
  * This is where we'll do a simple induction. A tree with only 1 layer has only 1 node. A tree of 2 layers has 1+2 nodes. 3 layers 1+2+4 nodes etc. The pattern is clear: A tree with h layers has exactly: `2^h-1`,
* In other word, a binary tree with `N` nodes and height `h`: <img src="../../.gitbook/assets/image (7).png" alt="" data-size="line">
* That is: <img src="../../.gitbook/assets/image (6).png" alt="" data-size="line">
* The number of nodes in the tree doubles, the depth increases by 1.
* See this [Stackoverflow](https://stackoverflow.com/questions/14426790/why-lookup-in-a-binary-search-tree-is-ologn).



### Traversing a Binary Search Tree (BST)

<figure><img src="../../.gitbook/assets/image (2).png" alt="" width="375"><figcaption><p>RAI, 2023</p></figcaption></figure>



#### In order Traversal

* left subtree ->  the current node -> right subtree.
* results in the elements being visited in ascending order.
* > Traversing in order in BST is same as traversing a sorted array.

```java
private void inOrderHelper(Node<T> node) {
    if (node != null) {
        inOrderHelper(node.left);
        System.out.print(node.data + " ");
        inOrderHelper(node.right);
    }
}

public void inOrder() {
    inOrderHelper(root);
    System.out.println();
}
```



#### Pre-order Traversal <a href="#2.-pre-order-traversal" id="2.-pre-order-traversal"></a>

* current node -> the left subtree -> right subtree.

```java
private void preOrderHelper(Node<T> node) {
    if (node != null) {
        System.out.print(node.data + " ");
        preOrderHelper(node.left);
        preOrderHelper(node.right);
    }
}

public void preOrder() {
    preOrderHelper(root);
    System.out.println();
}
```



#### &#x20;Post-order Traversal <a href="#3.-post-order-traversal" id="3.-post-order-traversal"></a>

* the left subtree -> the right subtree -> current node.

```java
private void postOrderHelper(Node<T> node) {
    if (node != null) {
        postOrderHelper(node.left);
        postOrderHelper(node.right);
        System.out.print(node.data + " ");
    }
}

public void postOrder() {
    postOrderHelper(root);
    System.out.println();
}
```



### BST Implementation

#### Node Class of a BST - Implementation

```java
class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T value) {
        data = value;
        left = null;
        right = null;
    }
}
```



#### Insert Node Operation BST - Implementation

```java
public void insert(T value) {
    Node<T> newNode = new Node<>(value);

    if (root == null) {
        root = newNode;
    } else {
        Node<T> current = root;
        Node<T> parent = null;

        while (current != null) {
            parent = current;
            //  We must ensure that the left subtree contains nodes with values less than or equal to the current node's value, and the right subtree contains nodes with values greater than the current node's value.
            if (value.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (value.compareTo(parent.data) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
}
```



#### Delete Node Operation BST - Implementation

```java
// It starts from the given node and traverses the left children until it reaches the leftmost node, which contains the smallest value in the subtree. It returns the pointer to this minimum node
private Node<T> findMin(Node<T> node) {
    if (node.left == null) {
        return node;
    }
    return findMin(node.left);
}

private Node<T> deleteNode(Node<T> root, T value) {
    if (root == null) {
        return root;
    }

    if (value.compareTo(root.data) < 0) {
        root.left = deleteNode(root.left, value);
    } else if (value.compareTo(root.data) > 0) {
        root.right = deleteNode(root.right, value);
    } else {
        // The node has no children or only one child (left or right). In this case, the function simply removes the node and links its parent to its child, if any.
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        // The node has two children. In this case, the function finds the inorder successor of the node (the minimum node in its right subtree). The value of the inorder successor replaces the value of the node to be deleted, and the function is then recursively called to delete the inorder successor node.
        Node<T> temp = findMin(root.right);
        root.data = temp.data;
        root.right = deleteNode(root.right, temp.data);
    }
    return root;
}

public void deleteMethod(T value) {
    root = deleteNode(root, value);
}
```



#### Searching Node Operation BST - Implementation

```java
public boolean search(T value) {
    Node<T> current = root;
    while (current != null) {
        if (value.compareTo(current.data) == 0) {
            return true;
        } else if (value.compareTo(current.data) < 0) {
            current = current.left;
        } else {
            current = current.right;
        }
    }
    return false;
}
```

### Time and Space Complexity of Binary Search Trees (BST)

#### Best Case Time Complexity for Searching - O(log n)

* The best-case time complexity for searching in a BST occurs when the tree is balanced.
* In a balanced BST, each level approximately halves the search space.
* Requires `O(log n)` operations to traverse through all nodes in the BST.



#### Worst Case Time Complexity for Searching - O(n) (for unbalanced trees) <a href="#worst-case-time-complexity-for-searching-o-n-for-unbalanced-trees" id="worst-case-time-complexity-for-searching-o-n-for-unbalanced-trees"></a>

* The worst-case time complexity for searching occurs when the tree is completely unbalanced, resembling a linked list. In this scenario, each node has only one child, and the search becomes linear, requiring `O(n)` operations to traverse through all nodes in the BST.



#### Best Case Time Complexity for Insertion/Deletion - O(log n)

* In a balanced BST, each level approximately halves the search space.
* As a result, the time complexity for searching is logarithmic `O(log n)` with respect to the number of nodes (n) in the BST.



#### Worst Case Time Complexity for Insertion/Deletion - O(n) (for unbalanced trees)

* The worst-case time complexity for searching in a BST occurs when the tree is completely unbalanced ("linked list").
* In this scenario, each node has only one child, and the search becomes linear, requiring `O(n)` operations to traverse through all nodes in the BST.



### Issues with BSTs <a href="#issues-with-bsts" id="issues-with-bsts"></a>

1. **Unbalanced BSTs**:
   * Unbalanced BSTs occur when elements are inserted in a specific order, leading to poor tree structure.
   * If elements are inserted in a **sorted or nearly sorted order**, the BST can degenerate into a **linked list**.
   * Unbalanced BSTs result in **poor time complexities** for search, insertion, and deletion operations, approaching **linear time (O(n))** instead of the optimal **logarithmic time (O(log n))**.
2. **Degenerate Trees**:
   * Degenerate trees are extreme cases of unbalanced BSTs where each node has only one child.
   * These trees essentially form a **linked list**, resulting in **very poor time complexities** for all operations.
   * The advantages of using BSTs are **negated** in such cases.
3. **Performance Issues**:
   * Unbalanced and degenerate BSTs lead to significantly **degraded performance** for common operations.
   * In the worst-case scenario (when the tree is degenerate), operations can take **linear time (O(n))**.
   * This undermines the primary benefit of using a BST.
4. **Complex Balancing**:
   * Ensuring a BST remains balanced after insertion and deletion requires **complex balancing algorithms**.
   * Self-balancing BSTs like **AVL trees** and **Red-Black trees** exist but add **overhead and complexity** to the code.
5. **Lack of Unique Keys**:
   * <mark style="background-color:orange;">BSTs generally</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**do not support duplicate keys**</mark><mark style="background-color:orange;">.</mark>
   * Behavior varies when attempting to insert a duplicate key:&#x20;
     * some implementations **overwrite** the existing value,&#x20;
     * while others **reject** the insertion.
6. **Memory Overhead**:
   * Each node in a BST requires additional memory for <mark style="background-color:orange;">**storing pointers**</mark> to the left and right children.
   * Memory overhead can be significant for **large datasets**, especially if the tree is poorly balanced.
7. **Dynamic Datasets**:
   * BSTs are **not well-suited** for datasets that frequently change in size.
   * <mark style="background-color:orange;">**Insertions and deletions**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">can lead to</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**imbalanced trees**</mark><mark style="background-color:orange;">, necessitating additional</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**balancing operations**</mark><mark style="background-color:orange;">.</mark>
   * These operations can be **computationally expensive**.
8.  **Search Performance for Equal Keys**:

    * While BSTs provide efficient search times for **unique keys**, searching for the **next greater or lesser element** for equal keys requires **additional operations**.
    * This may result in **less efficient** search performance.



<details>

<summary>Expanding "8. searching for the <strong>next greater or lesser element</strong> for equal keys requires <strong>additional operations"</strong></summary>

When we talk about **Binary Search Trees (BSTs)**, each node has a key associated with it. In the case of equal keys (where multiple nodes have the same key value), searching for the **next greater or lesser element** becomes a bit more intricate.

1. **Next Greater Element**:
   * Suppose we want to find the next greater element after a given key.
   * If the key is unique (i.e., no duplicate keys), we can efficiently traverse the tree by comparing the key values.
   * However, when there are **equal keys**, we need to consider additional factors:
     * If the current node has equal keys, we must explore its **right subtree** to find the next greater element.
     * If the current node has distinct keys, we can directly move to the **right child** of the current node.
2. **Next Lesser Element**:
   * Similarly, finding the next lesser element involves similar considerations.
   * If the key is unique, we can traverse the tree by comparing key values.
   * For equal keys:
     * If the current node has equal keys, we explore its **left subtree** to find the next lesser element.
     * If the current node has distinct keys, we move to the **left child** of the current node.

</details>

\


### References <a href="#the-concept-of-a-circular-queue" id="the-concept-of-a-circular-queue"></a>

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Queue. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6491e0d6cc1ee5e292d494c7](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6491e0d6cc1ee5e292d494c7)>. Acesso em: 11 dez. 2023a.

RAI, **Vartika.** Tree Traversal: Inorder, Preorder, Postorder, and Level-order. Interview Kickstart, 2023. Disponível em: <[https://www.interviewkickstart.com/learn/tree-traversals-inorder-preorder-and-postorder](https://www.interviewkickstart.com/learn/tree-traversals-inorder-preorder-and-postorder)>. Acesso em: 11 dez. 2023a.
