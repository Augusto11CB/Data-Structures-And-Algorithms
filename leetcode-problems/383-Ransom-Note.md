# 383 Ransom Note
## Intuition
I thought to store the occurrences of the magazine chars as a `key` in the HashMap and their frequency as a `value` in the HashMap. Then, for each `key` in the ransom note present in the HashMap, I subtracted -1 from the `value`.

## Complexity
- Time complexity: O(m+n)
    - The `m` is the size of the `ransomNote` and the `n` is the size of `magazine`. The first loop that iterates over magazine has a time complexity of `O(n)`. The second loop iterates over ransomNote, thus has a time complexity of `O(m)`.

- Space complexity: O(n)
    - The HashMap can potentially store all the characters in the magazine string, so the space complexity is `O(n)`.