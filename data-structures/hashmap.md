# HashMap

* Hashing is the process of converting data — text, numbers, files — into a fixed-length string of letters and numbers.&#x20;
* The transformation is done using a specific algorithm called a **hash function**.
* The data being transformed is referred to as the <mark style="background-color:orange;">**key**</mark>, which can be in various formats.
* The **hash function converts the key** into a fixed-length string known as the **hash value**.
* Ideally, each unique key should result in a distinct hash value to ensure uniqueness.
  * If two different inputs give the same hash, that's called a **collision**.
* The uniqueness of hash values is crucial for the effectiveness and reliability of hashing.



### Hash Use Cases

* **Password Security:** Rather than storing actual passwords, systems store their respective hash values.
* **Data Deduplication:** In situations where data storage necessitates the elimination of duplicates, comparing the hashes of data entries becomes an efficient technique. If two data entries share the same hash value, it can be inferred that they represent identical information.
* **Data Integrity Checks:** A hash value for the file may be provided by the site when a file is being downloaded from the web. If there is even a tiny change in the file during the download, a difference will be observed in its hash. Whether the file is exactly as the original, or if it was tampered with during the transfer, can be determined by comparing the hash of the downloaded file with the provided hash.
* **Cryptography**: Some hash functions are used in cryptography to ensure data confidentiality and integrity.&#x20;
* **Load Balancing**: In big systems serving many users, hashes can be used to decide which server should handle a particular request.&#x20;
* Hashtable: A hashtable (or hash map), is a data structure that stores data in key-value pairs for efficient retrieval.&#x20;
  * <mark style="background-color:green;">**Keys**</mark>** are unique identifiers** for data elements, and **values contain the actual data**.&#x20;
  * The process of hashing applies a hash function to the <mark style="background-color:orange;">**key**</mark> to generate a numerical index or hash code, which determines the position or bucket within the hashtable where the key-value pair is stored.&#x20;
  * Retrieval involves hashing the key again to locate the corresponding bucket quickly.
  * Hashtables offer constant-time average retrieval and insertion, making them efficient for handling large data volumes.



### Hash Table

* A Hash Table uses a hash function to compute an index into an array of buckets or slots where the desired value is stored.
*   **Hash Table has four core elements:** Keys, Values, the Hash Function, and Buckets.

    * **Key:**&#x20;
      * unique identifiers.
      * Keys are the inputs feed into the hash function.
      * They should be unique.
      * If two pieces of data share the same key it is called "collision".
    * **Values:**
      * Values are the actual data that we store in our Hash Table.
      * Using the key, the value can be quickly retrieve from the Hash Table.
    * **Hash Function:**
      * &#x20;It's responsible for transforming keys into hash values, which dictate where the data is stored.
    * **Bucket:**
      * Once the hash function has processed the KEY, it produces a **hash value**. This value corresponds to a specific location or **'bucket'** within the Hash Table.&#x20;
      * Think of buckets as shelves in our library, each one designated to store a specific book (or piece of data).



<figure><img src="../.gitbook/assets/image (8).png" alt=""><figcaption><p>Font: RAMACHANDRAN, 2015</p></figcaption></figure>



#### Basic Operations

* **Insert(key, value) operation:** Calculates the hash index `H(key)` and stores the **key-value** pair in the slot at that index.
* **Search(key) operation:** Computes `H(key)` to find the slot and returns the value associated with the key, or `null` if not present.
* **Delete(key) operation:** Removes the key-value pair stored at index `H(key)`.



### Issues with Hash Table

#### Collisions

* A collision in a Hash Table occurs when an insert operation tries to insert an item at a table slot already occupied by another item.



**Overflows**

* Overflow in a hash table occurs when the number of elements inserted exceeds the fixed capacity allocated for the underlying bucket array.&#x20;



### Resolving Collisions

The collision resolution techniques are classified into two types:

* Open addressing / Closed hashing.
* Chaining / Open hashing.



### Resolving Collisions - Open Addressing (Closed Hashing) <a href="#open-addressing-closed-hashing" id="open-addressing-closed-hashing"></a>

#### **Linear probing**

* Linear probing handles collisions by linearly searching consecutive slots for the next empty location.

<figure><img src="../.gitbook/assets/image (9).png" alt="" width="375"><figcaption><p>Font: Geeks For Geeks, 2023a</p></figcaption></figure>

<details>

<summary>Searching for a key using linear probing in a hash table involves the following steps</summary>

**1. Calculate the key's hash:**

* Apply the hash function to the key you want to find. This will give you an index into the hash table.

**2. Check the initial index:**

* Look at the element at the index obtained in step 1.

**3. Compare the key and the element:**

* If the key matches the element, you've found it! Return "Found".

**4. Handle collisions:**

* If the key doesn't match the element, and the element is not empty, there might be a collision (another key occupying the same slot).
* Move to the next index in the table, wrapping around to the beginning if necessary using modulo operation with the table size.

**5. Repeat steps 3 and 4:**

* Repeat steps 3 and 4 until one of the following conditions is met:
  * The key matches the element at the current index (you found it!).
  * You encounter an empty slot (the key is not present in the table).
  * You return to the initial index you calculated in step 1 (this indicates you've checked all possible slots without finding the key).

**6. Check for unsuccessful search:**

* If you reach the initial index again without finding the key in any slot, the key is not present in the table. Return "Not found".

</details>

<details>

<summary>Problems Related With Linear Probing</summary>

**Primary Clustering:**

* **What it is:** When multiple keys hash to nearby indices in the hash table, linear probing's sequential search for empty slots can lead to the formation of "clusters" of occupied slots. This creates longer chains of elements that need to be examined during both insertion and searching, degrading performance.
* **Why it happens:** When a collision occurs, linear probing simply checks the next available slot, increasing the likelihood of subsequent collisions in that same area. This creates a snowball effect, where more collisions lead to more clustering and even longer search times.
* **Consequences:**
  * Increased search and insertion times, as more probes are needed to find empty slots or target keys.
  * Potential for hash table to become "clogged" with clusters, leading to degraded performance even for non-colliding keys.

\
**Secondary Clustering:**

* **What it is:** instead of near the insertion point, probes will cluster around other points.
* **Why it happens:** It's often caused by non-random patterns in the hash values generated by the hash function, or by specific probing sequences that create certain patterns of collisions.
* **Consequences:**
  * Exacerbates the performance issues caused by primary clustering, making search and insertion even more time-consuming.

</details>



#### **Quadratic probing**

* When a collision occurs, the quadratic probing attempts to find an alternative empty slot for the key by using a `quadratic function` to probe the successive possible positions.
* Quadratic probing can help avoid getting locked into the same search pattern as linear probing, which checks slots sequentially.

<figure><img src="../.gitbook/assets/image (10).png" alt="" width="375"><figcaption><p>Font: Geeks For Geeks, 2023a</p></figcaption></figure>

<details>

<summary>Searching for a key using quadratic probing in a hash table involves the following steps</summary>



**1. Calculate the key's hash:**

* Apply the hash function to the key you want to find. This will give you an initial index into the hash table.

**2. Check the initial index:**

* Look at the element at the index obtained in step 1.

**3. Compare the key and the element:**

* If the key matches the element, you've found it! Return "Found".

**4. Handle collisions:**

* If the key doesn't match the element, and the element is not empty, there might be a collision (another key occupying the same slot).
* Instead of moving linearly, calculate the next probe index using a quadratic function. A common option is `current_position + (i^2)`, where `i` is an iteration counter starting from 0. Remember to apply modulo with the table size to stay within the table bounds.

**5. Repeat steps 3 and 4:**

* Repeat steps 3 and 4 until one of the following conditions is met:
  * The key matches the element at the current index (you found it!).
  * You encounter an empty slot (the key is not present in the table).
  * You have checked all possible slots according to the probing sequence (this indicates you didn't find the key).

</details>

<details>

<summary>Problems Related With Quadratic Probing</summary>



**1. Increased search time:**

* The computation of the probe sequence with squares adds an extra layer of complexity compared to linear probing's simple increments. This can increase the search time, especially for keys that encounter many collisions.

**2. Secondary clustering:**

* While primary clustering is reduced, secondary clustering can still occur if the probing sequence creates repetitive patterns based on specific hash values. This can lead to pockets of collisions despite the larger jumps.

**3. Tuning the probing sequence:**

* Choosing the right coefficients for the probing sequence (e.g., in `current_position + (i^2)`) can impact performance. An overly aggressive sequence might lead to early exhaustion of the table, while a conservative one might still suffer from clustering.

**4. Performance on non-random workloads:**

* Quadratic probing works best when hash values are random and evenly distributed. If the workload leads to predictable patterns in hash values, the probing sequence might become ineffective and lead to clustering.

**5. Potential for infinite loops:**

* In rare cases, specific combinations of hash values and probing sequences can create infinite loops where the same slots are repeatedly checked. This requires careful implementation and checks to avoid.

</details>



#### **Double Hashing**

* It uses two hash functions to determine the next probing location in case of a successive collision.

<figure><img src="../.gitbook/assets/image (11).png" alt="" width="375"><figcaption><p>Font: Geeks For Geeks, 2023a</p></figcaption></figure>

<details>

<summary>Searching for a key using Double Hashing probing in a hash table involves the following steps</summary>

1. **Calculate the initial hash values:**
   * Apply both hash functions (h1 and h2) to the key you want to find.
   * This gives you two hash values: h1(key) and h2(key).
2. **Calculate the initial index:**
   * Use the first hash value (h1(key)) as the initial index to probe in the hash table.
3. **Check the initial index:**
   * Look at the element at the initial index.
   * If the key matches the element, you've found it! Return "Found".
4. **Handle collisions:**
   * If the key doesn't match the element, and the element is not empty, there's a collision.
   * Use the second hash value (h2(key)) to calculate a step size for probing.
   * The next probe index is calculated as: `(initial_index + i * h2(key)) % table_size`, where `i` is an iteration counter starting from 1.
5. **Repeat steps 3 and 4:**
   * Keep probing using the calculated indices until one of the following conditions is met:
     * The key matches the element at the current index (you found it!).
     * You encounter an empty slot (the key is not present in the table).
     * You revisit the initial index without finding the key, indicating it's not in the table.
6. **Check for unsuccessful search:**
   * If you revisit the initial index without finding the key, it means the key is not present in the table. Return "Not found".

</details>

<details>

<summary>Problems Related With Double Hashing Probing</summary>



**1. Dependency on Two Good Hash Functions:**

* **Effectiveness hinges on both hash functions:** Double hashing relies on two independent hash functions. If either function produces poor distribution or patterns, it can lead to clustering and degrade performance.
* **Careful selection and design:** It's essential to choose hash functions that complement each other and minimize collisions.

**2. Potential for Clusters:**

* **Secondary clustering:** Although less severe than in linear or quadratic probing, secondary clustering can still occur if the second hash function generates repetitive step sizes for certain keys.
* **Table size and hash function design:** Mitigate this by choosing a prime table size and ensuring the second hash function produces well-distributed step sizes.

**3. Deletion Complexity:**

* **Marking for deletion:** Simply removing an element can disrupt the probing sequence for other keys that might have used it as a step.
* **Special handling:** Typically, deleted elements are marked as "deleted" rather than actually removed to preserve the probing sequence. This can create overhead for tracking deleted slots.

**4. Rehash Complexity:**

* **Recalculating probe sequences:** When the table needs to be resized, all elements need to be rehashed with both hash functions to determine their new probe sequences. This can be computationally expensive.
* **Careful planning:** Rehash operations should be minimized by choosing a suitable initial table size and load factor.

**5. Computational Overhead:**

* **Two hash calculations:** Double hashing involves calculating two hash values per key, which can add overhead compared to techniques that use a single hash function.
* **Trade-off evaluation:** The potential performance benefits in collision resolution need to be weighed against the computational cost for specific use cases.

</details>

<details>

<summary>Abstract Logic of Double Hashing</summary>



1. **Hash the key:** Apply both hash functions to the key to get `hash_value1` and `hash_value2`.
2. **Calculate initial index:** Use `hash_value1` as the first index to probe.
3. **Handle collisions:** If the first index is occupied, use `hash_value2` as the step size to generate subsequent probe indices:
   * `index = (hash_value1 + i * hash_value2) % table_size`
   * Keep incrementing `i` until an empty slot is found or the entire table has been probed.

```java

import java.util.ArrayList;

public class DoubleHashing {

    public static ArrayList<Integer> doubleHash(String key, int tableSize, HashFunction hashFunction1, HashFunction hashFunction2) {
        /*
         * Implements a double hash function for collision resolution.
         *
         * Args:
         *  key: The key to be hashed.
         *  tableSize: The size of the hash table.
         *  hashFunction1: The first hash function to use.
         *  hashFunction2: The second hash function to use.
         *
         * Returns:
         *  The probe sequence for the key based on the double hash function.
         */

        int hashValue1 = hashFunction1.hash(key, tableSize);
        int hashValue2 = hashFunction2.hash(key, tableSize);

        ArrayList<Integer> probeSequence = new ArrayList<>();
        for (int i = 0; i < tableSize; i++) {
            int index = (hashValue1 + i * hashValue2) % tableSize;
            probeSequence.add(index);
        }

        return probeSequence;
    }

    public static void main(String[] args) {
        int tableSize = 10;

        HashFunction hashFunction1 = (key, tableSize) -> {
            // Example hash function 1: Sum of character ASCII values
            int sum = 0;
            for (char c : key.toCharArray()) {
                sum += c;
            }
            return sum % tableSize;
        };

        HashFunction hashFunction2 = (key, tableSize) -> {
            // Example hash function 2: Length of the key
            return key.length() % tableSize;
        };

        String key = "apple";
        ArrayList<Integer> probeSequence = doubleHash(key, tableSize, hashFunction1, hashFunction2);

        System.out.println("Key: " + key + ", Probe sequence: " + probeSequence);
    }
}

interface HashFunction {
    int hash(String key, int tableSize);
}
```

</details>



### Resolving Collisions - Separate Chaining  (Open hashing)

* Separate chaining each slot in the hash table points to a separate data structure, such as a linked-list.&#x20;
* This linked-list or "chain" stores multiple elements that **share the same hash index**.&#x20;
* When a collision occurs, new elements are simply appended to the existing list in the corresponding slot.

<figure><img src="../.gitbook/assets/image (12).png" alt="" width="345"><figcaption><p>Font: Design Gurus, 2023a</p></figcaption></figure>

<details>

<summary>Implementation</summary>

```java
import java.util.ArrayList;
import java.util.List;

class Record {
    int Key;
    String Title;
    String PlacementInfo;

    public Record(int key, String title, String placement_info) {
        Key = key;
        Title = title;
        PlacementInfo = placement_info;
    }
}

class HashTable {
    private List<List<Record>> buckets; // List of lists to store the chains
    private int max_length; // To store the maximum number of elements a Hash table can store

    public HashTable(int size) {
        max_length = size;
        buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private int H(int key) {
        return key % max_length;
    }

    public boolean Insert(Record item) {
        int index = H(item.Key);

        // Traverse the chain at the index
        for (Record record : buckets.get(index)) {
            if (record.Key == item.Key) {
                return false; // Key already exists in the chain, cannot insert
            }
        }

        buckets.get(index).add(item);
        return true;
    }

    public boolean Search(int key, Record returnedItem) {
        int index = H(key);

        // Traverse the chain at the index
        for (Record record : buckets.get(index)) {
            if (record.Key == key) {
                returnedItem.Key = record.Key;
                returnedItem.Title = record.Title;
                returnedItem.PlacementInfo = record.PlacementInfo;
                return true; // Return true to indicate the record was found
            }
        }

        return false; // Record not found
    }

    public boolean Delete(int key) {
        int index = H(key);

        // Traverse the chain at the index
        List<Record> chain = buckets.get(index);
        for (int i = 0; i < chain.size(); i++) {
            Record record = chain.get(i);
            if (record.Key == key) {
                chain.remove(i);
                return true;
            }
        }

        return false; // The key is not found in the chain
    }

    public void ShowTable() {
        System.out.println("Index\tValue (Key, Title, PlacementInfo)");
        for (int i = 0; i < max_length; i++) {
            System.out.print(i + "\t");
            List<Record> chain = buckets.get(i);
            if (chain.isEmpty()) {
                System.out.println("[EMPTY BUCKET]");
            } else {
                for (int j = 0; j < chain.size(); j++) {
                    Record record = chain.get(j);
                    if (j > 0) {
                        System.out.print("--> ");
                    }
                    System.out.print("(" + record.Key + ", " + record.Title + ", " + record.PlacementInfo + ")");
                }
                System.out.println();
            }
        }
    }
}

class Solution {
    public static void main(String[] args) {
        int tableSize = 11;
        HashTable hashTable = new HashTable(tableSize);

        // Insert initial book information
        hashTable.Insert(new Record(1701, "Internet of Things", "G1 Shelf"));
        hashTable.Insert(new Record(1712, "Statistical Analysis", "G1 Shelf"));
        hashTable.Insert(new Record(1718, "Grid Computing", "H2 Shelf"));
        hashTable.Insert(new Record(1735, "UML Modeling", "G1 Shelf"));
        hashTable.Insert(new Record(1752, "Professional Practices", "G2 Shelf"));

        // Display the hash table after initial insertions
        System.out.println("\nHash Table after initial insertions:");
        hashTable.ShowTable();

        // Insert the following record
        hashTable.Insert(new Record(1725, "Deep Learning with Python", "C3 Shelf"));

        // Display the hash table after the last insertion
        System.out.println("\nHash Table inserting Book Key 1725:");
        hashTable.ShowTable();

        // Delete two records
        hashTable.Delete(1701);
        hashTable.Delete(1718);

        // Display the hash table after deletions
        System.out.println("\nHash Table after deleting 1701 and 1718:");
        hashTable.ShowTable();
    }
}
```

</details>



#### Advantages of Separate Chaining

* **Dynamic Memory Usage:** Insertions (append new nodes at the chains/linkedlist) and deletions (remove nodes at the chains/linkedlist) can adjust the size of the table based on the number of elements, unlike closed hashing which requires marking deleted items.
* **Simple Implementation:** Implementing separate chaining is straightforward using linked lists.
* **Graceful Handling of Duplicates:** Duplicate keys can be stored and retrieved accurately.



#### Downsides of Separate Chaining:

* **Increased Memory Overhead:** Additional memory is required to store pointers or references to linked lists, leading to increased memory usage, especially for small data sets.
* **Cache Inefficiency:** Traversing the linked lists can negatively impact cache performance due to non-contiguous memory access, reducing overall efficiency.
* External Fragmentation: Dynamic memory allocation for linked lists can result in external fragmentation, which can affect memory management performance.
* **Worst-Case Time Complexity:** When multiple keys are hashed to the same bucket, forming long linked lists, search, insert, and delete operations can degrade to `O(n)`, making it less suitable for time-critical applications.
* **Memory Allocation Overhead:** Dynamic memory allocation for each new element can introduce overhead and potentially cause performance issues under high memory pressure.



### Handling Overflows

* Closed hashing techniques experience overflow when entries **fill up the fixed hash table slots**.
  * the load-factor `α = n / m` should not cross `0.5`.
    * `n` is the number of entries and `m` is table size.
* Open hashing techniques encounters overflow when chain lengths become too long.
  * the load-factor `α = n / m` should not cross `0.8` or `0.9`.
* :question:**Why the load-factor should not be crossed**.
  * Because the hash table can experiences a **significant increase in collisions**, problems in searching, and degrading performance and integrity of the table operations.
* :question:**How to solve overflow?**
  * **Resizing** the hash table can help alleviate the overflow issues.



### Resizing

* **Resizing** involves increasing the size of a hash table to prevent overflows and maintain a specific **load factor**.&#x20;
* When the number of elements in the hash table exceeds a certain threshold, resizing ensures that the table can accommodate additional data without compromising performance or causing collisions.
* :question: When resizing, do the old values remain in the same place in the new table?
  * **NO**!! As resizing changes the table size, the values must be **Rehashed** to maintain the correctness of the data structure.



### Rehashing

* Rehashing involves applying a new hash function to all the entries in a hash table to make the table more evenly distributed.
* It is recommended to perform rehashing periodically when the load-factor exceeds thresholds or based on metrics like average chain length.



### Resizing and Rehashing Process

1. **Load-Factor Threshold Check**:
   * The process begins by monitoring the load factor of the hash table. When the load factor exceeds a predefined threshold (often denoted as `α`), it indicates that the table is becoming crowded, and resizing is necessary.
2. **Creating a Larger Hash Table**:
   * Upon detecting the need for resizing, a new hash table is created. The capacity of this new table is typically larger than the original one. Common practice involves doubling the size of the existing table.
3. **Element Rehashing**:
   * Next, each element from the existing hash table is rehashed into the new table. Rehashing involves recalculating the hash value for each element using the primary hash function, but with the new table size. This step ensures that elements are distributed evenly across the larger table.
4. **Replacing the Old Table**:
   * Once all elements have been rehashed, the new hash table replaces the old one. The old table is then deallocated from memory to free up resources.



### Selecting a Hash Function

#### Characteristics of a good hash function

* **Uniformity and Distribution**
  * It spreads out keys evenly across all slots in the hash table.
* **Collision Reduction**
  * Different keys should end up getting mapped to different slots as much as possible.
* **Efficiency**
  * Requires minimal processing power and time to compute.

### Hash function design techniques <a href="#hash-function-design-techniques" id="hash-function-design-techniques"></a>

**Division method**

* The hash code is calculated by taking the remainder obtained by dividing the key by the size of the hash table (the number of buckets).
* Mathematically, the division method is expressed as: `hash_key = key % table_size`.
* :warning: it may not be the best choice if the key distribution is not uniform or the table size is not a prime number, which may lead to clustering.



#### Folding method

* To calculate the hash code, divide the key into smaller <mark style="background-color:orange;">**subkeys**</mark> and then combine them.
* **Example of Folding methods:**
  1. **Division method**:
     * Split the key into groups of digits, and their sum is taken as the hash code.&#x20;
     * For example, can hash the key `541236` using **digit sum folding** into a hash table of size `5`:&#x20;
     * hash key = `( 5 + 4 + 1 + 2 + 3 + 6  ) % 5`
     * hash key = `21 % 5`&#x20;
     * hash key = `1`.
  2. **Reduction**:
     * To generate the final hash value, split the key into folds and use reduction with an associative operation such as `XOR` to reduce the folds to a single value. Then, pass this single value through a simple division hash function.
     * Example: hash this 12-digit key `593048892357` onto a table of size `11113`.
       * split it into 3 parts of digits 4:
         * `5930, 4889, 2357`.
       * Then XOR the parts and pass through an ordinary hash function as:
         * hash key = `(5930`` `**`XOR`**` ``4889`` `**`XOR`**` ``2357) % 11113`.
         * hash key = `7041`.
* The **folding method** is an efficient way to handle large keys and provides better key distribution than the division method.&#x20;
* It is commonly used when dealing with lengthy keys or when **subkeys** need to be created for other purposes.



#### Mid-square Method

* The mid-square method squares the key, extracts the middle part and uses it as the hash code.
* Process:
  * Square the key.
  * Extract the K middle digits of the square.
  * Apply simple division on these middle digits to get the final hash.
* Example: hash this 4-digit key `3729` onto a table of size `10`.
  * Square the key: `3729 * 3729 = 13935241`.
  * Extract the middle digits to get the hash value: `935`.
  * Calculate the hash:
    * hash key =  `935 % 10`.
    * hash key = `5`.



### Reference

Geeks For Geeks. Open Addressing Collision Handling technique in Hashing. Geeks For Geeks, \[s.d.]. Disponível em: <[https://www.geeksforgeeks.org/types-of-binary-tree](https://www.geeksforgeeks.org/types-of-binary-tree)>. Acesso em: 11 dez. 2023a.

Design Gurus. Grokking Data Structures for Coding Interviews: Issues with Hash Tables. Design Gurus, 2023. Disponível em: <[https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/64b7b84daab5a6129791002b](https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/64b7b84daab5a6129791002b)>. Acesso em: 11 dez. 2023a.

RAMACHANDRAN, Ranjith. _How HashMap works in Java? With Animation!! whats new in java8 tutorial_. \[Videoaula]. YouTube, 2015. Disponível em: [https://www.youtube.com/watch?v=c3RVW3KGIIE](https://www.youtube.com/watch?v=c3RVW3KGIIE). Acesso em: 29 dez. 2023.
