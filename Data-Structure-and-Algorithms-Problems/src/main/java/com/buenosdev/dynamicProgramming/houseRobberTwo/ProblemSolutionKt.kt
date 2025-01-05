package com.buenosdev.dynamicProgramming.houseRobberTwo

class ProblemSolutionKt {
    fun rob(nums: IntArray): Int {
        // If there is only one house, return its value as there's no other house to consider.
        if (nums.size == 1) return nums[0]

        // The problem is solved by considering two scenarios:
        // 1. Robbing houses from the first to the second-to-last house.
        // 2. Robbing houses from the second to the last house.
        // This is done because robbing the first and the last house together is not allowed.
        val skipLastHouse = robHouse(nums.copyOfRange(0, nums.size - 1))
        val skipFirstHouse = robHouse(nums.copyOfRange(1, nums.size))

        // The result is the maximum money that can be robbed from the two scenarios.
        return Math.max(skipLastHouse, skipFirstHouse)
    }

    fun robHouse(nums: IntArray): Int {
        // If there are no houses, return 0 as there's nothing to rob.
        if (nums.isEmpty()) return 0

        // If there's only one house, return its value.
        if (nums.size == 1) return nums[0]

        // Create an array to store the maximum amount of money that can be robbed up to each house.
        val dp = IntArray(nums.size)

        // Base cases:
        // dp[0] is the maximum money robbed from the first house, which is just nums[0].
        // dp[1] is the maximum money robbed from the first two houses, which is the maximum of nums[0] and nums[1].
        dp[0] = nums[0]
        dp[1] = Math.max(nums[0], nums[1])

        // Fill the dp array iteratively:
        // For each house starting from the third one (index 2), calculate the maximum amount of money
        // that can be robbed by either:
        // - Robbing the current house and adding the value of the house two steps before.
        // - Not robbing the current house and taking the maximum loot up to the previous house.
        for (i in 2 until nums.size) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2])
        }

        // The last element of the dp array contains the maximum amount of money that can be robbed from all houses.
        return dp[dp.size - 1]
    }
}
