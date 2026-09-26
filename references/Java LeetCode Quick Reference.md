# Java LeetCode Quick Reference — Draft

> A personal, LeetCode-submission-focused reference based on the patterns used
> most often in this repository: greedy, trie, stack, queue, tree, heap, hash,
> arrays/matrices, and linked lists.

## Submission baseline

Put only the required method and helpers inside `class Solution`. LeetCode
supplies `ListNode`, `TreeNode`, and problem-specific interfaces when needed.

```java
import java.util.*;

class Solution {
    public int solve(int[] nums) {
        return 0;
    }
}
```

Use `long` for sums, products, distances, or counts when constraints can
exceed `int`. Do not add `package`, `main`, or input parsing code.

## Rapid lookup

| Need | Use | Core operations |
| --- | --- | --- |
| Count or lookup | `HashMap<K, V>` | `getOrDefault`, `merge`, `computeIfAbsent` |
| Membership / visited | `HashSet<T>` | `add`, `contains`, `remove` |
| Stack | `Deque<T> stack = new ArrayDeque<>()` | `push`, `pop`, `peek` |
| Queue | `Deque<T> queue = new ArrayDeque<>()` | `offer`, `poll`, `peek` |
| Monotonic queue | `Deque<Integer>` of indices | `peekFirst`, `peekLast`, `pollLast` |
| Minimum / maximum next | `PriorityQueue<T>` | `offer`, `poll`, `peek` |
| Ordered keys | `TreeMap<K, V>` / `TreeSet<T>` | `firstKey`, `floorKey`, `ceilingKey` |
| Repeated string construction | `StringBuilder` | `append`, `deleteCharAt`, `reverse` |
| Fixed alphabet | `int[26]` | `ch - 'a'` |
| Dynamic graph | `List<List<Integer>>` | one separate list per vertex |

```java
// A max heap. Prefer this safe comparator over (a, b) -> b - a.
PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>(Comparator.reverseOrder());

// A min heap ordered by the first value in an int[] pair.
PriorityQueue<int[]> minHeap =
        new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));

// Group values by key.
Map<Integer, List<Integer>> groups = new HashMap<>();
groups.computeIfAbsent(key, ignored -> new ArrayList<>()).add(value);
```

`ArrayDeque` is the default stack/queue choice. It avoids the legacy
`Stack` API and is generally preferable to `LinkedList` when only deque
operations are required. `ArrayDeque` does not allow `null` elements.

---

# Core patterns from this problem set

## 1. Hashing and frequency counting

**Use when:** duplicates, anagrams, character counts, Two Sum, or a previous
index/value lookup matters.

```java
private boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    for (int value : nums) {
        if (!seen.add(value)) {
            return true;
        }
    }
    return false;
}

private int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> indexByValue = new HashMap<>();
    for (int index = 0; index < nums.length; index++) {
        int needed = target - nums[index];
        if (indexByValue.containsKey(needed)) {
            return new int[] {indexByValue.get(needed), index};
        }
        indexByValue.put(nums[index], index);
    }
    return new int[0];
}

private Map<Character, Integer> characterFrequency(String s) {
    Map<Character, Integer> frequency = new HashMap<>();
    for (char ch : s.toCharArray()) {
        frequency.merge(ch, 1, Integer::sum);
    }
    return frequency;
}
```

**Cost:** O(n) expected time and O(k) space. `HashMap` iteration order is not
guaranteed.

## 2. Stack and monotonic stack

**Use when:** matching brackets, undoing recent work, next greater/smaller
values, or keeping a lexicographically optimal result.

### Balanced parentheses

```java
private boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } else if (ch == ')' || ch == ']' || ch == '}') {
            if (stack.isEmpty()) {
                return false;
            }
            char open = stack.pop();
            if ((ch == ')' && open != '(')
                    || (ch == ']' && open != '[')
                    || (ch == '}' && open != '{')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

### Next greater element to the right

Store indices. Pop values that are no longer candidates for the answer.

```java
private int[] nextGreaterRight(int[] nums) {
    int[] answer = new int[nums.length];
    Arrays.fill(answer, -1);
    Deque<Integer> stack = new ArrayDeque<>();

    for (int index = 0; index < nums.length; index++) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
            answer[stack.pop()] = nums[index];
        }
        stack.push(index);
    }
    return answer;
}
```

**Invariant:** values at the stored indices are decreasing from the stack top
to the bottom. Each index is pushed and popped once: O(n) time.

### Remove duplicate letters / smallest subsequence

```java
private String removeDuplicateLetters(String s) {
    int[] remaining = new int[26];
    boolean[] used = new boolean[26];
    for (char ch : s.toCharArray()) {
        remaining[ch - 'a']++;
    }

    Deque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
        int id = ch - 'a';
        remaining[id]--;
        if (used[id]) {
            continue;
        }
        while (!stack.isEmpty() && stack.peek() > ch
                && remaining[stack.peek() - 'a'] > 0) {
            used[stack.pop() - 'a'] = false;
        }
        stack.push(ch);
        used[id] = true;
    }

    StringBuilder answer = new StringBuilder();
    while (!stack.isEmpty()) {
        answer.append(stack.removeLast());
    }
    return answer.toString();
}
```

---

## 3. Queue and monotonic deque

**Use when:** first-in-first-out processing, BFS, task rotation, or a sliding
window maximum/minimum.

### Sliding-window maximum

The deque holds indices whose values are decreasing. The front is always the
maximum for the current window.

```java
private int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0 || k == 0) {
        return new int[0];
    }

    int[] answer = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();

    for (int index = 0; index < nums.length; index++) {
        while (!deque.isEmpty() && deque.peekFirst() <= index - k) {
            deque.pollFirst();
        }
        while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[index]) {
            deque.pollLast();
        }
        deque.offerLast(index);

        if (index >= k - 1) {
            answer[index - k + 1] = nums[deque.peekFirst()];
        }
    }
    return answer;
}
```

**Cost:** O(n) time and O(k) space. Store indices rather than values so an
expired value can be identified reliably.

---

## 4. Heap patterns

**Use when:** repeatedly selecting the smallest/largest item, scheduling by
end time, top-k selection, or maintaining a running median.

### K smallest values

```java
private int[] kSmallest(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Comparator.reverseOrder());
    for (int value : nums) {
        maxHeap.offer(value);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }

    int[] answer = new int[maxHeap.size()];
    for (int index = answer.length - 1; index >= 0; index--) {
        answer[index] = maxHeap.poll();
    }
    return answer;
}
```

**Cost:** O(n log k) time, O(k) space. Iterating a `PriorityQueue` is not
sorted—poll it if sorted output is needed.

### Median from data stream

```java
class MedianFinder {
    private final PriorityQueue<Integer> lower =
            new PriorityQueue<>(Comparator.reverseOrder());
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();

    public void addNum(int num) {
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
        } else {
            upper.offer(num);
        }

        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
        if (lower.size() > upper.size()) {
            return lower.peek();
        }
        return ((long) lower.peek() + upper.peek()) / 2.0;
    }
}
```

**Invariant:** every lower value is at most every upper value, and `lower` has
either the same number of elements as `upper` or one more.

---

## 5. Greedy and intervals

**Use when:** a locally best safe choice leaves the most room for future
choices. Sorting is often the first step.

### Sort intervals by end: maximum compatible selections

This is the basis for non-overlapping intervals. Count rejected intervals when
the problem asks for removals.

```java
private int eraseOverlapIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
    int keptEnd = Integer.MIN_VALUE;
    int removals = 0;

    for (int[] interval : intervals) {
        if (interval[0] >= keptEnd) {
            keptEnd = interval[1];
        } else {
            removals++;
        }
    }
    return removals;
}
```

### Meeting rooms: minimum concurrent intervals

```java
private int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    PriorityQueue<Integer> endTimes = new PriorityQueue<>();

    for (int[] interval : intervals) {
        if (!endTimes.isEmpty() && endTimes.peek() <= interval[0]) {
            endTimes.poll();
        }
        endTimes.offer(interval[1]);
    }
    return endTimes.size();
}
```

**Cost:** O(n log n). The heap must track the earliest finishing room; an
unordered map of rooms cannot safely find that room.

### Boats / pair a lightest with heaviest

```java
private int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int left = 0;
    int right = people.length - 1;
    int boats = 0;

    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            left++;
        }
        right--;
        boats++;
    }
    return boats;
}
```

### Jump Game: farthest reachable index

```java
private boolean canJump(int[] nums) {
    int farthest = 0;
    for (int index = 0; index < nums.length; index++) {
        if (index > farthest) {
            return false;
        }
        farthest = Math.max(farthest, index + nums[index]);
    }
    return true;
}
```

---

## 6. Trie

**Use when:** many queries share string prefixes, such as word search,
autocomplete, prefix matching, or dictionary segmentation.

### Lowercase English alphabet trie

```java
private static final class TrieNode {
    private final TrieNode[] children = new TrieNode[26];
    private boolean isWord;
}

private final TrieNode root = new TrieNode();

private void insert(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (node.children[index] == null) {
            node.children[index] = new TrieNode();
        }
        node = node.children[index];
    }
    node.isWord = true;
}

private boolean search(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
        node = node.children[ch - 'a'];
        if (node == null) {
            return false;
        }
    }
    return node.isWord;
}

private boolean startsWith(String prefix) {
    TrieNode node = root;
    for (char ch : prefix.toCharArray()) {
        node = node.children[ch - 'a'];
        if (node == null) {
            return false;
        }
    }
    return true;
}
```

Use `Map<Character, TrieNode>` for a broad or sparse character set. Use an
array for known lowercase English letters when speed and simple indexing matter.

### Wildcard word search

```java
private boolean searchWithWildcard(String word, int index, TrieNode node) {
    if (index == word.length()) {
        return node.isWord;
    }

    char ch = word.charAt(index);
    if (ch != '.') {
        TrieNode child = node.children[ch - 'a'];
        return child != null && searchWithWildcard(word, index + 1, child);
    }

    for (TrieNode child : node.children) {
        if (child != null && searchWithWildcard(word, index + 1, child)) {
            return true;
        }
    }
    return false;
}
```

---

## 7. Trees and BSTs

**Use when:** input has parent/child structure, recursive definitions, or
ordered BST properties.

### Level-order traversal

```java
private List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> answer = new ArrayList<>();
    if (root == null) {
        return answer;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> level = new ArrayList<>(levelSize);
        for (int count = 0; count < levelSize; count++) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        answer.add(level);
    }
    return answer;
}
```

### BST kth smallest: iterative inorder

```java
private int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;

    while (true) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        if (--k == 0) {
            return node.val;
        }
        node = node.right;
    }
}
```

Inorder traversal of a BST visits values in ascending order.

---

## 8. Linked lists

**Use when:** relinking nodes, merging ordered chains, or detecting a cycle or
middle point. Save `next` before overwriting it.

### Reverse a list

```java
private ListNode reverseList(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    while (current != null) {
        ListNode next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }
    return previous;
}
```

### Merge two sorted lists: dummy node

```java
private ListNode mergeTwoLists(ListNode first, ListNode second) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    while (first != null && second != null) {
        if (first.val <= second.val) {
            tail.next = first;
            first = first.next;
        } else {
            tail.next = second;
            second = second.next;
        }
        tail = tail.next;
    }
    tail.next = first != null ? first : second;
    return dummy.next;
}
```

### Slow and fast pointers

```java
private ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

---

# General templates

## Sliding window: longest substring without repeats

```java
private int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> lastIndex = new HashMap<>();
    int left = 0;
    int best = 0;

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);
        left = Math.max(left, lastIndex.getOrDefault(ch, -1) + 1);
        lastIndex.put(ch, right);
        best = Math.max(best, right - left + 1);
    }
    return best;
}
```

## Prefix sum + frequency map

```java
private int subarraySum(int[] nums, int target) {
    Map<Integer, Integer> prefixes = new HashMap<>();
    prefixes.put(0, 1);
    int sum = 0;
    int count = 0;

    for (int value : nums) {
        sum += value;
        count += prefixes.getOrDefault(sum - target, 0);
        prefixes.merge(sum, 1, Integer::sum);
    }
    return count;
}
```

Seed the zero prefix: it represents a matching subarray that starts at index 0.

## DFS and BFS graph traversal

```java
private List<List<Integer>> makeGraph(int n) {
    List<List<Integer>> graph = new ArrayList<>(n);
    for (int node = 0; node < n; node++) {
        graph.add(new ArrayList<>());
    }
    return graph;
}

private void dfs(int node, List<List<Integer>> graph, boolean[] seen) {
    seen[node] = true;
    for (int neighbor : graph.get(node)) {
        if (!seen[neighbor]) {
            dfs(neighbor, graph, seen);
        }
    }
}

private int[] bfsDistances(int start, List<List<Integer>> graph) {
    int[] distance = new int[graph.size()];
    Arrays.fill(distance, -1);
    distance[start] = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int neighbor : graph.get(node)) {
            if (distance[neighbor] == -1) {
                distance[neighbor] = distance[node] + 1;
                queue.offer(neighbor);
            }
        }
    }
    return distance;
}
```

Use BFS for fewest edges in an unweighted graph. Mark as visited when enqueuing,
not after dequeuing.

## Binary search: first true

```java
private int firstTrue(int low, int high) {
    // Invariant: the inclusive range contains an answer and isValid(high) is true.
    while (low < high) {
        int middle = low + (high - low) / 2;
        if (isValid(middle)) {
            high = middle;
        } else {
            low = middle + 1;
        }
    }
    return low;
}
```

---

# Pre-submit check

- Check empty input, one item/node, duplicates, and all-equal values.
- Check whether the method may mutate the input or linked/tree nodes.
- Use `.equals(...)` for object content; reserve `==` for primitives, `null`,
  enums, or intentional identity comparison.
- Do not use subtraction in a comparator; use `Integer.compare` or comparator
  builders to avoid overflow.
- Be explicit about inclusive/exclusive bounds and whether intervals that touch
  at an endpoint overlap for this problem.
- For recursive DFS/backtracking, verify that input depth will not overflow the
  Java call stack; use an explicit stack when necessary.
