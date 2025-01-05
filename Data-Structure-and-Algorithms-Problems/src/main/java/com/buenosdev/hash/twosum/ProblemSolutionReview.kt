package com.buenosdev.hash.twosum

class ProblemSolutionReview {

    /*
    https://leetcode.com/problems/two-sum/description/
     * */

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashComplement = HashMap<Int, Int>()

        for (i in 0 until nums.size) {
            var num = nums[i]
            var complement = target - num

            if (hashComplement.contains(complement)) {
                return intArrayOf(i, hashComplement[complement]!!)
            } else {
                hashComplement.put(num, i)
            }

        }

        return intArrayOf()
    }

}