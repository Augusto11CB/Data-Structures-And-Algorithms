package com.buenosdev.stack.reversevowels

import java.util.*

class ProblemSolution {

    /*
    * https://leetcode.com/problems/reverse-vowels-of-a-string/
    * */

    private fun isVowel(c: Char): Boolean {
        val auxC = c.lowercaseChar()
        return auxC == 'a' || auxC == 'e' || auxC == 'i' || auxC == 'o' || auxC == 'u'

    }

    fun reverseVowels(s: String): String {

        var stackOfVowels = Stack<Char>()

        for (c in s.toCharArray()) {
            if (isVowel(c)) {
                stackOfVowels.add(c)
            }
        }

        val sb = StringBuilder(s)

        for (i in 0 until s.length) {
            if (isVowel(sb.get(i))) sb.set(i, stackOfVowels.pop())

        }

        return sb.toString()
    }

    fun reverseVowelsTwo(s: String): String {
        val vowels = "aeiouAEIOU"

        val charArray = s.toCharArray()
        var rightPointer = s.length - 1
        var leftPointer = 0

        while (leftPointer < rightPointer) {
            while (leftPointer < rightPointer &&
                vowels.indexOf(charArray[leftPointer]) == -1
            ) {
                leftPointer = leftPointer + 1
            }
            while (leftPointer < rightPointer &&
                vowels.indexOf(charArray[rightPointer]) == -1
            ) {
                rightPointer = rightPointer - 1
            }

            val auxL = charArray[leftPointer]
            charArray[leftPointer] = charArray[rightPointer]
            charArray[rightPointer] = auxL

            leftPointer = leftPointer + 1
            rightPointer = rightPointer - 1
        }

        return String(charArray)
    }
}