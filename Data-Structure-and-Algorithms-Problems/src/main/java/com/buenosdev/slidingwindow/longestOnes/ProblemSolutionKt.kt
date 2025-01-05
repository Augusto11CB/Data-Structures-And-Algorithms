package com.buenosdev.slidingwindow.longestOnes

class ProblemSolutionKt {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var windowStart = 0
        var maxLen = Int.MIN_VALUE
        var kAux = k

        for (windowEnd in 0 until nums.size) {
            kAux -= 1 - nums[windowEnd]

            if (kAux < 0) {

                kAux += (1 - nums[windowStart])
                windowStart += 1
            } else {
                maxLen = Math.max(maxLen, (windowEnd - windowStart + (1)))
            }
        }

        return maxLen
    }






    /*
    *
    * The approach is to use a sliding window to scan the array from left to right. Two pointers, windowStart and windowEnd,
    * are used to represent the current window. If the current number is 0 (nums[windowEnd] == 0), kAux is decremented.
    * If kAux becomes less than 0, it means that the window contains more than k zeros, so the window needs to be moved
    * forward (windowStart += 1). If the number at the start of the window is 0 (nums[windowStart] == 0), kAux is
    * incremented because we are leaving a zero out of the window. The maximum length of a window that contains
    * at most k zeros is updated at each step (maxLen = Math.max(maxLen, (windowEnd - windowStart + (1)))).
    * The function finally returns maxLen, which is the maximum length of a subarray with at most k zeros.
    * This approach ensures that the algorithm scans the array only once, making it efficient. The time complexity is O(n),
    * where n is the length of the array. The space complexity is O(1), as no extra space is used.
    * */
    fun longestOnesTwo(nums: IntArray, k: Int): Int {
        var windowStart = 0
        var maxLen = 0
        var kAux = k

        for (windowEnd in 0 until nums.size) {
            if (nums[windowEnd] == 0) {
                kAux -= 1
            }

            if (kAux < 0) {
                if (nums[windowStart] == 0) kAux += 1
                windowStart += 1
            } else {
                maxLen = Math.max(maxLen, (windowEnd - windowStart + (1)))
            }

        }

        return maxLen
    }
}