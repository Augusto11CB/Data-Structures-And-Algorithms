# Java Collections and Patterns

Compact Java snippets distilled from the solutions in `practice/src/main/java/com/buenosdev`.
Use `var` for obvious local types; keep explicit types for fields, method signatures, and when the initializer does not make the type clear.

```java
import java.util.*;
```

## Fast lookup

| Need | Use | Core operations |
| --- | --- | --- |
| Frequency / value by key | `HashMap<K, V>` | `getOrDefault`, `put`, `merge` |
| Fast membership / de-duplication | `HashSet<T>` | `add`, `contains`, `remove` |
| Sorted keys and frequencies | `TreeMap<K, V>` | `firstKey`, `firstEntry` |
| Dynamic indexed values | `ArrayList<T>` | `add`, `get`, `set` |
| Stack, queue, or deque | `ArrayDeque<T>` | `push`, `pop`, `offer`, `poll` |
| Smallest/largest item repeatedly | `PriorityQueue<T>` | `offer`, `poll`, `peek` |
| Mutable string / DFS path | `StringBuilder` | `append`, `deleteCharAt`, `setLength` |

`ArrayDeque` is the default stack/queue here. The practice code also uses legacy `Stack` and `LinkedList`; prefer `ArrayDeque` for new LeetCode solutions unless you specifically need a linked list.

## Arrays and strings

```java
var chars = s.toCharArray();
for (var c : chars) { /* use c */ }

var copy = Arrays.copyOf(nums, nums.length);
Arrays.sort(nums);
Arrays.fill(dp, -1);

var reversed = new StringBuilder(s).reverse().toString();
var piece = s.substring(left, right); // right is exclusive
```

### Two pointers

```java
Arrays.sort(nums);
var left = 0;
var right = nums.length - 1;

while (left < right) {
    if (nums[left] + nums[right] <= limit) left++;
    right--;
}
```

### Character frequency when the alphabet is small

```java
var count = new int[26];
for (var c : s.toCharArray()) count[c - 'a']++;

if (count[c - 'a']-- == 0) return false;
```

Use an array when the character range is known; use a `HashMap<Character, Integer>` when it is not.

## HashMap and HashSet

### Frequency map

```java
var freq = new HashMap<Character, Integer>();
for (var c : s.toCharArray()) {
    freq.put(c, freq.getOrDefault(c, 0) + 1);
    // equivalent: freq.merge(c, 1, Integer::sum);
}
```

### Complement lookup (Two Sum)

```java
var indexByValue = new HashMap<Integer, Integer>();
for (var i = 0; i < nums.length; i++) {
    var needed = target - nums[i];
    if (indexByValue.containsKey(needed)) {
        return new int[] { indexByValue.get(needed), i };
    }
    indexByValue.put(nums[i], i);
}
```

### Set membership and duplicate detection

```java
var seen = new HashSet<Integer>();
for (var value : nums) {
    if (!seen.add(value)) return true; // add returns false if already present
}
return false;
```

### Group values by key

```java
var graph = new HashMap<Integer, List<Integer>>();
for (var edge : edges) {
    graph.computeIfAbsent(edge[0], ignored -> new ArrayList<>()).add(edge[1]);
}
```

### Iterate maps

```java
for (var entry : freq.entrySet()) {
    var key = entry.getKey();
    var value = entry.getValue();
}

for (var key : freq.keySet()) { /* key */ }
for (var value : freq.values()) { /* value */ }
```

## ArrayList and ordered maps

```java
var values = new ArrayList<Integer>();
values.add(7);
values.set(0, 9);
var first = values.get(0);
var last = values.get(values.size() - 1);
```

Use `TreeMap` for ordered keys, such as consuming consecutive values in `Hand of Straights`-style problems.

```java
var counts = new TreeMap<Integer, Integer>();
for (var n : hand) counts.merge(n, 1, Integer::sum);

var smallest = counts.firstKey();
counts.put(smallest, counts.get(smallest) - 1);
if (counts.get(smallest) == 0) counts.remove(smallest);
```

## Stack: `ArrayDeque`

```java
var stack = new ArrayDeque<Character>();
stack.push('a');       // add to top
var top = stack.peek(); // inspect top; null if empty
var popped = stack.pop(); // remove top; throws if empty
```

### Matching parentheses

```java
var opens = Map.of(')', '(', ']', '[', '}', '{');
var stack = new ArrayDeque<Character>();

for (var c : s.toCharArray()) {
    if (opens.containsValue(c)) stack.push(c);
    else if (stack.isEmpty() || stack.pop() != opens.get(c)) return false;
}
return stack.isEmpty();
```

### Monotonic stack: next greater element

Store indices when you need distances or answers in the original order.

```java
var answer = new int[nums.length];
var stack = new ArrayDeque<Integer>();

for (var i = 0; i < nums.length; i++) {
    while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
        answer[stack.pop()] = nums[i];
    }
    stack.push(i);
}
```

For a decreasing stack, reverse the comparison. This pattern appears in next-greater, remove-k-digits, and remove-duplicate-letters problems.

## Queue and deque: `ArrayDeque`

```java
var queue = new ArrayDeque<Integer>();
queue.offer(1);          // add at back
var next = queue.peek(); // inspect front; null if empty
var value = queue.poll(); // remove front; null if empty
```

### BFS

```java
var queue = new ArrayDeque<Integer>();
var visited = new HashSet<Integer>();
queue.offer(source);
visited.add(source);

while (!queue.isEmpty()) {
    var node = queue.poll();
    for (var neighbor : graph.getOrDefault(node, List.of())) {
        if (visited.add(neighbor)) queue.offer(neighbor);
    }
}
```

### Monotonic deque: maximum of each window

Store indices. Remove smaller values from the back and expired indices from the front.

```java
var maxes = new int[nums.length - k + 1];
var deque = new ArrayDeque<Integer>();

for (var i = 0; i < nums.length; i++) {
    while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) deque.pollLast();
    while (!deque.isEmpty() && deque.peekFirst() <= i - k) deque.pollFirst();
    deque.offerLast(i);
    if (i >= k - 1) maxes[i - k + 1] = nums[deque.peekFirst()];
}
```

## PriorityQueue (heap)

Java's default heap is a min-heap.

```java
var minHeap = new PriorityQueue<Integer>();
minHeap.offer(4);
minHeap.offer(1);
var smallest = minHeap.poll(); // 1
```

### Max-heap and safe comparators

Avoid subtraction (`b - a`), which can overflow. Prefer `Integer.compare` or comparator helpers.

```java
var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
var byEnd = Comparator.comparingInt((int[] interval) -> interval[1]);
var byCountDescending = Comparator.<Map.Entry<Character, Integer>>
        comparingInt(Map.Entry::getValue)
        .reversed();
```

### Keep the k largest values

```java
var heap = new PriorityQueue<Integer>();
for (var n : nums) {
    heap.offer(n);
    if (heap.size() > k) heap.poll();
}
return heap.peek();
```

### Two heaps for a stream median

```java
var lower = new PriorityQueue<Integer>(Comparator.reverseOrder());
var upper = new PriorityQueue<Integer>();

if (lower.isEmpty() || num <= lower.peek()) lower.offer(num);
else upper.offer(num);

if (lower.size() > upper.size() + 1) upper.offer(lower.poll());
if (upper.size() > lower.size()) lower.offer(upper.poll());

var median = lower.size() > upper.size()
        ? (double) lower.peek()
        : ((double) lower.peek() + upper.peek()) / 2;
```

## Sorting and custom comparators

### Primitive arrays

```java
Arrays.sort(nums);
```

### Intervals and arrays of pairs

```java
Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[1]));
```

### Object lists

```java
intervals.sort(Comparator.comparingInt(interval -> interval.start));
intervals.sort(Comparator
        .comparingInt((Interval interval) -> interval.end)
        .thenComparingInt(interval -> interval.start));
```

### Lambda equivalent

```java
intervals.sort((a, b) -> Integer.compare(a.end, b.end));
```

Use the `Comparator.comparingInt` form when it makes the sort key obvious; use `Integer.compare` for a compact multi-field or custom rule. Both are safer than subtraction.

## StringBuilder

Use it for repeated string construction—especially stacks rebuilt as strings, binary conversion, and trie DFS paths.

```java
var sb = new StringBuilder();
sb.append('a').append(42);
sb.deleteCharAt(sb.length() - 1); // remove last character
sb.setLength(0);                  // clear
var result = sb.toString();
```

### DFS/backtracking path

Always undo exactly what was appended before exploring the next branch.

```java
void dfs(Node node, StringBuilder path) {
    if (node.word) answer.add(path.toString());

    for (var entry : node.children.entrySet()) {
        path.append(entry.getKey());
        dfs(entry.getValue(), path);
        path.deleteCharAt(path.length() - 1);
    }
}
```

## Trie: array children and map children

The practice solutions use both. Prefer an array for a known lowercase alphabet; use a map for arbitrary characters or naturally ordered traversal (`TreeMap`).

```java
class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean word;
}

void insert(TrieNode root, String word) {
    var node = root;
    for (var c : word.toCharArray()) {
        var index = c - 'a';
        if (node.next[index] == null) node.next[index] = new TrieNode();
        node = node.next[index];
    }
    node.word = true;
}
```

```java
class MapTrieNode {
    Map<Character, MapTrieNode> children = new HashMap<>();
    boolean word;
}

void insert(MapTrieNode root, String word) {
    var node = root;
    for (var c : word.toCharArray()) {
        node = node.children.computeIfAbsent(c, ignored -> new MapTrieNode());
    }
    node.word = true;
}
```

## Graph adjacency list and traversal

```java
var graph = new HashMap<Integer, List<Integer>>();
for (var edge : edges) {
    graph.computeIfAbsent(edge[0], ignored -> new ArrayList<>()).add(edge[1]);
    graph.computeIfAbsent(edge[1], ignored -> new ArrayList<>()).add(edge[0]);
}
```

### Iterative DFS

```java
var stack = new ArrayDeque<Integer>();
var visited = new HashSet<Integer>();
stack.push(source);

while (!stack.isEmpty()) {
    var node = stack.pop();
    if (!visited.add(node)) continue;
    for (var neighbor : graph.getOrDefault(node, List.of())) stack.push(neighbor);
}
```

For graph nodes numbered `0..n - 1`, a `boolean[] visited` is usually simpler and faster than a set.

## Recurring small patterns

### Prefix sum

```java
var prefix = new int[nums.length + 1];
for (var i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];

var sumLeftToRight = prefix[right + 1] - prefix[left];
```

### Binary search boundary

```java
var left = 0;
var right = nums.length - 1;
while (left <= right) {
    var mid = left + (right - left) / 2;
    if (nums[mid] < target) left = mid + 1;
    else right = mid - 1;
}
// left is the insertion position / first index >= target
```

### Linked-list dummy node

```java
var dummy = new ListNode(0);
var tail = dummy;

while (a != null && b != null) {
    if (a.val <= b.val) { tail.next = a; a = a.next; }
    else { tail.next = b; b = b.next; }
    tail = tail.next;
}
tail.next = a != null ? a : b;
return dummy.next;
```

### In-place linked-list reversal

```java
ListNode previous = null;
var current = head;
while (current != null) {
    var next = current.next;
    current.next = previous;
    previous = current;
    current = next;
}
return previous;
```

## Submission notes

- `var` works only for local variables with an initializer; it cannot declare a field, parameter, return type, or untyped `null`.
- `poll`/`peek` return `null` on an empty queue/deque/heap; `remove`/`element`/`pop` throw. Check emptiness when necessary.
- `List.of()` is an immutable empty list, ideal as a `getOrDefault` fallback when you only iterate.
- Favor `ArrayDeque` over `Stack` and `LinkedList` for ordinary stack/queue work.
- Favor `Integer.compare(a, b)` or `Comparator.comparingInt(...)` over `a - b` comparators.
