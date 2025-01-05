package com.buenosdev.dynamicProgramming.houseRobber

class ProblemSoluitonKt {
    fun rob(nums: IntArray): Int {

        // A robber has two options at each house:
        // a) Rob the current house i.
        // b) Don't rob the current house.

        // If option a) is selected, the robber cannot rob the previous house i-1, 
        // but can safely rob the house before the previous one i-2 and all the cumulative loot following that.

        // If option b) is selected, the robber gets all the possible loot from robbing the previous house i-1
        // and any loot captured before that.

        // Thus, the problem boils down to calculating which of the two options is more profitable:
            // 1. Robbing the current house + the loot from houses before the previous one.
            // 2. Loot from the previous house robbery and any loot captured before that.

        // Hence, the formula becomes:
            // rob(i) = Math.max(rob(i - 2) + currentHouseValue, rob(i - 1))

        if (nums.isEmpty()) return 0
        if (nums.size == 1) return nums[0]

        // Create an array to store the maximum amount of money that can be robbed up to each house
        val dp = IntArray(nums.size)

        // Base cases:
        // If there's only one house, rob that house.
        // If there are two houses, rob the house with the maximum value.
        dp[0] = nums[0]
        dp[1] = Math.max(nums[0], nums[1])

        // Fill the dp array iteratively:
        // For each house starting from the third one (index 2), calculate the maximum amount of money
        // that can be robbed by either robbing the current house and adding the value of the house two steps before,
        // or by not robbing the current house and taking the maximum loot up to the previous house.
        for (i in 2 until nums.size) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2])
        }

        // The last element of the dp array contains the maximum amount of money that can be robbed from all houses.
        return dp[dp.size - 1]
    }
}