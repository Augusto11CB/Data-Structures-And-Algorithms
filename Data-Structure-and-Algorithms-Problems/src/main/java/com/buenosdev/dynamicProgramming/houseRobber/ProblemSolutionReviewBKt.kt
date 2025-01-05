package com.buenosdev.dynamicProgramming.houseRobber

import java.util.*

class ProblemSolutionReviewBKt {

    fun rob(nums: IntArray): Int {
        val memory = IntArray(nums.size + 1)

        Arrays.fill(memory, -1)

        recursion(nums, memory, nums.size - 1)

        return memory[0]
    }

    fun recursion(nums: IntArray, memory: IntArray, n: Int): Int {
        if (n < 0) return 0;

        if (memory[n] > -1) return memory[n]


        memory[n] = Math.max(nums[n] + recursion(nums, memory, n - 2), recursion(nums, memory, n - 1))

        return memory[n]
    }


    fun robFAILED(nums: IntArray): Int {
        if (nums.size == 1) return nums[0];
        if (nums.size == 2) return Math.max(nums[0], nums[1])

        var dp = IntArray(nums.size);
        dp[nums.size - 1] = nums[nums.size - 1]

        for (i in nums.size - 3 downTo 0) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1])

            var currentL = nums[i];
        }

        return Math.max(dp[0], dp[1])

    }
}