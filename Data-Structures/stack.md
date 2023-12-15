# Stack

* In the world of data structures, a stack is a linear data structure that follows a particular order of operation. This order can either be **Last In First Out (LIFO)** or **First In Last Out (FILO)**.
* **Real-world Examples of Stacks:**
  * **Web Browser History**: Whenever a new webpage is visited, it is added to the top of the history stack. When the back button is pressed, pages are “popped” off the top of the stack.
  * **Undo Function in Software Applications**: In software applications, a stack is used to remember actions. The most recent action is placed on top and will be the first one to be undone.



### LIFO

Stacks in data structures operate on the Last-In, First-Out (LIFO) principle. This means that the last item added to the stack is the first one that gets taken out.



### Key Operations

1. **Push**: An element is added to the stack. The element is always added to the top.
2. **Pop**: An element is removed from the stack. The element removed is always from the top.
3. **Peek** or **Top**: This operation allows us to see the element on the top of the stack without removing it.
4. **IsEmpty**: This operation checks if the stack is empty.



#### Stack Time Complexity Operations Summary

<figure><img src="../.gitbook/assets/image (3).png" alt=""><figcaption><p>Design Gurus, 2023a</p></figcaption></figure>



### Stack Implementation and Usage in Programming

* **Stack implementation in programming** can be achieved in various ways. **Two common methods** involve using an array or a linked list. Additionally, depending on the programming language being used, there **might be built-in functions** that facilitate stack creation.

#### **Application of Stack**

* **Expression evaluation and syntax parsing**: Stacks are employed by compilers and parsers to evaluate expressions and verify syntax.
* <mark style="background-color:orange;">**Backtracking**</mark><mark style="background-color:orange;">: Whenever an algorithm requires backtracking (e.g., in maze problems), a stack serves as a useful tool for remembering previous steps.</mark>
* **Function calls**: Each time a function is invoked, the computer must “remember” the location it needs to return to after executing the function. This memory is maintained on a call stack.
* **Memory management**: Stacks play a crucial role in memory allocation and deallocation.
* **Undo Mechanism in Software Applications:** In software applications, the ‘undo’ feature relies on stacks: actions are pushed onto a stack, and when ‘undo’ is triggered, the most recent action is popped and reversed, providing an elegant solution to a common problem.



#### Backtracking

**Backtracking algorithms** address problems by **experimenting with solutions** and **reverting them** if they **do not lead to a solution**. This approach is **commonly employed** in puzzles such as **Sudoku**, the **Eight Queens problem**, and the **Knight’s Tour problem**.

In these scenarios, **stacks** are **utilized** to **store the intermediate stages** of the problem. <mark style="background-color:orange;">When an attempted solution</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**does not succeed**</mark><mark style="background-color:orange;">, the algorithm can</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**“pop” back**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">to a</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**previous state**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">and</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**explore an alternative path**</mark>. It’s akin to having a **“save game” feature** when **tackling a challenging puzzle**



#### DFS

**Depth-First Search (DFS)** is a graph algorithm that **employs stacks**. It explores a graph by **visiting a node** and **recursively investigating** all its unvisited neighbors. <mark style="background-color:orange;">The algorithm</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**relies on a stack**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">to</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**keep track of which nodes**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">to visit next</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**after completing a path**</mark>.

By **“pushing” unvisited nodes** onto the stack and **“popping” them** once visited, DFS **systematically explores** every node in the graph. This method **finds application** in **network routing**, **AI behavior in games**, and **detecting cycles** within a graph.



### Stack Common Errors/Exceptions (**Stack overflow and Stack Underflow)**

**Stack overflow and underflow** are two situations that **can be encountered** when working with stacks. **Stack overflow** **occurs** when an attempt is made to push an element onto a stack that is already full, while **stack underflow** **happens** when an attempt is made to pop an element from an empty stack.



### Java Stack

#### Java Util Stack

```java
import java.util.Stack;
import java.util.EmptyStackException;

public class MyStack<T> {
    // A Stack object to store the elements.
    private Stack<T> stack = new Stack<>();

    // Method to check if the stack is empty.
    public boolean isEmpty() {
        return stack.empty(); // Returns true if the stack is empty, false otherwise.
    }

    // Method to add an element to the top of the stack.
    public void push(T data) {
        stack.push(data);
    }

    // Method to remove and return the top element of the stack.
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throws an exception if the stack is empty.
        }
        return stack.pop(); // Returns and removes the top element of the stack.
    }

    // Method to return the top element of the stack without removing it.
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throws an exception if the stack is empty.
        }
        return stack.peek(); // Returns the top element of the stack without removing it.
    }
}
```



#### Java Stack Implementation (Array)

```java
import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] stack; // An array to store the elements of the stack
    private int top; // An integer to keep track of the top element's index
    
    // Constructor to initialize the stack with a specified size
    public Stack(int size) {
        stack = new Object[size]; // Create a new array of objects with the given size
        top = -1; // Initialize the top index to -1, indicating an empty stack
    }

    // Method to push an item onto the stack
    public void push(T item) {
        if (top == stack.length - 1) {
            throw new IndexOutOfBoundsException("Stack is full"); // Check if the stack is full and throw an exception if it is
        }
        stack[++top] = item; // Increment the top index and add the item to the stack
    }

    // Method to pop and remove the top item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Check if the stack is empty and throw an exception if it is
        }
        T item = (T) stack[top]; // Retrieve the top item from the stack
        stack[top--] = null; // Set the top element to null and decrement the top index
        return item; // Return the removed item
    }

    // Method to peek at the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Check if the stack is empty and throw an exception if it is
        }
        return (T) stack[top]; // Return the top item without removing it
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1; // Return true if the top index is -1, indicating an empty stack
    }
}

```



#### Java Stack Implementation (Linked List)

```java
import java.util.EmptyStackException;

public class Stack<T> {
    // Private inner class representing a Node in the stack
    private static class Node<T> {
        private T data;         // Data stored in the node
        private Node<T> next;   // Reference to the next node in the stack

        // Constructor to create a new node with the given data
        private Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;  // Reference to the top node of the stack

    // Pop operation: Removes and returns the top element of the stack
    public T pop() {
        // Check if the stack is empty
        if (top == null) {
            throw new EmptyStackException(); // Throw an exception if it's empty
        }
        T item = top.data;  // Get the data from the top node
        top = top.next;     // Move the top reference to the next node
        return item;        // Return the removed item
    }

    // Push operation: Pushes a new item onto the top of the stack
    public void push(T item) {
        Node<T> t = new Node<T>(item);  // Create a new node with the given data
        t.next = top;                   // Set the new node's next reference to the current top
        top = t;                        // Update the top reference to the new node
    }

    // Peek operation: Returns the top element of the stack without removing it
    public T peek() {
        // Check if the stack is empty
        if (top == null) {
            throw new EmptyStackException(); // Throw an exception if it's empty
        }
        return top.data;  // Return the data of the top node
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

```



### Insight Problem Solving with Stack

* Manipulação de elementos levando em consideração os elementos adjacentes.
  * [https://leetcode.com/submissions/detail/1119872765/](https://leetcode.com/submissions/detail/1119872765/)
  * [https://leetcode.com/submissions/detail/1119832765/](https://leetcode.com/submissions/detail/1119832765/)
  * [https://leetcode.com/submissions/detail/1119814445/](https://leetcode.com/submissions/detail/1119814445/)
* TBD
  * [https://leetcode.com/submissions/detail/1117482038/](https://leetcode.com/submissions/detail/1117482038/)



### References

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Stack. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/647fd18147afdb7576809cc7](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/647fd18147afdb7576809cc7)>. Acesso em: 11 dez. 2023a.

