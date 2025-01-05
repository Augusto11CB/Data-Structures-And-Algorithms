package com.buenosdev.companiesquestions.uber.lengthOfLis

class ProblemSolutionKt {
    fun lengthOfLIS(nums: IntArray): Int {
        // Create an array 'lis' where lis[i] represents the length of the longest increasing subsequence that ends at index i.
        val lis = IntArray(nums.size) { 1 }

        // Iterate through the nums array from the end to the beginning.
        // This helps in building the solution in a bottom-up manner.
        // By starting at the last index, we can easily initialize the base case for our dynamic programming solution. At the last index, the longest increasing subsequence ending at that index is just the element itself, which has a length of 1.
        for (i in nums.size - 1 downTo 0) {

            // For each element at index i, look at all elements to the right of it (index j).
            for (j in i + 1 until nums.size) {
                // If nums[i] is less than nums[j], then nums[i] can be part of the increasing subsequence ending at nums[j].
                if (nums[i] < nums[j]) {
                    // Update lis[i] to be the maximum of its current value and 1 + lis[j],
                    // where 1 represents the length of subsequence including nums[i] itself.
                    lis[i] = Math.max(1 + lis[j], lis[i])
                }
            }
        }

        // Find the maximum value in the lis array, which represents the length of the longest increasing subsequence in nums.
        val result = lis.maxOrNull()

        // Return the result. If the result is null (which happens if nums is empty), return 0.
        return if (result == null) 0 else result
    }

}