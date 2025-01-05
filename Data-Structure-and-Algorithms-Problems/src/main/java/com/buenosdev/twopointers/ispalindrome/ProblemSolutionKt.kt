package com.buenosdev.twopointers.ispalindrome

class ProblemSolutionKt {

    /*
    * https://leetcode.com/problems/valid-palindrome
    * */

    fun isPalindrome(s: String): Boolean {

        val charArray = s.toCharArray()
        var rightPointer = s.length - 1
        var leftPointer = 0

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(charArray[leftPointer])) { // move i forward until a letter or digit is found
                leftPointer += 1
            }
            while (leftPointer < rightPointer && !Character.isLetterOrDigit(charArray[rightPointer])) {
                rightPointer -= 1
            }

            if (charArray[leftPointer].lowercaseChar() != charArray[rightPointer].lowercaseChar()) return false
            leftPointer += 1
            rightPointer -= 1
        }
        return true
    }

    fun isPalindromeTwo(s: String): Boolean {
        val output = s.replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()

        val charArray = output.toCharArray()
        var rightPointer = output.length - 1
        var leftPointer = 0

        while (leftPointer < rightPointer) {
            if (charArray[leftPointer].lowercaseChar() != charArray[rightPointer].lowercaseChar()) return false
            leftPointer = leftPointer + 1
            rightPointer = rightPointer - 1
        }
        return true
    }
}