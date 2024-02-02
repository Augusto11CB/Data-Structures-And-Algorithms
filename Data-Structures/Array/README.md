# Array

**Arrays** **provide** a means of **storing and organizing data** in a systematic and computer-memory-efficient manner.

Essentially, **an array** is a collection of elements, **with each element identified** by an array index. The array _<mark style="background-color:orange;">elements</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**are stored**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">in contiguous memory locations</mark>_, **implying that they are stored** in a sequence.



Arrays can be categorized into two types based on their ability to adjust size:

* **Static Arrays:**
  * Maintain a fixed size determined during declaration.
  * Size remains unchangeable throughout program execution.
  * Memory allocation occurs once.
  * Array size never changes.
* **Dynamic Arrays:**
  * Can adjust size during runtime.
  * Adapt to the volume of data they store.
  * Efficient memory usage.
  * Resizing may involve additional operations (e.g., creating a new array, copying elements), imposing overhead on certain operations.



### Operations

#### Accessing Elements

* The position of an element within an array can be determined by its index, through which the element is accessed.
* Accessing elements in an array is an `O(1)` time complexity operation.



#### Inserting Elements

* At the end:  An element **can be inserted** at the end of an array, which is usually an `O(1)` **operation**.
* At a specific index: If insertion is desired at a particular index, subsequent elements **must be shifted** to make room, **escalating the time complexity** to `O(n)` in the worst case.



#### Deleting Elements

* From the end: An element **can be removed** from the end, which is typically an `O(1)` **operation**, as it doesn’t require repositioning of other elements.
* From a specific index: Deletion from a particular index **requires shifting** the subsequent elements to fill the gap, making it an **operation** with time complexity  `O(n)` in the worst case.



#### Searching

* **Identifying the index** of a specified element **involves searching**. Without any additional information or constraints, **a linear search is performed**, scanning each element until the sought one is found, **associating it with an `O(n)` complexity**.
* However, if the array is sorted, **binary search can be employed**, **reducing the complexity to  `O(logn)`**.



#### Updating Elements

* Generally the updating operation can take `O(1)`, because it changes the value at a specified memory location, which can be accessed without scanning the array.



#### Array Time Complexity Operations Summary

<figure><img src="../../.gitbook/assets/image (1) (1) (1) (1) (1) (1).png" alt=""><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>

### Properties

#### Memory Allocation

Contiguous memory allocation defines arrays, implying that each element is stored in adjacent memory locations. This enables **arrays to offer constant-time access to any element using its index**, as the memory address of any element can be calculated using the base address, the size of an element, and the index of the element.



#### Indexing

Indexing enables direct access to any element within the array, thereby facilitating operations like search, update, and direct access with a consistent time complexity of `O(1)`.



### Arrays in Coding Interviews

1. **Validating Assumptions**:
   * Clarify if duplicate values are allowed.
   * Check whether the array is sorted.
2. **Boundary Conditions**:
   * Prevent index out of bounds errors.
   * Be cautious with negative indices.
3. **Efficiency Concerns**:
   * Be careful with slicing and concatenating, because slicing and concatenating can take `O(n)` time.
   * Consider in-place manipulation vs. creating new arrays.
4. **Variable Naming and Loop Indices**:
   * Use descriptive variable names.
   * Mind loop indices to prevent off-by-one errors.
5. **Algorithm Choice and Complexity**:
   * Understand time and space complexity.
   * Beware of nested loops, because time complexity can rapidly escale (e.g., to `O(n²)`)
6. **Testing**:
   * Test with edge cases for robustness.
   * Handle various inputs.
7. **Handling Zeros and Negatives**:
   * Always clarify how to handle zeros and negative numbers in array problems.
   * Crucial for problems related to product or sum.
8. **Modification During Iteration**:
   * Be cautious when modifying an array during iteration.
   * Modifying in-place can introduce bugs or unintended behaviors.
   * <mark style="background-color:orange;">Consider</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">**iterating backwards**</mark> <mark style="background-color:orange;"></mark><mark style="background-color:orange;">or using a separate array for modifications.</mark>
9. **Array Methods Familiarity**:
   * Understand the array methods provided by your programming language.
   * Know their time and space complexities.
10. **Partial Results**:
    * Use intermediate variables (e.g., prefix sums or suffix products) to optimize repeated calculations.
    * Weigh the pros and cons of making multiple passes through the array.
11. **Parallel and Reverse Iteration**:
    * <mark style="background-color:orange;">Iterating through an array from the end or using parallel iteration can lead to optimal solutions.</mark>
12. **Understanding Problem Requirements**:
    * Ensure you correctly understand problem requirements and constraints to avoid incorrect solutions.



### **Java Arrays**

1. **Fixed Size**: In Java, when you create an array, you need to define its size, and it can’t be changed later.
   * Example: `int[] numbers = new int[115];`
2. **Same Data Type**: All elements in a Java array must be of the same type.
3. **Primitive and Object Arrays**: Java supports arrays of primitives (int, char, etc.) and objects.
   * Primitive arrays are more memory-efficient.
4. **Direct Memory Allocation**: Java arrays are allocated memory directly, ensuring quick access but also meaning you need to manage sizes carefully.



### Python Arrays

1. **Dynamic Lists**: Python’s “arrays” are actually lists, and they can grow or shrink in size.
   * Example: `numbers = [1, 2, 3, 5, 7]`, and you can simply do `numbers.append(4)`.
2. **Mixed Data Types**: You can store different types of elements in a Python list.
   * Example: `mixed = [1, "dois", 3.0]`
3. **Objects Under the Hood**: Even if you store a primitive type like an integer, Python treats it as an object.
4. **Memory Overhead**: Because of its flexibility and dynamic nature, Python lists have more memory overhead than Java arrays.

### References

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Arrays. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6465cce0468851553fab6fdc](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/6465cce0468851553fab6fdc)>. Acesso em: 8 dez. 2023a.
