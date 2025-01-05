package com.buenosdev.slidingwindow.lengthOfLongestSubstringKDistinct

class Solution {

    /*
    * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
    *
    * */

    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {

        var maxLen = Int.MIN_VALUE
        var windowStart = 0
        val mapFrequency = HashMap<Char, Int>()
        val sArray = s.toCharArray()

        for (windowEnd in 0 until sArray.size) {
            mapFrequency.put(sArray[windowEnd], mapFrequency.getOrDefault(sArray[windowEnd], 0) + 1)

            while (mapFrequency.size > k) {
                val charToRemoveWindowStart = sArray[windowStart]
                mapFrequency.put(sArray[windowEnd], mapFrequency.get(charToRemoveWindowStart)!! - 1)
                if (mapFrequency.get(charToRemoveWindowStart) == 0) mapFrequency.remove(charToRemoveWindowStart)
                windowStart++
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart + (1))
        }

        return maxLen
    }
}