package com.buenosdev.twopointers.threesum

import java.util.*


class Solution {

    /*
    * https://leetcode.com/problems/3sum/description/
    * */

//    Sort the input array
//    Initialize a set to store the unique triplets and an output vector to store the final result
//    Iterate through the array with a variable i, starting from index 0.
//    Initialize two pointers, j and k, with j starting at i+1 and k starting at the end of the array.
//    In the while loop, check if the sum of nums[i], nums[j], and nums[k] is equal to 0. If it is, insert the triplet into the set and increment j and decrement k to move the pointers.
//    If the sum is less than 0, increment j. If the sum is greater than 0, decrement k.
//    After the while loop, iterate through the set and add each triplet to the output vector.
//    Return the output vector

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

    fun threeSumClosestTwo(nums: IntArray, target: Int): Int {
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

    fun threeSum(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums);
        val setOfTriples = HashSet<List<Int>>()
        var listOfTriples = ArrayList<List<Int>>()

        for (i in 0 until nums.size) {
            var leftP = i + 1
            var rightP = nums.size - 1

            while (leftP < rightP) {
                var sum = nums[i] + nums[leftP] + nums[rightP]
                if (sum == 0) {
                    setOfTriples.add(listOf(nums[i], nums[leftP], nums[rightP]))
                    leftP = leftP + 1
                    rightP = rightP - 1
                } else if (sum < 0) {
                    leftP = leftP + 1
                } else if (sum > 0) {
                    rightP = rightP - 1
                }
            }
        }

        listOfTriples.addAll(setOfTriples)
        return listOfTriples
    }

// O(nlogn) -> sorting
// O(n^2) + O(nlogn)

    fun threeSumTwo(arr: IntArray): List<List<Int>> {
        Arrays.sort(arr)
        val triplets: MutableList<List<Int>> = ArrayList()
        for (i in 0 until arr.size - 2) {
            if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
                continue
            searchPair(arr, -arr[i], i + 1, triplets)
        }
        return triplets
    }

    private fun searchPair(
        arr: IntArray, targetSum: Int,
        left: Int, triplets: MutableList<List<Int>>
    ) {
        var left = left
        var right = arr.size - 1
        while (left < right) {
            val currentSum = arr[left] + arr[right]
            if (currentSum == targetSum) { // found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]))
                left++
                right--
                while (left < right && arr[left] == arr[left - 1]) left++ // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1]) right-- // skip same element to avoid duplicate triplets
            } else if (targetSum > currentSum) left++ // we need a pair with a bigger sum
            else right-- // we need a pair with a smaller sum
        }
    }

}