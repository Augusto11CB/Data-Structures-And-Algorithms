package com.buenosdev.dynamicProgramming.palindromePartitioning

class Solution {

    fun partition(s: String): List<List<String>> {
        // Result list to store all possible palindrome partitions.
        var result = ArrayList<List<String>>()

        // If the input string is null or blank, add an empty list to the result.
        if (s.isNullOrBlank()) {
            result.add(emptyList())
        }

        // Call the helper function to start the recursive process.
        helper(s, ArrayDeque<String>(), result)

        // Return the result list containing all palindrome partitions.
        return result
    }

    // Helper function to recursively find all palindrome partitions.
    fun helper(
        s: String, // The remaining substring to process.
        subSet: ArrayDeque<String>, // A deque to store the current partition being built.
        res: ArrayList<List<String>> // The result list to store all partitions.
    ) {
        // Base case: if the remaining substring is null or blank, add the current partition to the result.
        if (s.isNullOrBlank()) {
            // Convert the current `subSet` to a list and add it to `res`.
            // This ensures that a copy of the current state of `subSet` is stored in `res`.
            // Other wise a list of empty lists would be return as a result
            res.add(subSet.toList())
            return
        }

        // Iterate over the substring to partition it.
        for (i in 0 until s.length) {
            // Skip if the substring `s[0..i]` is not a palindrome.
            if (!isPalindrome(s, i)) continue

            // Add the current palindrome substring `s[0..i]` to the current partition.
            subSet.addLast(s.substring(0, i + 1))
            // Recursively call the helper function with the remaining substring `s[i+1..end]`.
            helper(s.substring(i + 1), subSet, res)
            // Backtrack: remove the last added palindrome substring to try other partitions.
            subSet.removeLast()
        }
    }

    fun isPalindrome(s: String, end: Int): Boolean {
        var i = 0
        var j = end
        while (i < j) {
            // If characters do not match, it's not a palindrome.
            if (s[i] != s[j]) return false
            i++
            j--
        }
        return true
    }

}
