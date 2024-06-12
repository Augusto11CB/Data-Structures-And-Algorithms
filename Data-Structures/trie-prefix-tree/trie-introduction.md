# Trie Introduction

* A Trie, also known as a prefix tree, is a specialized tree-based **data structure used for efficient storage, searching, and retrieval of strings**.
* It is particularly useful when managing large collections of strings and **performing pattern-matching operations**.
* The Trie represents a set of strings:
  * Each **node** in the tree corresponds to a **single character of a string.**&#x20;
  * The **path** from the root to a specific node represents the characters of a particular string.&#x20;
  * This characteristic allows Tries to effectively **share common prefixes** among strings, leading to efficient storage and retrieval.



### Need for Trie Data Structure?

Tries are commonly used in applications such as spell checking, autocomplete suggestions, and searching within dictionaries or databases. They outperform other data structures like binary search trees by minimizing search complexity in proportion to the length of the target string.



### Tries Advantages

* Fast pattern matching.
* Common prefix sharing for efficient memory utilisation.
* Efficient insertion and deletion operations.
* Flexibility in handling various alphabets.
* The ability to store additional information at nodes, such as word frequency.

In comparison to binary search trees, Tries offer the advantage of search time linearly dependent on the length of the string being searched, resulting in optimized search operations, especially for large datasets.



### Trie Properties

* Every Trie has a s**ingle root node** that serves as the starting point for all stored strings.
* In a Trie, each node represents a string, and the path from the root to that node represents the entire string.
* The **edges** connecting nodes in a Trie correspond to **individual characters**, and traversing an edge adds a character to the string.
* Nodes in a Trie typically contain **hashmaps or arrays of pointers, where each position corresponds to a character**.&#x20;
* Nodes also have a **flag** indicating if a string concludes at that node.
* Tries are primarily designed to handle lowercase English alphabets (a-z), with each node having 26 pointers representing the characters 'a' to 'z'.
* In a Trie, **tracing any path** from the **root** node to another **node** represents a **word** or a string, facilitating easy identification and retrieval of strings.



#### TL;DR

The properties of the Trie data structure include having a single root node, nodes symbolizing strings, edges representing characters, node structure with arrays or hashmaps of pointers, limitation to lowercase English alphabets, and the ability to identify and retrieve strings by tracing paths from the root node.



### Trie Example

<figure><img src="../../.gitbook/assets/image.png" alt=""><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>

In the above Trie, `car` and `cat` shares the common prefix, and `apple` and `ant` shares the common prefix.



### References

Design Gurus. Grokking Data Structures for Coding Interviews: Introduction to Trie. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/650eb465d8da406a4d935d33)>. Acesso em: 21 jan. 2024.
