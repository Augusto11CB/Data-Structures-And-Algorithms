package com.buenosdev.slidingwindow.longestSubstring

class Solution {

    /*
    * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
    *
    * */

    fun longestSubstring(s: String, k: Int): Int {
        var ans = 0
        val freq = IntArray(26)
        val n = s.length

        for (i in 0 until n) {
            freq[s[i] - 'a']++
        }

        var unique = 0
        for (i in 0 until 26) {
            if (freq[i] != 0) {
                unique++
            }
        }

        for (currUnique in 1..unique) {
            freq.fill(0)
            var start = 0
            var end = 0
            var cnt = 0
            var countK = 0

            while (end < n) {
                if (cnt <= currUnique) {
                    val ind = s[end] - 'a'
                    if (freq[ind] == 0) {
                        cnt++
                    }
                    freq[ind]++
                    if (freq[ind] == k) {
                        countK++
                    }
                    end++
                } else {
                    val ind = s[start] - 'a'
                    if (freq[ind] == k) {
                        countK--
                    }
                    freq[ind]--
                    if (freq[ind] == 0) {
                        cnt--
                    }
                    start++
                }
                if (cnt == currUnique && countK == currUnique) {
                    ans = maxOf(ans, end - start)
                }
            }
        }
        return ans
    }


    fun longestSubstringFAIL(s: String, k: Int): Int {
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