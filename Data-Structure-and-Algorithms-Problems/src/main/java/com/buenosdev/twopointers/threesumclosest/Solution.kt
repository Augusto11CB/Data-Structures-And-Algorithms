package com.buenosdev.twopointers.threesumclosest

import java.util.*


class Solution {

    /*
    * https://leetcode.com/problems/3sum-closest/
    * */

    fun threeSumClosest(arr: IntArray?, targetSum: Int): Int {
        require(!(arr == null || arr.size < 3))
        Arrays.sort(arr)
        var smallestDifference = Int.MAX_VALUE
        for (i in arr.indices) {
            var left = i + 1
            var right = arr.size - 1
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                val targetDiff = targetSum - arr[i] - arr[left] - arr[right]
                if (targetDiff == 0) //  we've found a triplet with an exact sum
                    return targetSum // return sum of all the numbers

                // the second part of the above 'if' is to handle the smallest sum when we have
                // more than one solution
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)) smallestDifference =
                    targetDiff // save the closest and the biggest difference
                if (targetDiff > 0) left++ // we need a triplet with a bigger sum
                else right-- // we need a triplet with a smaller sum
            }
        }
        return targetSum - smallestDifference
    }

    fun threeSumClosestFAILED(nums: IntArray, target: Int): Int {
        val count = nums.count { x -> x == 0 }
        if (count == nums.size) return 0

        Arrays.sort(nums);

        var minTargetDiff = Int.MAX_VALUE

        for (i in 0 until nums.size) {
            var leftP = i + 1
            var rightP = nums.size - 1

            while (leftP < rightP) {

                var sum = target - (nums[i] + nums[leftP] + nums[rightP])

                if (target == 0) {
                    return target
                }

                if (Math.abs(sum) < Math.abs(minTargetDiff)
                    || (Math.abs(sum) == Math.abs(minTargetDiff) && sum > minTargetDiff)
                )
                    minTargetDiff = sum; // save the closest and the biggest difference }

                if (sum > 0)
                    leftP = leftP + 1; // we need a triplet with a bigger sum
                else
                    rightP = rightP - 1; // we need a triplet with a smaller sum
            }

        }

        return minTargetDiff
    }

}