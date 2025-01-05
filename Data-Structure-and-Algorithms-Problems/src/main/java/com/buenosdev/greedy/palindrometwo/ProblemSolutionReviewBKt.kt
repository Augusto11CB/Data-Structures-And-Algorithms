package com.buenosdev.greedy.palindrometwo

class Solution {
    fun validPalindrome(s: String): Boolean {
        var j = s.length - 1
        var i = 0
        while (i < j) {
            if (s[i] != s[j]) {
                val excludingCurrentI = isPalindrome(s, i + 1, j)
                val excludingCurrentJ = isPalindrome(s, i, j - 1)
                return excludingCurrentJ || excludingCurrentI
            } else {
                i++
                j--
            }
        }
        return true
    }

    private fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        var i = i
        var j = j
        while (i < j) {
            if (s[i] != s[j]) {
                return false
            } else {
                i++
                j--
            }
        }
        return true
    }
}